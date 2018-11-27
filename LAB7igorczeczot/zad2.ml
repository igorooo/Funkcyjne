type 'a llist= LNil| LCons of 'a * (unit -> 'a llist);;
let rec lfrom k = LCons(k, function () -> lfrom(k+1));;

let rec ltake = function
  |(0,_) -> []
  |(_,LNil) -> []
  |(n, LCons(x,xf)) -> x::ltake(n-1,xf())
;;

let rec lmulti list cur=
  let rec multiE elem am = if am > 0 then LCons(elem, function() -> multiE elem (am-1)) else LNil
  in match list with
    |LNil -> LNil
    |LCons(h,t) -> if h <> cur then LCons(multiE h h, function() -> lmulti (t()) h) else lmulti(t()) h
;;

let listA = lfrom 1;;

let listB = lmulti listA 0;;

ltake(10, listB);;


let rec multiE elem am = if am > 0 then LCons(elem,fun() -> multiE elem (am-1)) else LNil;;

ltake(10, multiE 1 5);;
