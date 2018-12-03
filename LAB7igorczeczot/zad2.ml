type 'a llist= LNil| LCons of 'a * (unit -> 'a llist);;

let rec lfrom k = LCons(k, function () -> lfrom(k+1));;

let rec ltake = function
  |(0,_) -> []
  |(_,LNil) -> []
  |(n, LCons(x,xf)) -> x::ltake(n-1,xf())
;;

(*FUNCKJA WLASCIWA*)

let lMult lista = 
  let rec lmulti list cur=
    match list with
      |LNil -> LNil
      |LCons(h,t) -> if cur > 0 then LCons(h, function() -> lmulti list (cur-1)) 
                     else match t() with
                      |LNil -> LNil
                      |LCons(hd,tl) -> lmulti (t()) hd
  in lmulti (LCons(0, function() -> lista)) 0
;;


let listA = lfrom 0;;

let listB = lMult listA;;

ltake(16, listB);;


let listBB = lMult listB;;

ltake(16, listBB);;


let listBBB = lMult listBB;;

ltake(16, listBBB);;
