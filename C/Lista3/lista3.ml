type 'a bt = Empty | Node of 'a * 'a bt * 'a bt

let tt = Node(1,
		Node(2,
			Node(4,
				Empty,
				Empty),
			Empty),
		Node(3,
			Node(5,
				Empty,
				Node(6,
					Empty,
					Empty)),
			Empty))
			
let breadth t =
	let rec breadthHelp el =
		match el with
		| [] -> []
		| Empty :: t -> breadthHelp t
		| Node(v, l, r) :: t -> v :: breadthHelp (t @ (l :: r :: []))
	in breadthHelp [t]
	
	breadth tt
			
let externPath bt =
	let rec eRec (bt, acc) =
		match bt with
		| Empty -> acc
		| Node(v, l, r) -> eRec (l, acc + 1) + eRec(r, acc + 1)
	in eRec (bt, 0)
	
let internPath bt =
	let rec iRec (bt, acc, temp) =
		match bt with
		| Node(v, Empty, Empty) -> acc
		| Node(v, l, Empty) -> iRec(l, acc + temp, temp + 1)
		| Node(v, Empty, r) -> iRec(r, acc + temp, temp + 1)
		| Node(v, l, r) -> iRec(l, acc + 1, temp + 1) + iRec(r, acc + 1, temp + 1) 
  in iRec(bt, 0, 1)
	
	externPath tt
	internPath tt

let rec preorder bt = match bt with
	| Node(v, l, r) -> v :: (preorder l) @ (preorder r)
	| Empty -> []

let preorderOpt bt =
	let rec preord = function
		| (Empty, labels) -> labels
		| (Node(v, t1, t2), labels) -> v :: preord (t1, preord (t2, labels))
	in preord (bt, [])

let rec postorder bt = match bt with
	| Node(v, l, r) -> (postorder l) @ (postorder r) @ [v]
	| Empty -> []

let postorderOpt bt =
	let rec postord = function
		| (Empty, labels) -> labels
		| (Node(v, t1, t2), labels) -> postord (t2, postord (t1, v :: labels))
	in postord (bt, [])

let rec inorder bt = match bt with
	| Node(v, l, r) -> (inorder l) @ v :: (inorder r)
	| Empty -> []

let inorderOpt bt =
	let rec inord p = match p with
		| (Empty, labels) -> labels
		| (Node(v, t1, t2), labels) -> inord (t1, v :: inord (t2, labels))
	in inord (bt, [])
		
		preorder tt
		preorderOpt tt
		postorder tt
		postorderOpt tt
		inorder tt
		inorderOpt tt