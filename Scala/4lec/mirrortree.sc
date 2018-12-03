sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A,left:BT[A],right:BT[A]) extends BT[A]


def mirrorTree[A](tree:BT[A]):BT[A] = {
  tree match {
    case Empty => Empty
    case Node(a,l,r) => Node(a,mirrorTree(r),mirrorTree(l))
  }
}

val t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty)
mirrorTree(t)

val tt = Node(1,Node(2,Node(3,Node(4,Empty,Empty),Empty),Empty),Empty)
mirrorTree(t)

val ttt = Node(1,Node(2,Empty,Empty),Empty)
mirrorTree(ttt)




