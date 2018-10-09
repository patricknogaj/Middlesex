package lab4;

//----------------------------------------------------------------------------
//SortedABList.java          by Dale/Joyce/Weems                    Chapter 6
//Sorted Array Based List
//
//Null elements are not permitted on a list. The list is unbounded.
//
//Index-based add and set operations are not supported. Invoking them will
//result in the unchecked UnsupportedOperationException being thrown.
//
//Two constructors are provided: one that use the natural order of the
//elements as defined by their compareTo method and one that uses an
//ordering based on a comparator argument. In both cases clients should be
//aware that equality of elements is determined by the comparison operation
//and not by the equals method defined on the element class.
//----------------------------------------------------------------------------

import java.util.*;   // Iterator, Comparator

public class SortedABList<T> implements ListInterface<T> {
	
	protected final int DEFCAP = 100; // default capacity
	protected T[] list;               // array to hold list�s elements
	protected int numElements = 0;    // number of elements in this list

	protected Comparator<T> comp;

	// set by find method
	protected boolean found;  // true if element found, otherwise false
	protected int location;   // indicates location of element if found,
                         	// indicates add index if not found

	// Precondition: T implements Comparable
	public SortedABList() {
		list = (T[]) new Object[DEFCAP];
		comp = new Comparator<T>() {
		public int compare(T element1, T element2) {
			return ((Comparable)element1).compareTo(element2);
			}
		};
	}

	public SortedABList(Comparator<T> comp) {
		list = (T[]) new Object[DEFCAP];
		this.comp = comp;
	}

	// Increments the capacity of the list by an amount
	// equal to the original capacity.
	protected void enlarge() {
		// Create the larger array.
		T[] larger = (T[]) new Object[list.length + DEFCAP];

		// Copy the contents from the smaller array into the larger array.
		for (int i = 0; i < numElements; i++) {
			larger[i] = list[i];
		}
		// Reassign list reference.
		list = larger;
	}
	
	// Searches list for an occurrence of an element e such that
	// compare(e, target) == 0. If successful, sets instance variables
	// found to true and location to the array index of e. If
	// not successful, sets found to false and location to the
	// array index where target should be inserted.
	protected void find(T target) {
		location = 0;
		found = false;
		if (!isEmpty())
			recFind(target, 0, numElements - 1);
	}

	// Used by find.
	protected void recFind(T target, int first, int last) {
		int result;
		if (first > last) {
			found = false;
			result = comp.compare(target, list[location]);
			if (result > 0)
				location++;    // adjust location to indicate insert index
			} else {
				location = (first + last) / 2;
				result = comp.compare(target, list[location]);
				if (result == 0)  // found target
					found = true;
				else if (result > 0)   // target too high
					recFind(target, location + 1, last);
				else // target too low
					recFind(target, first, location - 1);
			}
	}
	
	// Adds element to this list.
	public boolean add(T element) {
		if (numElements == list.length)
			enlarge();

		find(element); // sets location to index where element belongs

		for (int index = numElements; index > location; index--)
			list[index] = list[index - 1];
		list[location] = element;
		numElements++;
		return true;
	}

	// Removes an element e from this list such that compare(e, target) == 0
	// and returns true; if no such element exists, returns false.
	public boolean remove(T target) {
		find(target);
		if (found) {
			for (int i = location; i <= numElements - 2; i++)
				list[i] = list[i+1];
			list[numElements - 1] = null;
			numElements--;
		} return found;
	}
	
	// Returns the number of elements on this list.
	public int size() {
		return numElements;
	}

	// Returns true if this list contains an element e such that
	// compare(e, target) == 0; otherwise, returns false.
	public boolean contains (T target) {
		find(target);
		return found;
	}

	// Returns an element e from this list such that compare(e, target) == 0;
	// if no such element exists, returns null.
	public T get(T target) {
		find(target);
		if (found)
			return list[location];
		else
			return null;
	}
	
	// Returns true if this list is empty; otherwise, returns false.
	public boolean isEmpty() {
		return (numElements == 0);
	}

	// This list is unbounded so always returns false.
	public boolean isFull() {
		return false;
	}

	// Throws UnsupportedOperationException.
	public void add(int index, T element) {
		throw new UnsupportedOperationException("Unsupported index-based add attempted on sorted list.");
	}

	// Throws UnsupportedOperationException.
	public T set(int index, T newElement) {
		throw new UnsupportedOperationException("Unsupported index-based set attempted on sorted list.");
	}

	// Throws IndexOutOfBoundsException if passed an index argument
	// such that index < 0 or index >= size().
	// Otherwise, returns the element on this list at position index.
	public T get(int index) {
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("illegal index of " + index +
                          " passed to ABList get method.\n");
		return list[index];
	}

	// If this list contains an element e such that compare(e, target) == 0,
	// then returns the index of the first such element.
	// Otherwise, returns -1.
	public int indexOf(T target) {
		find(target);
		if (found) {
			// must adjust in case there are duplicate values
			while ((location != 0) && (comp.compare(list[location - 1], target) == 0))
				location--;
			return location;
		} else
			return -1;
	}

	//Throws IndexOutOfBoundsException if passed an index argument
	//such that index < 0 or index >= size().
	//Otherwise, removes element on this list at position index and
	//returns the removed element; all current elements at positions
	//higher than that index have 1 subtracted from their position.
	public T remove(int index) {
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("illegal index of " + index +
                          " passed to ABList remove method.\n");
		T hold = list[index];
		for (int i = index; i < numElements-1; i++)
			list[i] = list[i + 1];
		list[numElements-1] = null;
		numElements--;
		return hold;
	}

	//Returns an Iterator over this list.
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int previousPos = -1;

			// Returns true if the iteration has more elements; otherwise returns false.
			public boolean hasNext() {
				return (previousPos < (size() - 1)) ;
			}

			// Returns the next element in the iteration.
			// Throws NoSuchElementException - if the iteration has no more elements
			public T next() {
				if (!hasNext())
					throw new IndexOutOfBoundsException("illegal invocation of next " +
                          " in LBList iterator.\n");
				previousPos++;
				return list[previousPos];
			}

			// Removes from the underlying representation the last element returned
			// by this iterator. This method should be called only once per call to
			// next(). The behavior of an iterator is unspecified if the underlying
			// representation is modified while the iteration is in progress in any
			// way other than by calling this method.
			public void remove() {
				for (int i = previousPos; i <= numElements - 2; i++)
					list[i] = list[i+1];
				list[numElements - 1] = null;
				numElements--;
				previousPos--;
			}
		};
	}
}