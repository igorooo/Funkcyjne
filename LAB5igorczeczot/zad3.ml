
type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let asum root = 
  let rec countn node = 
    match node with
      |Empty -> 0
      |Node(v,node1,node2) -> 1 + countn node1 + countn node2
  and _asum node = 
    match node with
      |Empty -> 0
      |Node(v,node1,node2) -> v + _asum node1 + _asum node2
  in float_of_int(_asum root) /. (float_of_int(countn root)) ;;




asum(Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty));;
asum(Node(6,Node(2,Empty,Node(3,Empty,Empty)),Empty));;
asum(Node(0,Node(1,Empty,Empty),Node(2,Empty,Empty)));;
