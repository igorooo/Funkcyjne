

val plus = (x:Int,y:Int) => x+y

(plus curried 4)(5)

plus(4,5)



List(1,2,3,4) map (x => x*x)

List(1,2,3,4) filter(x => x%2 == 0)


(List(1,2,3,4) foldLeft 0) ((x,y) => x+y)

(0/: List(1,2,3,4)) ((x,y) => x+y)

def sumProd(xs:List[Int]):(Int,Int) =
  xs match {
    case h::t => {val (s,p) = sumProd(t)
                  (h+s, h*p)
                }
    case Nil => (0,1)
  }

sumProd(List(1,2,3,4))

val kr = (1,2)

kr._2


//zad 3

def sumprod(xs:List[Int]):(Int,Int) = ((0,1) /: xs)( (sum,x) => (sum._1+x,sum._2 * x) )

sumprod(List(1,2,3,4))

// ZAD 5


def insertSort[A](compare: (A,A) => Boolean,list: List[A]):List[A] = {
  def insert(elem:A, list: List[A]):List[A] = {
    list match {
      case Nil => List(elem)
      case h::t =>
        if (compare(elem,h)) h :: insert(elem,t)
        else elem :: h :: t
    }
  }
  list match {
    case Nil => Nil
    case h::t => insert(h, insertSort(compare, t))
  }
}

insertSort( ((x:Int,y:Int) => x > y), List(7,8,5,2,2,4,6,3))


