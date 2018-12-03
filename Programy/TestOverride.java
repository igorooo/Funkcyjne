class A {
       @Override public String toString(){return "z klasy A;  ";}
}

class B extends A {
       @Override public String toString(){return "z klasy B;  ";}
}

class C extends B {
       @Override public String toString(){return "z klasy C;  ";}
}

public class TestOverride {
        public static void main(String[] args) {
              A[]  arrA = {new C(), new B(), new A()};	  
              for (A e: arrA) System.out.print(e);                
         }		
}