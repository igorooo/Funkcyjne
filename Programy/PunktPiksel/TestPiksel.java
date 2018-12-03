import java.awt.Color;

public class TestPiksel
{ public static void main( String args[] )
  { Piksel piksel1, piksel2, piksel3;

    piksel1 = new Piksel();
    System.out.println("");
    piksel2 = new Piksel(1, 2.5);
    System.out.println("");
    piksel3 = new Piksel(5, 5, Color.BLUE);
    System.out.println("");
	
    piksel1 = piksel2 = piksel3 = null;

    System.gc();
    System.runFinalization();
  }
}  	