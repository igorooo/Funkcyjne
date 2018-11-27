

type 'a llist= LNil| LCons of 'a * (unit -> 'a llist);;

let rec lfrom k = LCons(k, function () -> lfrom(k+1));;

let rec toLazyList = function
  |[] -> LNil
  |h::t -> LCons(h, function() -> toLazyList t)
;;

let rec lmap f = function
  |LNil -> LNil
  |LCons(x,xf) -> LCons(f x, function() -> lmap f (xf()) )
;;

let rec lfilter pred = function
  |LNil -> LNil
  |LCons(x,xf) -> if pred x then LCons(x,function() -> lfilter pred (xf()))
                  else lfilter pred (xf())
;;

let rec toList = function
  |LNil -> []
  |LCons(x,xf) -> x::toList(xf())
;;

let rec ltake = function
  |(0,_) -> []
  |(_,LNil) -> []
  |(n, LCons(x,xf)) -> x::ltake(n-1,xf())
;;

let lhd = function
  |LNil -> failwith "lhd"
  |LCons (x, _) -> x
;;

let ltl = function
  |LNil -> failwith "ltl"
  |LCons (_, xtl) -> xtl()
;; 

let rec (@$) ll1 ll2 = 
  match ll1 with
  |LNil -> ll2
  |LCons(x,xf) ->  LCons(x,function() -> (xf()) @$ ll2 ) ;;


(* ZAD 1 *)

let rec lrepeat n (xs: 'a llist) =
  let rec repeat am wd = if am = 0 then LNil else LCons(wd,function()->repeat(am-1) wd)
  in
  match xs with
  |LNil -> LNil
  |LCons(x,xf) -> (repeat n x) @$ lrepeat n (xf());;


let lxs = toLazyList [1;2;3;4;5];;

let lrlist = lrepeat 3 lxs;;

toList lrlist;;

(* ZAD 2 *)

let lfib = 
  let rec fib a acc = LCons(a,function() -> fib acc (a+acc))
  in fib 0 1
;;

ltake(10, lfib);;

(* ZAD 3 *)

type 'a lBT = LEmpty | LNode of  'a * (unit ->'a lBT) * (unit -> 'a lBT);;

let rec lTree n = LNode(n , (function() -> lTree (2*n)) , (function() -> lTree (2*n+1)) );;


(*LAB6*)

(* ltake, lfrom i lfib do testowania *)

let rec ltake = function
  |(0,_) -> []
  |(_,LNil) -> []
  |(n, LCons(x,xf)) -> x::ltake(n-1,xf())
;;
let rec lfrom k = LCons(k, function () -> lfrom(k+1));;

let lfib = 
  let rec fib a acc = LCons(a,function() -> fib acc (a+acc))
  in fib 0 1
;;

let split listt = 
  let rec l1 cond i list =
    match list with 
    |LNil -> LNil
    |LCons(h,t) -> if cond i then LCons(h, function() -> l1 cond (i+1) (t()))
                   else l1 cond (i+1) (t())
  in (l1 (fun x -> x mod 2 = 0) 0 listt,l1 (fun x -> x mod 2 = 1) 0 listt )
;;


let (lista, listb) = split (lfrom(0));;
ltake(10, lista);;
ltake(10, listb);;
let (list1, list2) = split lfib;;
ltake(10, list1);;
ltake(10, list2);;





let rec upgrade ( i, list) =
  match list with
  |LNil -> LNil
  |LCons(h, t) -> LCons( (i, h), function() -> upgrade(i+1, t()) )
;;


let rec mapFor2 listA listB f =
  match (listA, listB) with
  |(LNil, LNil) -> LNil
  |(LNil, LCons(h,t)) -> LCons(h, function() -> (mapFor2 LNil (t()) f) )
  |(LCons(h,t), LNil) -> LCons(h, function() -> (mapFor2 LNil (t()) f) )
  |(LCons(h,t), LCons(h1,t1)) -> LCons(f h h1, function() -> (mapFor2 (t()) (t1()) f) )
;; 

ltake(10, mapFor2 lista listb (fun x y -> x*y));;

let pow n x = 
  let rec poww i = if i < x then n*poww(i+1) else 1
  in poww 0
;;



let strim n = let st = 1 in LCons(pow n st, function() -> pow n (st+1) );;




