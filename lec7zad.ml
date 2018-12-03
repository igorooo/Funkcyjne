
module type QUEUE_FUN =
sig
  type 'a t
  exception Empty of string
  val empty: unit -> 'a t
  val enqueue: 'a * 'a t -> 'a t
  val dequeue: 'a t -> 'a t
  val first: 'a t -> 'a
  val isEmpty: 'a t -> bool
end;;

module Queue : QUEUE_FUN = 
struct
  type 'a t = 'a list 
  exception Empty of string
  
  let empty() = []
  let enqueue (e, q) = match q with
                        | [] -> [e]
                        | l -> l@[e]
  let dequeue  = function
                | hd::tl -> tl
                | [] -> []
  let first = function
                | hd::tl -> hd
                |[] -> raise (Empty "empty queue")
  let isEmpty q = q = []

end ;;

let qq = Queue.empty ();;

let qq1 = Queue.enqueue (1, qq) ;;
let qq2 = Queue.enqueue (2, qq1) ;;
let qq3 = Queue.enqueue (3, qq2) ;;

Queue.first qq1 ;;
let qq22 = Queue.dequeue qq2;;
Queue.first qq33;;
Queue.first qq2;;
Queue.dequeue qq;;
Queue.first qq22;;

Queue.isEmpty qq;;


module DQueue : QUEUE_FUN = 
struct
  type 'a t = 'a list * 'a list
  exception Empty of string
  
  let empty() = [],[]
  let enqueue (e, q) = match q with
                        | [],[] -> [e],[]
                        | [],l2 -> List.rev (e::l2), []
                        | l1, l2 -> l1, e::l2
  let dequeue  = function
                | [],[] -> [],[]
                | [], l2 -> let hd::tl = (List.rev l2) in tl,[]
                | [felem],l2 -> (List.rev l2), []
                | hd::tl,l2 -> tl,l2
  let first = function
                | hd::tl,l2 -> hd
                |[],[] -> raise (Empty "empty queue")
  let isEmpty q = q = ([],[])
end ;;



let qq = DQueue.empty ();;

let qq1 = DQueue.enqueue (1, qq) ;;
let qq2 = DQueue.enqueue (2, qq1) ;;
let qq3 = DQueue.enqueue (3, qq2) ;;

DQueue.first qq1 ;;
let qq22 = DQueue.dequeue qq2;;
DQueue.first qq33;;
DQueue.first qq2;;
DQueue.dequeue qq;;
DQueue.first qq22;;

DQueue.isEmpty qq;;








module Queue : QUEUE_FUN = 
struct
  type 'a t = { mutable l: 'a list }
  exception Empty of string
  
  let empty() = { l = [] }
  let enqueue (e, q) = q.l <- e::q.l; q
  let dequeue q = match List.rev q.l with
                  | hd::tl -> q.l <- List.rev tl; q
                  |[] -> q
  let first q = match List.rev q.l with
                | hd::tl -> hd
                |[] -> raise (Empty "empty queue")
  let isEmpty q = q.l = []

end ;;
