package lab5;

//---------------------------------------------------------------------------
//BinarySearchTree.java          by Dale/Joyce/Weems               Chapter 7
//
//Defines all constructs for a reference-based BST.
//Supports three traversal orders Preorder, Postorder & Inorder ("natural")
//---------------------------------------------------------------------------

import java.util.*;   // Iterator, Comparator


public class BinarySearchTree<T> implements BSTInterface<T> {
	
	protected BSTNode<T> root;      // reference to the root of this BST
	protected Comparator<T> comp;   // used for all comparisons
	protected boolean found;   // used by remove
	protected T[] elements = (T[]) new Object[100];

	// Precondition: T implements Comparable
	// Creates an empty BST object - uses the natural order of elements.
	public BinarySearchTree() {
		root = null;
		comp = new Comparator<T>() {
			public int compare(T element1, T element2) {
				return ((Comparable)element1).compareTo(element2);
			}
		};
	}

	// Creates an empty BST object - uses Comparator comp for order
	// of elements.
	public BinarySearchTree(Comparator<T> comp) {
		root = null;
		this.comp = comp;
	}

	// Returns false; this link-based BST is never full.
	public boolean isFull() {
		return false;
	}

	// Returns true if this BST is empty; otherwise, returns false.
	public boolean isEmpty() {
		return (root == null);
	}

	// If this BST is empty, returns null;
	// otherwise returns the smallest element of the tree.
	public T min() {
		if (isEmpty())
			return null;
		else {
			BSTNode<T> node = root;
			while (node.getLeft() != null)
				node = node.getLeft();
			return node.getInfo();
		}
	}

	// If this BST is empty, returns null;
	// otherwise returns the largest element of the tree.
	public T max() {
		if (isEmpty())
			return null;
		else {
			BSTNode<T> node = root;
			while (node.getRight() != null)
				node = node.getRight();
			return node.getInfo();
		}
	}

	// Returns the number of elements in subtree rooted at node.
	private int recSize(BSTNode<T> node) {
		if (node == null)
			return 0;
		else
			return 1 + recSize(node.getLeft()) + recSize(node.getRight());
	}

	// Returns the number of elements in this BST.
	public int size() {
		return recSize(root);
	}

	// Returns the number of elements in this BST.
	public int size2() {
		int count = 0;
		if (root != null) {
			LinkedStack<BSTNode<T>> nodeStack = new LinkedStack<BSTNode<T>>();
			BSTNode<T> currNode;
			nodeStack.push(root);
			while (!nodeStack.isEmpty()) {
				currNode = nodeStack.top();
				nodeStack.pop();
				count++;
				if (currNode.getLeft() != null)
					nodeStack.push(currNode.getLeft());
				if (currNode.getRight() != null)
					nodeStack.push(currNode.getRight());
			}
		} return count;
	}

	// Returns true if the subtree rooted at node contains info i such that
	// comp.compare(target, i) == 0; otherwise, returns false.
	private boolean recContains(T target, BSTNode<T> node) {
		if (node == null)
			return false;       // target is not found
		else if (comp.compare(target, node.getInfo()) < 0)
			return recContains(target, node.getLeft());   // Search left subtree
		else if (comp.compare(target, node.getInfo()) > 0)
			return recContains(target, node.getRight());  // Search right subtree
		else
			return true;        // target is found
	}

	// Returns true if this BST contains a node with info i such that
	// comp.compare(target, i) == 0; otherwise, returns false.
	public boolean contains (T target) {
		return recContains(target, root);
	}

	// Returns info i from the subtree rooted at node such that
	// comp.compare(target, i) == 0; if no such info exists, returns null.
	private T recGet(T target, BSTNode<T> node) {
		if (node == null)
			return null;             // target is not found
		else if (comp.compare(target, node.getInfo()) < 0)
			return recGet(target, node.getLeft());         // get from left subtree
		else
			if (comp.compare(target, node.getInfo()) > 0)
				return recGet(target, node.getRight());        // get from right subtree
			else
				return node.getInfo();  // target is found
	}

	// Returns info i from node of this BST where comp.compare(target, i) == 0;
	// if no such node exists, returns null.
	public T get(T target) {
		return recGet(target, root);
	}

	// Adds element to tree rooted at node; tree retains its BST property.
	private BSTNode<T> recAdd(T element, BSTNode<T> node) {
		if (node == null)
			// Addition place found
			node = new BSTNode<T>(element);
		else if (comp.compare(element, node.getInfo()) <= 0)
			node.setLeft(recAdd(element, node.getLeft()));    // Add in left subtree
		else
			node.setRight(recAdd(element, node.getRight()));   // Add in right subtree
		return node;
	}

	// Adds element to this BST. The tree retains its BST property.
	public boolean add(T element) {
		root = recAdd(element, root);
		return true;
	}

	// Returns the information held in the rightmost node of subtree
	private T getPredecessor(BSTNode<T> subtree) {
		BSTNode<T> temp = subtree;
		while (temp.getRight() != null)
			temp = temp.getRight();
		return temp.getInfo();
	}

	// Removes the information at node from the tree.
	private BSTNode<T> removeNode(BSTNode<T> node) {
		T data;
		if (node.getLeft() == null)
			return node.getRight();
		else if (node.getRight() == null)
			return node.getLeft();
		else {
			data = getPredecessor(node.getLeft());
			node.setInfo(data);
			node.setLeft(recRemove(data, node.getLeft()));
			return node;
		}
	}

	// Removes element with info i from tree rooted at node such that
	// comp.compare(target, i) == 0 and returns true;
	// if no such node exists, returns false.
	private BSTNode<T> recRemove(T target, BSTNode<T> node) {
		if (node == null)
			found = false;
		else if (comp.compare(target, node.getInfo()) < 0)
			node.setLeft(recRemove(target, node.getLeft()));
		else if (comp.compare(target, node.getInfo()) > 0)
			node.setRight(recRemove(target, node.getRight()));
		else {
			node = removeNode(node);
			found = true;
		} return node;
	}

	// Removes a node with info i from tree such that comp.compare(target,i) == 0
	// and returns true; if no such node exists, returns false.
	public boolean remove (T target) {
		root = recRemove(target, root);
		return found;
	}

	// Creates and returns an Iterator providing a traversal of a "snapshot"
	// of the current tree in the order indicated by the argument.
	// Supports Preorder, Postorder, and Inorder traversal.
	public Iterator<T> getIterator(BSTInterface.Traversal orderType) {
		final LinkedQueue<T> infoQueue = new LinkedQueue<T>();
		if (orderType == BSTInterface.Traversal.Preorder)
			preOrder(root, infoQueue);
		else if (orderType == BSTInterface.Traversal.Inorder)
			inOrder(root, infoQueue);
		else if (orderType == BSTInterface.Traversal.Postorder)
			postOrder(root, infoQueue);
		return new Iterator<T>() {
			
			// Returns true if the iteration has more elements; otherwise returns false.
			public boolean hasNext() {
				return !infoQueue.isEmpty();
			}

			// Returns the next element in the iteration.
			// Throws NoSuchElementException - if the iteration has no more elements
			public T next() {
				if (!hasNext())
					throw new IndexOutOfBoundsException("illegal invocation of next " +
													" in BinarySearchTree iterator.\n");
					return infoQueue.dequeue();
			}
	
			// Throws UnsupportedOperationException.
			// Not supported. Removal from snapshot iteration is meaningless.
			public void remove() {
				throw new UnsupportedOperationException("Unsupported remove attempted on "
                                           + "BinarySearchTree iterator.\n");
			}
		};
	}

	// Enqueues the elements from the subtree rooted at node into q in preOrder.
	private void preOrder(BSTNode<T> node, LinkedQueue<T> q) {
		if (node != null) {
			q.enqueue(node.getInfo());
			preOrder(node.getLeft(), q);
			preOrder(node.getRight(), q);
		}
	}

	// Enqueues the elements from the subtree rooted at node into q in inOrder.
	private void inOrder(BSTNode<T> node, LinkedQueue<T> q) {
		if (node != null) {
			inOrder(node.getLeft(), q);
			q.enqueue(node.getInfo());
			inOrder(node.getRight(), q);
		}
	}

	// Enqueues the elements from the subtree rooted at node into q in postOrder.
	private void postOrder(BSTNode<T> node, LinkedQueue<T> q) {
		if (node != null) {
			postOrder(node.getLeft(), q);
			postOrder(node.getRight(), q);
			q.enqueue(node.getInfo());
		}
	}

	// InOrder is the default, "natural" order.
	public Iterator<T> iterator() {
		return getIterator(BSTInterface.Traversal.Inorder);
	}
	
	public void balance() {
		Iterator<T> iter = iterator();
		int index = 0;
		while(iter.hasNext()) {
			elements[index] = iter.next();
			index++;
		}
		root = null;
		insertTree(0, index - 1);
	}
	
	public void insertTree(int low, int high) {
		if(low == high) {
			add(elements[low]);
		} else if ((low + 1) == high) {
			add(elements[low]);
			add(elements[high]);
		} else {
			int mid =  ((low + high) / 2);
			add(elements[mid]);
			insertTree(low, mid - 1);
			insertTree(mid + 1, high);
		}
	}
	
	public void fRatio() {
		double ratio = fRatio(height(), size());
		
		if(ratio <= 0.50) {
			System.out.println("Ratio is: " + ratio + ". Balancing tree...");
			balance();
		} else {
			System.out.println("Ratio is: " + ratio + ". No need to balance tree.");
		}	
	}
	
	private double fRatio(double height, double size) {
		double actualHeight = 0;
		while(size > 0) {
			size = size - Math.pow(2, actualHeight);
			actualHeight++;
		}
		return (actualHeight - 1) / height;
	}
	
	public void breadthTraversal() {
		breadthTraversal(root);
	}
	
	private void breadthTraversal(BSTNode<T> node) {
		node = root;
		if(node == null)
			return;
		else {
			LinkedQueue<BSTNode<T>> queue = new LinkedQueue<BSTNode<T>>();
			queue.enqueue(node);
			
			while(!queue.isEmpty()) {
				BSTNode<T> temp = queue.dequeue();
				System.out.println(temp.getInfo());
				
				if(temp.getLeft() != null)
					queue.enqueue(temp.getLeft());
				if(temp.getRight() != null)
					queue.enqueue(temp.getRight());
			}
		}
	}
	
	private int findHeight(BSTNode<T> node) {
		if(node == null)
			return -1;
		int heightLeft = findHeight(node.getLeft());
		int heightRight = findHeight(node.getRight());
		
		if(heightLeft > heightRight)
			return heightLeft + 1;
		else
			return heightRight + 1;
	}
	
	public int height() {
		if(this.isEmpty())
			return 0;
		else {
			BSTNode<T> node = root;
			return findHeight(node);
		}
	}
	
	public int countGreater(T value) {
		int count = 0;
		if(this.isEmpty())
			return 0;
		else {
			BSTNode<T> node = root;
			LinkedQueue<T> queue = new LinkedQueue<T>();
			inOrder(root, queue);
			
			while(!queue.isEmpty()) {
				T element = queue.dequeue();
				if(comp.compare(element, value) == 1 || (comp.compare(element, value) == 0)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public int countLess(T value) {
		int count = 0;
		if(this.isEmpty())
			return 0;
		else {
			BSTNode<T> node = root;
			LinkedQueue<T> queue = new LinkedQueue<T>();
			inOrder(root, queue);
			
			while(!queue.isEmpty()) {
				T element = queue.dequeue();
				if(comp.compare(element, value) == -1 || (comp.compare(element, value) == 0)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public void print() {
		printNode(root);
	}
	
	public static <T extends Comparable<?>> void printNode(BSTNode root) {
		BSTNode<T> root2 = root;
		int maxLevel = maxLevel(root);
		printNodeInternal(Collections.singletonList(root2), 1, maxLevel);
	}

	private static <T extends Comparable<?>> void printNodeInternal(List<BSTNode<T>> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		printWhitespaces(firstSpaces);

		List<BSTNode<T>> newNodes = new ArrayList<BSTNode<T>>();
		for (BSTNode<T> node : nodes) {
			if (node != null) {
				System.out.print(node.getInfo());
				newNodes.add(node.getLeft());
				newNodes.add(node.getRight());
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}
			printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).getLeft() != null)
					System.out.print("/");
				else
					printWhitespaces(1);

				printWhitespaces(i + i - 1);

				if (nodes.get(j).getRight() != null)
					System.out.print("\\");
				else
					printWhitespaces(1);
				printWhitespaces(endgeLines + endgeLines - i);
			}
			System.out.println("");
		}
		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <T extends Comparable<?>> int maxLevel(BSTNode<T> node) {
		if (node == null)
			return 0;
		return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		} 
		return true;
	}

	
}