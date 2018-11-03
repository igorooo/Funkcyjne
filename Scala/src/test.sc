val x1 = 7.5

{val x = x1 + x1
  val y = 2
  x + x +
    {val x = 10.0
      x + y
    }
  } + 1.0


val xs =1.0:: x1 :: 2.5 :: Nil

xs == List(1.0,7.5,2.5)

xs.length

val xss = 2.0 :: x1 + x1 :: 5.0 :: Nil

xs ::: xss

val xsss = xs ::: xss
xsss.reverse

val xssss = List(List(4.0,5.0),xs,1.0::2.0::3.0::Nil)
xssss.length

xssss.tail

val double = (x:Int) => x*2

def triple (x:Int) = 3*x

double(2)
triple(2)

def silnia(n:Int):Int = if(n==0) 1 else n*silnia(n-1)

silnia(3)

val t = 1

val ll = List(List(1,2,3),List(4,5,6),List(7,8,9))

ll.tail

//  zad 1

def flatten[A](x: List[List[A]]):List[A] = if(x == Nil) Nil else x.head ::: flatten(x.tail)


flatten(List(List(5,6), List(7,8), List(9,10)))

//  zad2

def count[A](x:A, n:List[A]):Int = if( n == Nil) 0 else { if(n.head == x) 1 + count(x,n.tail) else count(x,n.tail)}

count('a',List('a','l','a','o','a','a'))

// zad3

def replicate[A](x:A, n:Int):List[A] = if( n == 0) Nil else replicate(x,n-1):::List(x)


replicate("Lay",3)

// zad4

def sqrList(x:List[Int]):List[Int] = if(x == Nil) List() else { x.head*x.head :: sqrList(x.tail)}

sqrList(List(1,2,3,4))

// zad5

def palindrome[A](x:List[A]):Boolean = if( x == x.reverse) true else false

palindrome(List(1,2,3,2,1,0))

// zad6

def ListLength[A](x:List[A]):Int = if(x == Nil) 0 else ListLength(x.tail)+1

ListLength(List(1,2,3,4,5,6))

// zad7

def power(n:Int):Int = if(n == 0) 1 else n*power(n-1)

power(6)

def count2[A](a:A, n:List[A]):Int = if(n == Nil) 0 else { if(n.head == a) 1 + count2(a,n.tail) else count2(a,n.tail)}

count2('t',List('a','t','t','m','o','t','r','t'))




