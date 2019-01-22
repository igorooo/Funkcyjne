package lista11.zad4;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Tower {

    Semaphore DOORMAN;
    private Integer AMOUNT_OF_RICE;
    ArrayList<Thread> PHILOSOPHERS;
    ArrayList<Semaphore> STICKS;

    Tower(int AMOUNT_OF_RICE){
        DOORMAN = new Semaphore(4);
        this.AMOUNT_OF_RICE = AMOUNT_OF_RICE;

        PHILOSOPHERS = new ArrayList<>(5);
        STICKS = new ArrayList<>(5);

        for(int i = 0; i < 5; i++) STICKS.add(new Semaphore(1));

        for(int i = 0; i < 5; i++){
            int TEMP_L = i ;
            int TEMP_R = i == 0 ? 4 : i - 1;

            PHILOSOPHERS.add(new Philosopher(i, STICKS.get(TEMP_L), STICKS.get(TEMP_R), DOORMAN, AMOUNT_OF_RICE/4));
        }
    }

    public void start(){

        for(Thread thr : PHILOSOPHERS){
            thr.start();
        }
    }
}
