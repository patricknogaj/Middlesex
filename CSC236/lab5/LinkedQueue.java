package lab5;

public class LinkedQueue<T> implements QueueInterface<T> {
	
	protected LLNode<T> front;     // reference to the front of this queue
	protected LLNode<T> rear;      // reference to the rear of this queue
	protected int numElements = 0; // number of elements in this queue

	public LinkedQueue() {
		front = null;
		rear = null;
	}

	// Adds element to the rear of this queue.
	public void enqueue(T node) { 
		LLNode<T> newNode = new LLNode<T>(node);
		if (rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
		numElements++;
	}     

	// Throws QueueUnderflowException if this queue is empty;
	// otherwise, removes front element from this queue and returns it.
	public T dequeue() {
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else {
			T element;
			element = front.getInfo();
			front = front.getLink();
			if (front == null)
				rear = null;
			numElements--;
			return element;
		}
	}

	// Returns true if this queue is empty; otherwise, returns false.
	public boolean isEmpty() {              
		return (front == null);
	}
  
	// Returns false - a linked queue is never full.
	public boolean isFull() {              
		return false;
	}

	// Returns the number of elements in this queue.
	public int size() {
		return numElements;
	}

}
