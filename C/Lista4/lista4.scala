/** Zadanie 1 */
def curry3[a1, a2, a3, b](f: a1 => a2 => a3 => b): (a1, a2, a3) => b =
  (x1, x2, x3) => f(x1)(x2)(x3)
def uncurry3[a1, a2, a3, b](f: (a1, a2, a3) => b): a1 => a2 => a3 => b =
  x1 => x2 => x3 => f(x1, x2, x3)

/** Zadanie 2 */
def addAndMul(list: List[Int]) = list.foldLeft(1, 0)((acc, current) => (current * acc._1, current + acc._2))
def addAndMul(list: List[Int]) = ((1, 0) /: list)((acc, current) => (current * acc._1, current + acc._2))

/** Zadanie 4 */
def isGreater(a: Int, b: Int) = a > b

def insertionsort[A](isGreater: (A, A) => Boolean, list: List[A]): List[A] = {
    def insert(element: A, list: List[A]): List[A] = {
      list match {
        case Nil => List(element)
        case h :: t =>
          if (isGreater(element, h)) h :: insert(element, t)
          else element :: h :: t
      }
    }
  list match {
    case Nil    => Nil
    case h :: t => insert(h, insertionsort(isGreater, t))
  }
}

insertionsort(((a: (Int, Int), b: (Int, Int)) => a._1 > b._1), List((4, 2), (3, 7), (3, 1), (5, 6)))
// List[(Int, Int)] = List((3,7), (3,1), (4,2), (5,6))

insertionsort(((a: (Int, Int), b: (Int, Int)) => a._2 > b._2), List((4, 2), (3, 7), (3, 1), (5, 6)))
// List[(Int, Int)] = List((3,1), (4,2), (5,6), (3,7))

def mergesort[A](isLess: (A, A) => Boolean, list: List[A]): List[A] = {
    def merge(l1: List[A], l2: List[A]): List[A] = {
      (l1, l2) match {
        case (Nil, Nil) => Nil
        case (l, Nil)   => l
        case (Nil, l)   => l
        case (h1 :: t1, h2 :: t2) =>
          if (isLess(h1, h2)) h1 :: merge(t1, h2 :: t2)
          else h2 :: merge(h1 :: t1, t2)
      }
    }
    def divide(list: List[A]): (List[A], List[A]) = {
      list match {
        case Nil | List(_) => (list, Nil)
        case h :: t =>
          var (t1, t2) = divide(t)
          (h :: t2, t1)
      }
    }
  list match {
    case Nil | List(_) => list
    case h :: t =>
      var (l1, l2) = divide(list)
      merge(mergesort(isLess, l1), mergesort(isLess, l2))
  }
}

mergesort(((a: (Int, Int), b: (Int, Int)) => a._1 < b._1), List((4, 2), (3, 7), (3, 1), (5, 6)))
// List[(Int, Int)] = List((3,7), (3,1), (4,2), (5,6))

mergesort(((a: (Int, Int), b: (Int, Int)) => a._2 < b._2), List((4, 2), (3, 7), (3, 1), (5, 6)))
// List[(Int, Int)] = List((3,1), (4,2), (5,6), (3,7)