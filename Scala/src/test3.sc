import scala.annotation.tailrec


val xs = List("Ala", "ma", "koto","psa")

val p::o = xs


//zad4

val List(_,_,x,_,_) = List(-2,-1,0,1,2)

val List((_,_),(y,_)) = List((1, 2), (0, 1))


def root3(a:Double):Double = {

  def root_3(x:Double):Double = if( ((x*x*x) - a).abs <= 1e-15 * a.abs ) x
                                else  root_3(x + (a/(x*x) - x)/3)
  if(a >=1) root_3(a/3)
  else root_3(a)
}

root3(27)

val a  = List(1,2,3)
val b = List(4,5,6)

val c = a.head + b.head



def sum(a:List[Int],b:List[Int]):List[Int] =
  if (a == Nil && b == Nil ) List()
  else if ( a == Nil && b != Nil){ b.head :: sum(Nil,b.tail) }
  else if( a != Nil && b == Nil) a.head :: sum(a.tail, Nil)
  else ( a.head + b.head ) :: sum(a.tail,b.tail)



sum(List(1,2,3),List(4,5,6,7))


def suma(a:List[Int], b:List[Int]):List[Int] = (a,b) match{
  case (Nil, Nil) => List()
  case (Nil, _) => b.head :: suma(Nil,b.tail)
  case (_, Nil) => a.head :: suma(a.tail, Nil)
  case (_,_) => ( a.head + b.head ) :: suma(a.tail,b.tail)
}

suma(List(1,2,3,4,5,6,7),List(1,2,3))


def sumtl(a:List[Int],b:List[Int],c:List[Int]):List[Int] = (a,b) match{
  case (Nil, Nil) => c
  case (Nil, _) => sumtl(Nil,b.tail, c :+ b.head )
  case (_, Nil) => sumtl(a.tail,Nil, c :+ a.head )
  case (_,_) => sumtl(a.tail,b.tail, c :+ (a.head + b.head) )
}

sumtl(List(-1,-2,-3),List(1,2,3),List())

/*

def decode[A](a:List[(Int,A)]):List[A] = {
  def repeat[A](l:Int, b:A ):List[A] = {
    if(l == 0) List()
    else b :: repeat(l-1,b)
  }

  if (a == Nil) List()
  else {
    val (l,b) = a.head
    repeat(l,b) ::: decode(a.tail)
  }

}  */

@tailrec
def fdecode[A]( a:List[(Int,A)], result:List[A] ):List[A] = {
  @tailrec
  def repeat[A](l:Int, b:A, c:List[A] ):List[A] = {
    if(l == 0) c
    else repeat(l-1,b, c :+ b)
  }

  if(a == Nil) result

  else{
    val (l,b) = a.head
    fdecode(a.tail, result ::: repeat(l,b,List()))
  }
}

def decode[A](a:List[(Int,A)]):List[A] = {

  @tailrec
  def fdecode[A]( a:List[(Int,A)], result:List[A] ):List[A] = {
    @tailrec
    def repeat[A](l:Int, b:A, c:List[A] ):List[A] = {
      if(l == 0) c
      else repeat(l-1,b, c :+ b)
    }

    if(a == Nil) result

    else{
      val (l,b) = a.head
      fdecode(a.tail, result ::: repeat(l,b,List()))
    }
  }

  fdecode(a, List())

}

decode(List((3,'a'),(2,'b'),(1,8)))
decode(List())
decode(List((0,'a'),(1,'b'),(0,8)))
decode(List((1,"Ala"),(1,"ma"),(3,"kota")))
decode(List((1,'1'),(2,'2'),(3,"/")))





//val xm = List((2,'a'),(3,'b'))

//val (u,v) = xm.head

/*def dek(arr:List[(Int,Char)]):List[Char] =
  if(arr == Nil) Nil
  else {
    arr.head match{
      case
    }

  }