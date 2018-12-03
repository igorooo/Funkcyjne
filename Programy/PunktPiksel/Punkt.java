public class Punkt
{ protected double x, y;

  public Punkt()
  { this(0.0, 0.0);
    System.out.println( "1. konstruktor punktu: " + this ); 
  }
  
  public Punkt(double x, double y)
  { this.x=x; this.y=y; 
    System.out.println( "2. konstruktor punktu: " + this ); 
  }
  @Override
  protected void finalize()
  { System.out.println( "Finalizator punktu: " + this ); }
  @Override
  public String toString()
  { return "[" + x + ", " + y + "]"; }
}