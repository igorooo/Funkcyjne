let rec flatten1 listOfLists = 
	if listOfLists = [] then []
	else List.hd listOfLists @ flatten1 (List.tl listOfLists);;

let rec count (element, list) = 
	if list = [] then 0
	else (if element = List.hd list then 1 else 0) + count(element, List.tl list);;
		
let rec duplicate (element, count) = 
	if count <= 0 then []
	else element :: duplicate (element, count - 1);;

let rec sqrList list = 
	if list == [] then []
	else let head = List.hd list in head * head :: sqrList (List.tl list);;

let palindrome list = list = List.rev list;;

let rec listLength list = 
	if list = [] then 0
	else 1 + listLength (List.tl list);;
		
let rec listAppend (firstList, secondList) = 
	if firstList = [] then secondList
	else List.hd firstList :: listAppend (List.tl firstList, secondList);;