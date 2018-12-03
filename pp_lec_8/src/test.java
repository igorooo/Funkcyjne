import java.util.ArrayList;

public class test {

    public static void main(String args[]) throws FullException,EmptyException{

        CAQueue<Integer> caq= new CAQueue<>(4);

        System.out.println(caq.isEmpty());
        System.out.println(caq.isFull());

        caq.enqueue(new Integer(1));
        caq.enqueue(new Integer(2));
        caq.enqueue(new Integer(3));
        caq.enqueue(new Integer(4));

        System.out.println(caq.isEmpty());
        System.out.println(caq.isFull());

        System.out.println(caq.first());
        caq.dequeue();

        System.out.println(caq.first());
        caq.dequeue();

        System.out.println(caq.first());
        caq.dequeue();

        System.out.println(caq.first());
        caq.dequeue();

        try {
            System.out.println(caq.first());
        }
        catch (Exception e){
            System.err.println( e.getMessage() + '\n');
            e.printStackTrace();
        }


    }
}
