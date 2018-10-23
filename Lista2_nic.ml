(* Testy *)
fibb(37)
fibb_tail(37)

root3 0.
root3 1.
root3 8.
root3 27.
root3 33.

initSegment [] []
initSegment [1; 2; 3] []
initSegment [] [1; 2; 3]
initSegment [1; 2] [1; 2; 3]
initSegment [1; 2] [3; 4]

replace_nth  ([], 1, 5)
replace_nth  ([1; 2; 3], 0, 5)
replace_nth  ([1; 2; 3], 1, 5)
replace_nth  ([1; 2; 3], 4, 5)

(* Zadanie 2 *)
  let rec fibb x =
		if x >= 0 then
			if x < 2 then x
			else fibb (x - 1) + fibb (x - 2)
		else failwith "IllegalArgumentException"
  	
  let fibb_tail n =
  	let rec help x acc res =
  		if x = 0 then acc
  		else help (x - 1) res (acc + res)	
  	in help n 0 1
		
(* Zadanie 3 *)
  let root3 a =
  	let rec help x = 
  		if abs_float(x ** 3. -. a) <= 1e-15 *. abs_float(a) then x
  		else help (x +. ( a /. (x ** 2.) -. x) /. 3.)
  	in help (if a >= 1. then a /. 3. else a)

(* Zadanie 4 *)
(* a) *)
  let [_; _; x; _; _] = [-2;  -1;  0;  1;  2]
(* b) *)
  let (_, _) :: (x, _) :: [] = [(1, 2); (0, 1)]

(* Zadanie 5 *)
  let rec initSegment = function
  	([], _) -> true
  	(h1 :: t1, h2 :: t2) -> h1 = h2 && initSegment(t1, t2)
  	_ -> false;;
			
(* Zadanie 6 *)
  let rec replace_nth (list, nth, elem) =
  	match list with
  	| [] -> []
  	| head :: tail ->
  		(if nth <> 0 then head else elem) :: replace_nth (tail, (nth - 1), elem)