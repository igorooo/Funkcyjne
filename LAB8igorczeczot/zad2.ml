type 'a llist= LNil| LCons of 'a * (unit -> 'a llist);;

let rec lfrom k = LCons(k, function () -> lfrom(k+1));;

let rec ltake = function
  |(0,_) -> []
  |(_,LNil) -> []
  |(n, LCons(x,xf)) -> x::ltake(n-1,xf())
;;

(*FUNKCJA WLASCIWA*)

let rec zip (l1, l2) = 
  match (l1,l2) with
  |(LNil,LNil) -> LNil
  |(l,LNil) -> l
  |(LNil,l) -> l
  |(LCons(hd1,tl1),LCons(hd2,tl2)) -> (LCons(hd1,fun() -> LCons(hd2,fun() -> zip (tl1(), tl2()))))
;;

let l1 = lfrom 0;;
let l2 = lfrom 100;;

ltake(10, zip(l1,l2));;