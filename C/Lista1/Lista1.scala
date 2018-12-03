def flatten[A](listOfLists: List[List[A]]): List[A] = {
	if (listOfLists == Nil) Nil
	else listOfLists.head ::: flatten(listOfLists.tail)
}

def count[A](element: A, list: List[A]): Int = {
	if (list == Nil) 0
	else (if (list.head == element) 1 else 0) + count(element, list.tail)
}

def duplicate[A](element: A, count: Int): List[A] = {
	if (count <= 0) Nil
	else element :: duplicate(element, count - 1)
}

def sqrList(intList: List[Int]): List[Int] = {
	if (intList == Nil) Nil
	else intList.head * intList.head :: sqrList(intList.tail)
}

def palindrome[A](list: List[A]) = list == list.reverse

def listLength[A](list: List[A]): Int = {
	if (list == Nil) 0
	else 1 + listLength(list.tail)
}

def listAppend[A](firstList: List[A], secondList: List[A]): List[A] = {
	if (firstList != Nil) firstList.head :: listAppend(firstList.tail, secondList)
	else secondList
}