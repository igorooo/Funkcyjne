

public class test {

    public static int fibonacci_iter(int n){

        int a = 0,b,sum = 0;

        for(int i = 0; i <= n ; i++ ){

            if( i == 0){
                sum = 0;
                a = 0;
                b = 0;
            }

            else if( i == 1){
                sum = 1;
                a = 0;
                b = 0;
            }

            else{
                b = sum;
                sum = sum + a;
                a = b;
            }

        }

        return sum;
    }

    public static int fibo(int n, int a, int b){

        if(n == 0) return b;

        return fibo(n-1, a+b, a);


    }

    public static long fib(int n, long a, long b)
    {

        if (n == 0)
        {
            return b;
        }

        return fib(n - 1, a + b, a);
    }



    public static void main(String args[]){

       // Fib fib = new Fib();

        System.out.println(fibonacci_iter(10));
        System.out.println(fibo(10,1, 0));
        System.out.println(fib(5,1,0));

    }
}
