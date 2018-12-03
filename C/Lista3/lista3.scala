object Main {

  sealed trait BT[+A]
  case object Empty extends BT[Nothing]
  case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]

  def preorder[A](bt: BT[A]): List[A] = bt match {
    case Node(v, l, r) => v :: preorder(l) ::: preorder(r)
    case Empty         => Nil
  }

  def preorderOpt[A](bt: BT[A]): List[A] = {
      def preord(p: (BT[A], List[A])): List[A] = p match {
        case (Empty, labels)           => labels
        case (Node(v, t1, t2), labels) => v :: preord(t1, preord(t2, labels))
      }
    preord(bt, Nil)
  }

  def postorder[A](bt: BT[A]): List[A] = bt match {
    case Node(v, l, r) => postorder(l) ::: postorder(r) ::: List(v)
    case Empty         => Nil
  }

  def postorderOpt[A](bt: BT[A]): List[A] = {
      def postord(p: (BT[A], List[A])): List[A] = p match {
        case (Empty, labels)           => labels
        case (Node(v, t1, t2), labels) => postord(t2, postord(t1, v :: labels))
      }
    postord(bt, Nil)
  }

  def inorder[A](bt: BT[A]): List[A] = bt match {
    case Node(v, l, r) => inorder(l) ::: v :: inorder(r)
    case Empty         => Nil
  }

  def inorderOpt[A](bt: BT[A]): List[A] = {
      def inord(p: (BT[A], List[A])): List[A] = p match {
        case (Empty, labels)           => labels
        case (Node(v, t1, t2), labels) => inord(t1, v :: inord(t2, labels))
      }
    inord(bt, Nil)
  }

  def e[A](bt: BT[A]) = {
      def eRec(bt: BT[A], acc: Int): Int = {
        bt match {
          case Empty         => acc
          case Node(v, l, r) => eRec(l, acc + 1) + eRec(r, acc + 1)
        }
      }
    eRec(bt, 0)
  }

  def i[A](bt: BT[A]) = {
      def iRec(bt: BT[A], acc: Int, temp: Int): Int = {
        bt match {
          case Node(v, Empty, Empty) => acc
          case Node(v, l, Empty)     => iRec(l, acc + temp, temp + 1)
          case Node(v, Empty, r)     => iRec(r, acc + temp, temp + 1)
          case Node(v, l, r)         => iRec(l, acc + 1, temp + 1) + iRec(r, acc + 1, temp + 1)
        }
      }
    iRec(bt, 0, 1)
  }

  def breadth[A](bt: BT[A]) = {
      def rec[A](list: List[A]): List[Any] = {
        list match {
          case Nil                => Nil
          case Empty :: t         => rec(t)
          case Node(v, l, r) :: t => v :: rec(t ::: (l :: r :: Nil))
        }
      }
    rec(List(bt))
  }

  def main(args: Array[String]): Unit = {

    val tt = Node(1,
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

    println(breadth(tt))

    println(postorder(tt))
    println(postorderOpt(tt))
    println()
    println(preorder(tt))
    println(preorderOpt(tt))
    println()
    println(inorder(tt))
    println(inorderOpt(tt))
  }
}