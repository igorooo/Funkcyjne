

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
  def moveIter(iter:Int,xs:List[A]):List[A] = {
    if(iter < begin) moveIter(iter+1,xs.tail)
    else xs
  }

  def moveRound(iter:Int,end:Int,xs:List[A],res:List[A]):List[A] = {
    if(iter == end) res.reverse
    else{
      xs.tail match {
        case Nil => moveRound(iter+1,end,n,xs.head::res)
        case _ => moveRound(iter+1,end,xs.tail,xs.head::res)
      }
    }
  }
  //moveRound(begin, begin, moveIter(0, n),List())
  moveRound(2, 2, List(3,4,5),List())

}

moveRight(xx,2);







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


