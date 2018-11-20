
type krotka[A] = (Int,A)

val x:krotka[String] = (5,"ala")

def map[C,D](f:C => D)(xs:List[C]):List[D] = {

  if(xs == Nil) Nil else f(xs.head)::map (f)(xs.tail)

}

def f (a:Int):Char = {
  a match {
    case 1 => 'a'
    case 2 => 'b'
    case 3 => 'c'
    case 4 => 'd'
    case _ => 'x'
  }
}

map(f)(List(1,2,3,4,5,6,7))


sealed trait AB[+T1,+T2]
case class A[+T1,+T2](e:T1) extends AB[T1,T2]
case class B[+T1,+T2](e:T2) extends AB[T1,T2]

val tab = List(1,2,3,4)
val str = List("ala","ma","kota")

val conc:List[AB[String,Int]] =
  ( map((x:String) => A(x))(str) ) ++ ( map((x:Int) => B(x))(tab) )

sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem:A,left:BT[A],right:BT[A]) extends BT[A]

def nodes[A](root:BT[A]):Int = {
  root match {
    case Empty => 0
    case Node(_,n1,n2) => 1 + nodes(n1) + nodes(n2)
  }
}

val t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty)

nodes(t)




