import scala.annotation.tailrec


def power(n:Int):Int = if(n == 0) 1 else n*power(n-1)

power(6)

val value1 = ((x:Int) => x+x) (6)


def funct_val_1(x:Int) = x+x
//funct_val_1: ( x: Int)Int

funct_val_1(5)

val f = (y:Int) => (x:Int) => x*x +y

f(2)(5)

val f2 = f(2)

f2(5)

val f3 = (z: Int) => f(z)(5)

f3(2)

def id[A](x:A) = x

id( id("OK"))

def evenR(n:Int):Boolean = if( n == 0) true else oddR(n-1)

def oddR(n:Int):Boolean = if (n == 0) false else evenR(n-1)

evenR(128)

oddR(128)

def suc (n:Int):Int = if(n == 0) 0 else 1 + suc(n-1)

suc(10)

def sac (n: Int, t:Int):Int = if(n == 0) t else sac(n-1, t + 1)

sac(20,0)

def fib (n: Long):Long =  if(n < 2 ) { if( n == 1 ) 1 else 0 } else fib(n-1) + fib(n-2)

def fib_tail (n: Long): Long = {
  @tailrec
  def fibo_tail(n: Long, a: Long, b: Long):Long = if( n == 0) b else fibo_tail(n-1, a + b, a )
  fibo_tail(n,1,0)
}





//fib_tail(37,1,0)

def time(function: Long => Long, n: Int) = {
  val start = System.nanoTime()
  function(n)
  (System.nanoTime() - start) / 1000000  //nano seconds
}

fib(10)
fib_tail(10)


time(fib,37)
time(fib_tail,37)








