module M =
( struct 
    type buffer = int ref
    let create() = ref 0
    let add x = incr x
    let get x = if !x>0 then (decr x;!x) else failwith "Empty"
  end
: sig
    type buffer
    val create : unit -> buffer
    val add : buffer -> unit
    val get : buffer -> int
  end
) ;;


let a  = M.create ();;

M.add a;;

M.get a;;

let str = "alamakota";;
let str1 = "alamakota";;
str = str1;;