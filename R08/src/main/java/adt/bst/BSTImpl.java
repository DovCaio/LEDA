package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		if(isEmpty()) return -1;
		else {
			int soma1 = 0;
			int soma2 = 0;
			
			if(this.root.getLeft() != null) {
				soma1 = height(this.root.getLeft());
			}
			if(this.root.getRight() != null) {
				soma2 = height(this.root.getRight());
			}
			
			return 1 + Math.max(soma1, soma2);
		}
		
	}
	
	private int height(BTNode node) {
		int resultado = 0;
		
		if(node.getLeft() != null && node.getLeft().getData() != null) {
			resultado = 1 + height(node.getLeft());
		}
		if(node.getRight() != null && node.getRight().getData() != null) {
			resultado =  1 + height(node.getRight());
		}
		
		return resultado;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode resultado = new BSTNode();
		
		if(!isEmpty() && element != null) {

		
			BSTNode aux = root;
			
			
			while(aux.getData() != null) {
				if(((Comparable)aux.getData()).compareTo(element) > 0) {
					
					if(aux.getLeft() != null && aux.getLeft().getData() != null) {
						aux = (BSTNode) aux.getLeft();
					}else {
						break;
					}
					
				}else if( ((Comparable) aux.getData()).compareTo(element) < 0){
					
					if(aux.getRight().getData() != null) {
						aux = (BSTNode) aux.getRight();
					}else {
						break;
					}
					
				}else {
					resultado = aux;
					break;
				}
				
			}
		}
		
		return resultado;
		
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if(isEmpty()) {
				this.root.setData(element);
				this.root.setLeft(new BSTNode());
				this.root.setRight(new BSTNode());
			}else {
				
				BTNode aux = this.root;
				
				while(aux.getData() != null) {
					if(((Comparable<T>) aux.getData()).compareTo(element) > 0) {
						if(aux.getLeft().getData() == null) {
							aux.getLeft().setData(element);
							aux.getLeft().setLeft(new BSTNode());
							aux.getLeft().setRight(new BSTNode());
							aux.getLeft().setParent(aux);
							return;
						}
						aux = aux.getLeft();
					}else {
						if(aux.getRight().getData() == null) {
							aux.getRight().setData(element);
							aux.getRight().setLeft(new BSTNode());
							aux.getRight().setRight(new BSTNode());
							aux.getRight().setParent(aux);
							return;
						}
						aux = aux.getRight();
					}
					
				}
				
			}
			
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if(this.isEmpty()) return null;
		
		BSTNode resultado;
		
		if(this.root.getRight().getData() != null) {
			resultado = maximum(this.root.getRight());
		}else {
			resultado =  this.root;
		}
		
		return resultado;
	}
	
	private BSTNode<T> maximum(BTNode<T> btNode){
		
		BSTNode<T> resultado = null;
		
		if(btNode.getRight() != null && btNode.getRight().getData() != null) {
			resultado = maximum(btNode.getRight());
		}else {
			resultado = (BSTNode) btNode;
		}
		
		
		return resultado;
	}

	@Override
	public BSTNode<T> minimum() {
		if(isEmpty()) return null;
		
		BSTNode resultado;
		
		if(this.root.getLeft().getData() != null) {
			resultado = minimum(this.root.getLeft());
		}else {
			resultado = this.root;
		}
		
		return resultado;
	}
	
	private BSTNode<T> minimum(BTNode<T> node){
		
		BSTNode<T> resultado = null;
		
		if(node.getLeft() != null && node.getLeft().getData() != null) {
			resultado = minimum(node.getLeft());
		}else {
			resultado = (BSTNode<T>) node;
		}
		
		
		return resultado;
		
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode resultado = null;
		
		if(!isEmpty() && element != null) {
			BSTNode noDoElemento = search(element);
			if(noDoElemento != null) {
				
				
				if(noDoElemento.getRight() != null && noDoElemento.getRight().getData() != null) {
					resultado = minimum(noDoElemento.getRight());
				}else {
					
					while(noDoElemento.getParent() != null) {
						noDoElemento = (BSTNode) noDoElemento.getParent();
						
						if(((Comparable<T>) noDoElemento.getData()).compareTo(element) > 0) {
							resultado = noDoElemento;
							break;
						}
					}
					
				}
				
				
			}
		}
		
		return resultado;
		
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode resultado = null;
		
		if(!isEmpty() && element != null) {
			BSTNode noDoElemento = search(element);
			if(noDoElemento != null) {
				
				if(noDoElemento.getLeft() != null && noDoElemento.getLeft().getData() != null) {
					
					resultado = maximum(noDoElemento.getLeft());
					
				}else {
					
					while(noDoElemento.getParent() != null) {
						
						noDoElemento = (BSTNode) noDoElemento.getParent();
						
						if(((Comparable<T>) noDoElemento.getData()).compareTo(element) < 0) {
							resultado = noDoElemento;
							break;
						}
						
					}
					
				}
				
			}
		}
		
		return resultado;
	}

	@Override
	public void remove(T element) {
		
		BSTNode elemento = search(element);
		
		if(!isEmpty() && element != null && elemento != null) {
		
			
			remove(elemento);
			
			
		}
			
		
	}
	
	
	private void remove(BSTNode<T> node) {
		if (node.getRight().isEmpty() && node.getLeft().isEmpty()) {
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
		} else if (node.getRight().isEmpty()) {
			node.setData(node.getLeft().getData());
			node.setRight(node.getLeft().getRight());
			node.setLeft(node.getLeft().getLeft());
			node.getRight().setParent(node);
			node.getLeft().setParent(node);
		} else if (node.getLeft().isEmpty()) {
			node.setData(node.getRight().getData());
			node.setLeft(node.getRight().getLeft());
			node.setRight(node.getRight().getRight());
			node.getRight().setParent(node);
			node.getLeft().setParent(node);
		} else {
			T value = node.getData();
			BSTNode<T> sucessor = sucessor(value);
			node.setData(sucessor.getData());
			sucessor.setData(value);
			remove((BSTNode<T>) sucessor);
		}


	}

	@Override
	public T[] preOrder() { //Raiz, esquerda e direita
		
		Comparable[] resultado = new Comparable[0];
		
		if(!isEmpty()) {
			resultado = preOrder(this.root);
		}
		
		return (T[]) resultado;
		
		
	}
	
	private T[] preOrder(BSTNode node) {
		
		T[] resultado = (T[]) new Comparable[0];
		
		if(node != null) {
			
			if(node.getData() != null) {
				resultado = (T[]) concat(resultado, new Comparable[] {(Comparable) node.getData()});
			}
			
			if(node.getLeft().getData() != null) {
				resultado = (T[]) concat(resultado, preOrder((BSTNode) node.getLeft()));
			}
			if(node.getRight().getData() != null) {
				resultado = (T[]) concat(resultado, preOrder((BSTNode) node.getRight()) );
			}
			
		}
		
		
		return (T[]) resultado;
		
		
	}
	
	
	private Comparable[] concat(Comparable[] lista1, Comparable[] lista2) {
		Comparable[] resultado = new Comparable[0];
		
		int tam1 = lista1.length;
		int tam2 = lista2.length;
		
		
		
		
		if(tam1 == 0 && tam2 != 0) {
			resultado = lista2;
		}else if(tam1 != 0 && tam2 == 0) {
			resultado = lista1;
		}else if(tam1 != 0 && tam2 != 0) {
			
			resultado = new Comparable[tam1 + tam2];
			
			int i = 0;
			int k = 0;
			while( k < tam1) {
				if(lista1[k] != null) {
					resultado[i] = lista1[k];
					i++;
				}
				k++;
			}
			
			int j = 0;
			
			while( j < tam2) {
				if(lista2[j] != null) {
					resultado[i] = lista2[j];
					i++;
				}
				j++;
			}
			
		}else {
			resultado = new Comparable[0];
		}
		


		
		return resultado;
	}
	

	@Override
	public T[] order() {
		Comparable[] resultado = new Comparable[0];
		
		if(!isEmpty()) {
			
			resultado = order(this.root);
			
		}
		
		return (T[]) resultado;
		
	}
	
	private T[] order(BSTNode node) {
		Comparable[] resultado = new Comparable[0];
		
		
		if(node != null) {
			
			if(node.getLeft() != null) {
				resultado = concat(resultado, order((BSTNode) node.getLeft()));
			}
			
			if(node.getData() != null) {
				resultado = concat(resultado, new Comparable[] {(Comparable) node.getData()});
			}
			if(node.getRight() != null) {
				resultado = concat(resultado, order((BSTNode)node.getRight()));
			}
			
			
		}
		
		return (T[]) resultado;
	}

	@Override
	public T[] postOrder() {
		Comparable[] resultado = new Comparable[0];
		
		if(!isEmpty()) {
			
			resultado = postOrder(this.root);
			
		}
		
		return (T[]) resultado;
	}
	
	private T[] postOrder(BSTNode node) {
		
		Comparable[] resultado = new Comparable[0];
		
		if(node != null) {
			
			if(node.getLeft() != null) {
				resultado = concat(resultado, postOrder((BSTNode) node.getLeft()));
			}
			
			if(node.getRight() != null) {
				
				resultado = concat(resultado, postOrder((BSTNode) node.getRight()));
				
			}
			
			if(node.getData() != null) {
				resultado = concat(resultado, new Comparable[] {(Comparable) node.getData()});
			}
		}
		
		return (T[]) resultado;
		
	}


	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (node != null && !node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
