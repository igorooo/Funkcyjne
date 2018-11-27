
type 'a krotka2 = int * 'a;;

let (x:'a krotka2) = (1,2);;


type ('a,'b) liczba = A of 'a | B of 'b;;

let str = ["ala";"ma";"kota"] and tab = [1;2;3;4];;

let res =  (List.map (function x -> A x) str) @ (List.map (function x -> B x) tab);;

let re = List.hd res;;

let f() = 2+5;;

f();;

type 'a llist= LNil| LCons of 'a * (unit -> 'a llist);;

let rec lfrom k = LCons(k, function () -> lfrom(k+1));;

lfrom 2;;

let primes = 
  let rec sieve = function
  |LCons(p,nf) -> LCons(p, function() -> sieve (lfilter (fun n -> n mod p <> 0) (nf()) )   )
  |LNil -> failwith "Impossible!"
  in sieve(lfrom 2)
;;

let rec ltakeWithTail = function
  |(0,xq) -> ([],xq)
  |(_,LNil) -> ([],LNil)
  |(n , LCons(x,xf)) ->  let (l, tail) = ltakeWithTail(n-1,xf()) in (x::l,tail)

ltake(10,primes);;



