type 'a llist = LNil | LCons of 'a * (unit -> 'a llist)

(* Zadanie 1 *)
let rec replicateElements (k, list) =
	let rec replicate = function
		| (_, LNil) -> LNil
		| (n, LCons(h, xf)) -> 
			if n = 0 then replicate(k, xf())
			else LCons(h, fun () -> replicate (n - 1, xf()))
	in replicate(k, list)
	
(* Zadanie 2 *)
let lfib =
	let rec fib (number, acc) =
		LCons(number, fun () -> fib(acc, number + acc))
	in fib(0, 1)

(* Zadanie 3 *)
type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT)

(* a) *)
let rec lTree n =
	LNode(n, (fun () -> lTree(2 * n)), (fun () -> lTree(2 * n + 1)))

(* b) *)
let breadth ltree =
	let rec breadthHelp = function
		| [] -> LNil
		| LEmpty :: t -> breadthHelp t
		| LNode(v, l, r) :: t ->
				LCons(v, fun () -> breadthHelp (t @ (l() :: r() :: [])))
	in breadthHelp [ltree]