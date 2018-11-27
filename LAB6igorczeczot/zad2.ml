type 'a llist= LNil| LCons of 'a * (unit -> 'a llist);;

(* ltake, lfrom i lfib i split do testowania *)

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

(* Wlasciwa funkcja *)

let rec mapFor2 listA listB f =
  match (listA, listB) with
  |(LNil, LNil) -> LNil
  |(LNil, LCons(h,t)) -> LCons(h, function() -> (mapFor2 LNil (t()) f) )
  |(LCons(h,t), LNil) -> LCons(h, function() -> (mapFor2 LNil (t()) f) )
  |(LCons(h,t), LCons(h1,t1)) -> LCons(f h h1, function() -> (mapFor2 (t()) (t1()) f) )
;; 



ltake(10, mapFor2 lista listb (+));;
ltake(10, mapFor2 lista listb (-));;
ltake(10, mapFor2 lista listb (fun x y -> x*y));;