package lista11.zad4;

import java.util.Random;
import java.util.concurrent.Semaphore;


public class Philosopher extends Thread {

    private Semaphore LEFT_STICK,RIGHT_STICK, DOORMAN;
    private int ID,PORTIONS_OF_RICE;
    private Random RAND = new Random();



    Philosopher(int ID, Semaphore LEFT_STICK, Semaphore RIGHT_STICK, Semaphore DOORMAN, int PORTIONS_OF_RICE){
        this.ID = ID;
        this.LEFT_STICK = LEFT_STICK;
        this.RIGHT_STICK = RIGHT_STICK;
        this.DOORMAN = DOORMAN;
        this.PORTIONS_OF_RICE = PORTIONS_OF_RICE;
    }


    private void think(){

        show_event("thinking");

        try{
            sleep(RAND.nextInt(500));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void eat(){

        show_event("getting hungry");

        try {
            this.DOORMAN.acquire();
            show_event("entered dining room");

            this.LEFT_STICK.acquire();
            show_event("took left chopstick");

            this.RIGHT_STICK.acquire();
            show_event("took right chopstick, gonna eat now");

            sleep(RAND.nextInt(10)); //eating
            this.PORTIONS_OF_RICE --;
            show_event("feels full");

            this.RIGHT_STICK.release();
            this.LEFT_STICK.release();
            this.DOORMAN.release();
            show_event("left dining room");
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }


    @Override
    public void run() {

        while(this.PORTIONS_OF_RICE > 0){
            this.eat();
            this.think();
        }

        show_event("ate his portions, gonna die now");

    }


    private void show_event(String EVENT) {
        System.out.println(this + " : " + EVENT);
    }
    @Override
    public String toString() {
        return Integer.toString(this.ID) +".Philosopher";
    }
}
