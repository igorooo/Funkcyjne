import java.util.concurrent.Semaphore;

class IntCell {
	private int n = 0;
	public int getN() { return n; }
	public void setN(int n) { this.n = n; }
}

public class Count extends Thread {
	static IntCell n = new IntCell();
	private final Semaphore semaphore = new Semaphore(1);
	
	@Override public void run() {
		int temp;
		for (int i = 0; i < 200000; i++) {
			try {
				semaphore.acquire();
				temp = n.getN();
				n.setN(temp + 1);
				semaphore.release();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Count p = new Count();
		Count q = new Count();
		long start = System.currentTimeMillis();
		p.start();
		q.start();
		try {
			p.join();
			q.join();
		}
		catch (InterruptedException e) {}
		System.out.println("The value of n is " + n.getN());
		System.out.println(System.currentTimeMillis() - start);
	}
}