(** Zadanie 1 *)
(* a) *)
module type QUEUE_FUN =
sig
	type 'a t
	exception Empty of string
	(* Raised when [first] is applied to an empty queue. *)
	val empty: unit -> 'a t
	(* Return a new empty queue. *)
	val enqueue: 'a * 'a t -> 'a t
	(* [enqueue (x,q)] adds the element [x] at the end of queue [q]. *)
	val dequeue: 'a t -> 'a t
	(* [dequeue q] removes the first element in queue [q] *)
	val first: 'a t -> 'a
	(* [first q] returns the first element in queue [q] without removing it  *)
	(* from the queue, or raises [Empty] if the queue is empty.              *)
	val isEmpty: 'a t -> bool
(* [isEmpty q] checks if queue has no elements. *)
end;;

module Queue2: QUEUE_FUN =
struct
	type 'a t = 'a list
	
	exception Empty of string
	
	let empty() = []
	
	let enqueue = function
		| e, [] -> [elem]
		| e, q -> q @ [elem]
	
	let dequeue = function
		| [] -> []	(*  dequeue (empty) = empty  *)
		| [_] -> []
		| _ :: t -> t
	
	let first = function
		| [] -> raise (Empty "Pusta kolejka")
		| h :: _ -> h
	
	let isEmpty queue = queue = []
end;;

(* b) *)
module Queue: QUEUE_FUN =
struct
	type 'a t = 'a list * 'a list
	
	exception Empty of string
	
	let empty() = [], []
	
	let enqueue(elem, queue) =
		match queue with
		| [], [] -> [elem], []
		| l1, l2 -> l1, elem :: l2
	
	let dequeue = function
		| [_], [] -> [], []
		| [_], l2 -> List.rev l2, []
		| _ :: t, l2 -> t, l2
		| [], [] -> [], []
	
	let first = function
		| [], [] -> raise (Empty "Pusta kolejka")
		| h :: _, _ -> h
		| _ -> raise (Empty "B��d implementacji!")
	
	let isEmpty queue = ([], []) = queue
end

(** Zadanie 2 *)
module type QUEUE_MUT =
sig
	type 'a t
	(* The type of queues containing elements of type ['a]. *)
	exception Empty of string
	(* Raised when [first q] is applied to an empty queue [q]. *)
	exception Full of string
	(* Raised when [enqueue(x,q)] is applied to a full queue [q]. *)
	val empty: int -> 'a t
	(* [empty n] returns a new queue of length [n], initially empty. *)
	val enqueue: 'a * 'a t -> unit
	(* [enqueue (x,q)] adds the element [x] at the end of a queue [q]. *)
	val dequeue: 'a t -> unit
	(* [dequeue q] removes the first element in queue [q] *)
	val first: 'a t -> 'a
	(* [first q] returns the first element in queue [q] without removing it  *)
	(* from the queue, or raises [Empty] if the queue is empty.              *)
	val isEmpty: 'a t -> bool
	(* [isEmpty q] returns [true] if queue [q] is empty, otherwise returns   *)
	(* [false].                                                              *)
	val isFull: 'a t -> bool
(* [isFull q] returns [true] if queue [q] is full, otherwise returns       *)
(* [false].                                                                *)
end

module Queue: QUEUE_MUT =
struct
	type 'a t = { mutable size : int; mutable f : int; mutable r : int; mutable a : 'a option array; }
	
	exception Empty of string
	exception Full of string
	
	let empty n = { size = n + 1; f = 0; r = 0; a = Array.create (n + 1) None }
	
	let isEmpty q = q.f = q.r
	let isFull q = (q.r + 1) mod q.size = q.f
	
	let first q =
		if isEmpty q then raise (Empty "Kolejka jest Pusta")
		else match q.a.(q.f) with
			| Some e -> e
			| None -> failwith "Implementation error!"
	
	let enqueue (elem, q) =
		if isFull q then raise (Empty "Kolejka jest Pelna")
		else
			(
				q.a.(q.r) <- Some elem;
				q.r <- (q.r + 1) mod q.size;
			)
	
let dequeue q =
	if isEmpty q then ()
	else (
		q.a.(q.f) <- None;
		q.f <- (q.f + 1) mod q.size;
		)
end