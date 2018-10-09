package lab5;

public interface QueueInterface<T> {
  
	// Throws QueueOverflowException if this queue is full;
	// otherwise, adds element to the rear of this queue.
	void enqueue(T element) throws QueueOverflowException;
	
	// Throws QueueUnderflowException if this queue is empty;
	// otherwise, removes front element from this queue and returns it.
	T dequeue() throws QueueUnderflowException;

	// Returns true if this queue is full; otherwise, returns false.
	boolean isFull();

	// Returns true if this queue is empty; otherwise, returns false.
	boolean isEmpty();
	
	// Returns the number of elements in this queue.
	int size();

}


