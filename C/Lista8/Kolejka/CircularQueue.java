public class CircularQueue<E> implements MyQueue<E> {
	private final int size;
	private int firstTakenIndex;	// f
	private int firstFreeIndex;		// r
	private E[] array;
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		this.size = size + 1;
		array = (E[]) new Object[size + 1];
	}
	
	@Override
	public void enqueue(E x) throws FullException {
		if (isFull()) throw new FullException("Kolejka pe³na!");
		array[firstFreeIndex] = x;
		firstFreeIndex = (firstFreeIndex + 1) % size;
	}
	
	@Override
	public void dequeue() {
		if (!isEmpty()) {
			array[firstTakenIndex] = null;
			firstTakenIndex = (firstTakenIndex + 1) % size;
		}
	}
	
	@Override
	public E first() throws EmptyException {
		if (isEmpty()) throw new EmptyException("Kolejka pusta!");
		return array[firstTakenIndex];
	}
	
	@Override
	public boolean isEmpty() {
		return firstFreeIndex == firstTakenIndex;
	}
	
	@Override
	public boolean isFull() {
		return (firstFreeIndex + 1) % size == firstTakenIndex;
	}
}