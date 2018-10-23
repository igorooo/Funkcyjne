



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

root3(9)

val a  = List(1,2,3)
val b = List(4,5,6)

val c = a.head + b.head



def sum(a:List[Int],b:List[Int]):List[Int] =
  if (a == Nil && b == Nil ) List()
  else if ( a == Nil && b != Nil){ b.head :: sum(Nil,b.tail) }
  else if( a != Nil && b == Nil) a.head :: sum(a.tail, Nil)
  else ( a.head + b.head ) :: sum(a.tail,b.tail)



sum(List(1,2,3),List(4,5,6,7))


val xm = List((2,'a'),(3,'b'))

val (u,v) = xm.head

def dek(arr:List[(Int,Char)]):List[Char] =
  if(arr == Nil) Nil
  else {
    arr.head match{
      case
    }

  }