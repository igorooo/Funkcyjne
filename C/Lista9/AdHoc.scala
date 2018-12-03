class A { def m(other: A) { System.out.print("A.m(A) "); } }
class B extends A { def m(other: B) { System.out.print("B.m(B) "); } }

object Main extends App {
  val a: A = new B(); val b: B = new B();
  a.m(a); /* wypisuje A.m(A) */ a.m(b); /* wypisuje A.m(A) */
  b.m(a); /* wypisuje A.m(A) */ b.m(b); /* wypisuje B.m(B) */
}