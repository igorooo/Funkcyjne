


val primes = {
  def sieve(s:Stream[Int]):Stream[Int] = {
    s match {
      case p #:: xs => p#::sieve(xs filter( n => n % p != 0 ))
      case _ => Stream.Empty
    }
  }
  sieve(Stream.from(2))
}


primes.take(6).toList

// ZAD 1

def lrepeat[A] (n:Int)(xs:Stream[A]):Stream[A] = {
  def repeat (am:Int, wd:A):Stream[A] = {
    if(am == 0) Stream.Empty
    else wd #:: repeat(am-1,wd)
  }
  xs match {
    case Stream.Empty => Stream.Empty
    case Stream.cons(x,xf) => repeat(n, x) #::: lrepeat(n)(xf)
  }
}

(lrepeat(3)(primes.take(6))).toList

// ZAD 2

val lfib = {
  def fib(a:Int, acc:Int):Stream[Int] = a #:: fib(acc,a + acc)
  fib(0,1)
}

lfib.take(10).toList

// ZAD 3

sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A] (elem:A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

// b)

def lTree (n:Int):lBT[Int] = LNode(n,() => lTree(2*n),() => lTree(2*n +1))

val tre = lTree(5)

def show(n:Int,bt:lBT[Int]):List[Int] = {
  bt match {
    case LEmpty => Nil
    case LNode(elem, l, r) => if(elem < n) List(elem):::show(n,l()):::show(n,r()) else Nil
  }
}

show(100,tre)

def strim (n:Int):Stream[Double] = (Stream.from(0)).map((x:Int) => math.pow(n,x) )

def stream (n:Int):Stream[Int] = {
  def pow(a:Int,b:Int):Int = {
    def poww(i:Int):Int = if(i < b) a*poww(i+1) else 1
    poww(0)
  }
  Stream.from(0).map((x:Int) => pow(n,x))
}

stream(5).take(10).toList
stream(4).take(10).toList
stream(3).take(10).toList

strim(5).take(10).toList



// a) 
/*

def allVal[A](bt:lBT[A]):Stream[A] = {

  def bfs(lbt: lBT[A], queue: List[lBT[A]], acc:Stream[A]):Stream[A] = {

  }
}


