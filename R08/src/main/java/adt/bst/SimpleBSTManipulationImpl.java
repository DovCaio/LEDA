package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	
	private boolean iguais(T[] elementos1, T[] elementos2) {
		
		boolean resultado = true;
		
		
		if(elementos1.length == elementos2.length) {
			
			for(int i = 0; i < elementos1.length; i++) {
				
				if(!elementos1[i].equals(elementos2[i])) {resultado = false; break;}
				
			}
			
		}else resultado = false;
		
		
		return resultado;
	}
	
	
	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean resultado = false;
		
		if(tree1 != null && tree2 != null) {
			if(tree1.size() == tree2.size() && tree1.height() == tree2.height()) {
				
				resultado = equals(tree1.getRoot(), tree2.getRoot());
				
			}
		}
		
		return resultado;
		
	}
	
	private boolean equals(BTNode node1, BTNode node2) {
		boolean resultado = true;
		
		if(node1.getData().equals(node2.getData())) {}
		else resultado = false;
		
		if(node1.getLeft() != null && node2.getLeft() != null && resultado) {
			resultado = equals(node1.getLeft(), node2.getLeft());
		}
		if(node1.getRight() != null && node2.getRight() != null && resultado) {
			resultado = equals(node1.getRight(), node2.getRight());
		}
		
		return resultado;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean resultado = false;
		
		if(tree1 != null && tree2 != null) {
			
			if(tree1.size() == tree2.size() && tree1.height() == tree2.height()) {
				resultado = isSimilar(tree1.getRoot(), tree2.getRoot());
				
			}
			
		}
		return resultado;
	}
	
	
	private boolean isSimilar(BTNode node1, BTNode node2) {
		boolean resultado = true;
		
		if(node1.getRight() != null && node2.getRight() != null) {
			
			resultado = isSimilar(node1.getRight(), node2.getRight());
			
		}
		
		if(node1.getLeft() != null && node2.getLeft() != null) {
			
			resultado = isSimilar(node1.getLeft(), node2.getLeft());
			
		}
		
		if(!(node1.getLeft() != null && node2.getLeft() != null) ||
				(node1.getLeft() == null && node2.getLeft() == null) && resultado) {
			
			resultado = false;
			
			
		}
		
		if(!(node1.getRight() != null && node2.getRight() != null) ||
				(node1.getRight() == null && node2.getRight() == null) && resultado) {
			
			resultado = false;
			
			
		}
		
		
		
		return resultado;
	}
	

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		
		T resultado = null;
		
		if(tree != null && (k >= 0 && k <= tree.size())) {
			
			resultado = orderStatistic(tree, tree.minimum(), k);
			
		}
		
		return resultado;
	}
	
	
	
	private T orderStatistic(BST tree ,BTNode node, int k) {
		T resultado = null;
		
		if(k == 1) resultado = (T) node.getData();
		else {
			
			resultado = orderStatistic(tree, tree.sucessor((Comparable) node.getData()), k--);
			
		}
		
		
		return resultado;
	}

}
