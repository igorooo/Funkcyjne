class A {
	public void m(A other) {System.out.print("A.m(A) "); }
}

class B extends A {
	public void m(B other) {System.out.print("B.m(B) "); }
}

public class TestOverload {
	public static void main(String[] args) {
	  A a = new B(); 
	  B b = new B();
	  			
	                     System.out.print("a: ");
	  a.m(a); a.m(b);    System.out.print("\nb: ");
	  b.m(a); b.m(b);    System.out.println();
	  System.out.println("five=5" == ("five="+5));
    }
}		
	