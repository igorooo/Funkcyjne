

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




  
  

