class IntCell {
	private int n = 0;
	public int getN() { return n; }
	public void setN(int n) { this.n = n; 
	public synchronized void increment() { etN(getN() + 1); }
}

public class Count extends Thread {
	static IntCell n = new IntCell();
	
	@Override public void run() {
		for (int i = 0; i < 200000; i++) n.increment();
	}
	
	public static void main(String[] args) {
		Count p = new Count();
		Count q = new Count();
		p.start();
		q.start();
		try {
			p.join();
			q.join();
		}
		catch (InterruptedException e) {}
		System.out.println("The value of n is " + n.getN());
	}
}