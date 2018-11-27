type 'a llist= LNil| LCons of 'a * (unit -> 'a llist);;

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

(* Wlasciwa funkcja *)

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
