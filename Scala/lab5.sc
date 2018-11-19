

def code[A](n: List[A],nRes: List[(Int,A)], cur:A, aCur:Int):List[(Int,A)] ={
  if( n == Nil) nRes :+ (aCur,cur)
  else {
    if( n.head == cur ) code( n.tail, nRes, cur, aCur + 1)
    else code ( n.tail, nRes :+ (aCur,cur), n.head, 1)
  }
}

code( List('a','a','a','a','b','b','b','c','c','c','b','b','c'), List(), 'a', 0)

val xx = List(1,2,3,4,5)

def moveRight[A](n:List[A], offset:Int):List[A] = {

  val begin = offset % n.length

  def moveR(iter:Int,xs:List[A],res:List[A]):List[A] = {
    if( iter < begin ) moveR(iter+1, xs.tail, res :+ xs.head) else xs:::res
  }

  moveR(0,n,List())
}

moveRight(xx,1)









val primes = (toN: Int) => {
  def find_primes(sieve: List[Int]):List[Int] = {

    sieve match{
      case h::t => h::find_primes(t.filter((p:Int) => p % h != 0))
      case Nil => Nil
    }
  }

  find_primes(List.range(2, toN + 1));
}

( 0 /: primes (30)) ((x,y)=> x + y)


