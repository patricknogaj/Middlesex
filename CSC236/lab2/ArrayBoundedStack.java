package lab2;

import java.util.Arrays;

public class ArrayBoundedStack<T> implements StackInterface<T> {
	
	protected final int DEFCAP = 100; 
	protected T[] elements;           
	protected int topIndex = -1; 
	
	public ArrayBoundedStack() {
		elements = (T[]) new Object[DEFCAP];
	}
	
	public ArrayBoundedStack(int maxSize) {
		elements = (T[]) new Object[maxSize];
	}

	public void push(T element) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException("Push attempted on a full stack.");
		else {
			topIndex++;
			elements[topIndex] = element;
		}
	}
	
	public void pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Pop attempted on an empty stack.");
		} else  {
			elements[topIndex] = null;
			topIndex--;
		}
	}
	
	public T top() throws StackUnderflowException {
		T topOfStack = null;
		if(isEmpty()) {
			throw new StackUnderflowException("Top attempted on an empty stack");
		} else {
			topOfStack = elements[topIndex];
			return topOfStack;
		}
	}
	
	public boolean isEmpty() {
		return (topIndex == -1);
	}
	
	public boolean isFull() {
		return (topIndex == (elements.length - 1));
	}
	
	public String toString() {
		return Arrays.toString(elements);
	}
	
}