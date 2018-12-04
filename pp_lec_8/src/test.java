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

        System.out.println(caq.isEmpty());

        caq.enqueue(new Integer(1));
        caq.enqueue(new Integer(2));
        caq.enqueue(new Integer(3));
        caq.enqueue(new Integer(4));

        System.out.println(caq.isFull());

        try {
            caq.enqueue(new Integer(5));
        }
        catch (Exception e){
            System.err.println( e.getMessage() + '\n');
            e.printStackTrace();
        }

        /*

        true
false
false
true
1
2
3
4
true
empty queue

EmptyException: empty queue
	at CAQueue.first(CAQueue.java:51)
	at test.main(test.java:33)
true
full queue

FullException: full queue
	at CAQueue.enqueue(CAQueue.java:30)
	at test.main(test.java:50)

Process finished with exit code 0



         */


    }
}
