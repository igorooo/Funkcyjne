(** Zadanie 1 *)
let curry3 f x y z = f (x, y, z)
let curry = function f -> function x -> function y -> function z -> f (x, y, z)
(* val curry3 : ('a * 'b * 'c -> 'd) -> 'a -> 'b -> 'c -> 'd = <fun> *)

let uncurry3 f (x, y, z) = f x y z
(* val uncurry3 : ('a -> 'b -> 'c -> 'd) -> 'a * 'b * 'c -> 'd = <fun> *)

(** Zadanie 2 *)
let sumAndMul = List.fold_left ( fun acc current -> (fst acc * current, snd acc + current) ) (1, 0);;

(** Zadanie 3 *)
let rec quicksort = function
	| [] -> []
	| [x] -> [x]
	| xs ->
			let small = List.filter (fun y -> y < List.hd xs ) xs
			and large = List.filter (fun y -> y >= List.hd xs ) xs		(* Zapetlanie sie, pierwszy elelement nie jest usuwany *)
			in quicksort small @ quicksort large

let rec quicksort' = function
	| [] -> []
	| x :: xs ->
			let small = List.filter (fun y -> y < x ) xs
			and large = List.filter (fun y -> y > x ) xs				(* Usuwa powtarzajace sie elementy - wystarczy dodac = *)
			in quicksort' small @ (x :: quicksort' large)

(** Zadanie 4 *)
let isGreater a b = a > b

let rec insertionsort isGreater list =
	let rec insert element list =
		match list with
		| [] -> [element]
		| (h :: t) ->
				if isGreater element h then h :: (insert element t)
				else element :: h :: t
	in
	match list with
	| [] -> []
	| h :: t -> insert h (insertionsort isGreater t);;
				
				insertionsort (fun (a, _) (b, _) -> a > b) [(4, 2); (3, 7); (3, 1); (5, 6)]
				(* (int * int) list = [(3, 7); (3, 1); (4, 2); (5, 6)] *)
				
				insertionsort (fun (_, a) (_, b) -> a > b) [(5, 2); (3, 7); (3, 1); (4, 2)]
				(* (int * int) list = [(3, 1); (5, 2); (4, 2); (3, 7)] *)

let is_less a b = a < b

let rec mergesort is_less list =
	let rec merge = function
		| [], [] -> []
		| list, [] | [], list -> list
		| h1 :: t1, h2 :: t2 ->
				if is_less h1 h2 then
					h1 :: merge (t1, h2 :: t2)
				else
					h2 :: merge (h1 :: t1, t2)
	and
	divide list (acc1, acc2) =
		match list with
		| [] -> acc1, acc2
		| h :: t -> divide t (h :: acc2, acc1)
	in
	match list with
	| [] | [_] -> list
	| h :: t ->
			let l1, l2 = divide list ([], [])
			in	merge (mergesort is_less l1, mergesort is_less l2)
				
				mergesort (fun (a, _) (b, _) -> a < b) [(4, 2); (3, 7); (3, 1); (5, 6)]
				(* (int * int) list = [(3, 7); (3, 1); (4, 2); (5, 6)] *)
				
				mergesort (fun (_, a) (_, b) -> a < b) [(4, 2); (3, 7); (3, 1); (5, 6)]
				(* (int * int) list = [(3, 1); (4, 2); (5, 6); (3, 7)] *)