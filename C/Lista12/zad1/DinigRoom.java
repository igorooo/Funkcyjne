import java.util.concurrent.Semaphore;

public class DinigRoom {
	private Semaphore doorman;
	private Semaphore[] chopstick;
	private Philosopher[] philosopher;
	private final int N;
	
	public DinigRoom(int N) {
		this.N = N;
		doorman = new Semaphore(N - 1);
	}
	
	private void createForks() {
		// Create the chopsticks, 1 per philosopher
		chopstick = new Semaphore[N];
		for (int f = 0; f < N; f++) {
			// each chopstick is a single resource
			chopstick[f] = new Semaphore(1, true);
		}
	}
	
	private void invitePhilosophers() {
		// Create the philosophers, pass in their chopsticks
		philosopher = new Philosopher[N];
		for (int ID = N - 1; ID >= 0; ID--) {
			// determine my left neighbor's ID
			int myneighbor = ID - 1;
			if (myneighbor == -1) myneighbor = N - 1;
			
			// Initialize each philosopher (no pun intended)
			philosopher[ID] = new Philosopher(ID, chopstick[ID], chopstick[myneighbor]);
		}
		Philosopher.doorman = doorman;
	}
	
	private void startFeast() {
		createForks();
		invitePhilosophers();
		
		System.out.println("Start dining!");
		
		// Start the philosophers
		for (int i = 0; i < N; i++) {
			philosopher[i].start();
		}
		
		// Wait for them to finish
		for (int i = 0; i < N; i++) {
			try {
				philosopher[i].join();
			}
			catch (InterruptedException ex) {}
		}
		System.out.println("Done eating.");
	}
	
	/**
	 * Dining simulations - puts philosophers by the table with their chopsticks
	 */
	public static void main(String[] args) {
		new DinigRoom(5).startFeast(); 			// five philosophers, five chopsticks
	}
}