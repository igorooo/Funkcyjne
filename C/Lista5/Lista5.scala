/** Zadanie 2 */
val lfib = {
    def fib(number: Int, acc: Int): Stream[Int] = Stream.cons(number, fib(acc, number + acc))
  fib(0, 1)
}




/** Zadanie 3 */
sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

// a)
def lTree(n: Int): lBT[Int] = LNode(n, () => lTree(2 * n), () => lTree(2 * n + 1))

// b)
def breadth[A](ltree: lBT[A]) = {
    def breadthHelp(el: List[lBT[A]]): Stream[A] = {
      el match {
        case Nil         => Stream.Empty
        case LEmpty :: t => breadthHelp(t)
        case LNode(v, l, r) :: t =>
          Stream.cons(v, breadthHelp(t ::: (l() :: r() :: Nil)))
      }
    }
  breadthHelp(List(ltree))
}