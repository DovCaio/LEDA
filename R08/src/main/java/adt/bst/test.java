package adt.bst;

import static org.junit.Assert.assertEquals;

public class test {

	
	public static void main(String[] args) {
		
		BSTImpl tree = new BSTImpl<>();
		

		
		Integer[] array =  {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
		
		for(Comparable numero : array) {
		
			tree.insert(numero);
			
		}
		
		int size = 12;
		
		tree.remove((Comparable) tree.getRoot().getData());
		System.out.println(--size + " " + tree.size());
		
		tree.remove((Comparable) tree.getRoot().getData());
		System.out.println(--size + " " + tree.size());
		
		tree.remove((Comparable) tree.getRoot().getData());
		System.out.println(--size + " " + tree.size());
		
		tree.remove((Comparable) tree.getRoot().getData());
		System.out.println(--size + " " + tree.size());
		
	}
	
}
