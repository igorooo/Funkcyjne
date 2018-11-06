

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

mergesort( ((a:Int,b:Int) => a < b), List(7,8,5,2,4,6,3))



def mergeSort[A](comp: (A,A) => Boolean, list:List[A]):List[A] ={

  def merge(l1:List[A], l2:List[A]):List[A] =
    (l1,l2) match {
      case (Nil,Nil) => Nil
      case (Nil, l) => l
      case (l, Nil) => l
      case (h1::t1, h2::t2) => if (comp(h1,h2))
    }


}











val przedzial:Int => Int =>List[Int] = a => b =>if(a>b) Nil else b::(przedzial(a)(b-1))

def przedziall(a:Int,b:Int):List[Int] = if (a > b) Nil else b::przedziall(a,b-1)

przedzial(1)(5)
przedziall(1,5)

def map[A,B](f:A=>B)(xs:List[A]):List[B] = xs match {
  case Nil => Nil
  case x::xs =>f(x)::map(f)(xs)
}


sealed trait AB[+T1, +T2]
case class A[+T1, +T2](e:T1) extends AB[T1,T2]
case class B[+T1, +T2](e:T2) extends AB[T1,T2]

val lStr = List("Ala ", "ma ","kota ")
val lInts = List(1,2,3)

val lsint:List[AB[String,Int]] =
  (map((x:String) => A(x))(lStr)) ::: (map((x:Int) => B(x)) (lInts))