

sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]



def breadth[A](bt: BT[A]) = {
  def rec[A](list: List[A]): List[Any] = {
    list match {
      case Nil             => Nil
      case Empty :: t         => rec(t)
      case Node(v, l, r) :: t => v :: rec(t ::: (l :: r :: Nil))
    }
  }
  rec(List(bt))
}


val tt = Node(1,
  Node(2,
    Node(4,
      Empty,
      Empty),
    Empty),
  Node(3,
    Node(5,
      Empty,
      Node(9,
        Empty,
        Empty)),
    Empty))

breadth(tt)