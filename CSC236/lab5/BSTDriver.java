package lab5;

import java.util.Iterator;

public class BSTDriver {
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		
		bst.add(1);
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(6);
		
		System.out.println(">=: " + bst.countGreater(3));
		System.out.println("<=: " +bst.countLess(4));
		System.out.println("Height: " + bst.height());
		
		System.out.println("\n");
		bst.breadthTraversal();
		
		bst.print();
		
		bst.fRatio();

		bst.breadthTraversal();
		
		bst.print();
		
		bst.fRatio();
		
	}

}
