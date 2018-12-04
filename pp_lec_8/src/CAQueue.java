import java.lang.reflect.Array;
import java.util.ArrayList;

public class CAQueue<E> implements MyQueue<E> {

    ArrayList<E> ARR;
    int SIZE,f,r;

    public CAQueue(int SIZE){
        this.SIZE = SIZE+1;
        this.f = 0;
        this. r = 0;
        this.ARR = new ArrayList<>(this.SIZE);
    }

    public CAQueue(){
        this.SIZE = 10; //default size
        this.f = 0;
        this. r = 0;
        this.ARR = new ArrayList<>(this.SIZE);
    }

    private int mod(int VAL){
        return VAL % this.SIZE;
    }

    @Override
    public void enqueue(E x) throws FullException {

        if(this.isFull()) throw (new FullException("full queue"));

        else{
            this.ARR.add(this.r,x);
            this.r = this.mod(this.r +1);
        }

    }

    @Override
    public void dequeue() {

        if (this.isEmpty() ) return;

        else {
            this.f = this.mod(this.f +1);
        }
    }

    @Override
    public E first() throws EmptyException {
        if(this.isEmpty()) throw (new EmptyException("empty queue"));

        else{
            return this.ARR.get(this.f);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.r == this.f;
    }

    @Override
    public boolean isFull() {
        return mod(this.r +1) == this.f;
    }
}
