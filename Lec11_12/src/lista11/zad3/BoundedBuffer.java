package lista11.zad3;

public class BoundedBuffer implements Produce, Consume {
    final private int N;
    private int in = 0, out = 0, n = 0;
    private int[] elems;

    public BoundedBuffer(int N) {
        this.N = N; elems = new int[N]; 
    }

    public synchronized void showBuf(){
        for(int e: elems) System.out.print(e+" ");
        System.out.println();
    }

    public synchronized void put(int x) {
        while (n >= N) // n : <0 ; N>    while(Buffer pełny)
          try {
        	  System.out.println(Thread.currentThread().getName()+" waiting with " + x); 
        	  wait(); 
          } catch (InterruptedException e) {System.out.println(e);}

        elems[in] = x; in = (in + 1) % N ; n += 1; // dodaj do bufera x, zwieksz indeks dla kolejnego elementu, zwieksz licznik

        System.out.println(Thread.currentThread().getName()+" produced: " + x);
        showBuf();
        if (n == 1){
            notify();
            System.out.println("Put notify");//jesli jest jeden element to wywolaj notify,, jesli zlikwidujemy ifa i damy notify bezwarunkowo to rozwiazemy problem
        }
    }

    public synchronized int take() {
        while (n == 0)
          try {
        	  System.out.println(Thread.currentThread().getName()+" waiting"); 
        	  wait(); 
          } catch (InterruptedException e) {System.out.println(e);}
        int x = elems[out];elems[out] = -1; out = (out + 1) % N ; n -= 1;
        System.out.println(Thread.currentThread().getName()+" consuming: " + x);
        showBuf();
        if (n == N-1){
            notify();
            System.out.println("Take notify");
        }
        return x;
    }
}

