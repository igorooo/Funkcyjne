import scala.annotation.tailrec

//tailrecursion 
def split[A](list:List[A]):(List[A],List[A]) = {

  @tailrec
  def rec(i: Int,list: List[A],l1: List[A],l2: List[A]):(List[A],List[A]) = {

    list match {
      case Nil => (l1,l2)
      case h::t =>
        if(i % 2 == 0) rec( i+1 , t, l1 :+ h, l2) else rec( i+1 , t, l1, l2 :+h)

    }
  }

  rec(0,list,List(),List())

}

split(List(1,2,3,4,5,6,7))
split(List())
split(List(1))

//recursion
def split2[A](list:List[A]):(List[A],List[A]) = {

  def rec(i: Int,list: List[A]):(List[A],List[A]) = {

    list match {
      case Nil => (Nil,Nil)
      case h::t =>
        if(i % 2 == 0) (h::rec(i+1,t)._1, rec(i+1,t)._2) else (rec(i+1,t)._1, h::rec(i+1,t)._2)

    }
  }
  rec(0,list)
}

split2(List(1,2,3,4,5,6,7))
split2(List())
split2(List(1))