import java.awt.Color;

public class Piksel extends Punkt
{ protected Color kolor;

  public Piksel()
  { kolor = Color.BLACK; 
    System.out.println( "1. konstruktor piksela: " + this );  
  }

  public Piksel(final double x, final double y)
  { this(x, y, Color.BLACK); 
    System.out.println( "2. konstruktor piksela: " + this ); 
  }
  
  public Piksel(final double x, final double y, final Color kolor)
  { super(x, y); this.kolor = kolor; 
    System.out.println( "3. konstruktor piksela: " + this );  
  }
  @Override  
  protected void finalize()
  { try {System.out.println( "Finalizator piksela: " + this );
    } finally {super.finalize();}
  }
  @Override 
  public String toString()
  { return super.toString() + " " + kolor; }
}  
  