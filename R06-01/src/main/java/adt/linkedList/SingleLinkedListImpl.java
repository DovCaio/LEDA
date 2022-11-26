package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		if(this.isEmpty()) return 0;
		else {
			int contador = 0;
			SingleLinkedListNode aux = head;
			
			while(!aux.isNIL()) {
				contador++;
				aux = aux.next;
			}
			return contador;
		}
	}

	@Override
	public T search(T element) {
		if(this.isEmpty()) return null;
		
		SingleLinkedListNode aux = head;
		T retorno = null;
		
		while(!aux.next.isNIL()) {
			if(aux.data.equals(element)) {
				retorno = (T) aux.data;
				break;
			}
			aux = aux.next;
		}
		return retorno;
		
	}

	@Override
	public void insert(T element) {
		
		if(isEmpty()) {head.data = element;head.next = new SingleLinkedListNode();}
		else {
			SingleLinkedListNode aux = head;
			while(!aux.isNIL()) {
				aux = aux.next;
			}
			aux.data = element;
			aux.next = new SingleLinkedListNode();
		}
		
	}
	
	
	private void removeInicio() {
		head = head.next;
	}
	

	@Override
	public void remove(T element) {
		if(isEmpty()) return;
		
		SingleLinkedListNode aux = head;
		
		int tamanho = size();
		
		if(aux.data.equals(element)) removeInicio();
		
		int i;
		for(i = 0; i < tamanho - 2; i++) {
			if(aux.next.data.equals(element)) {
				aux.next = aux.next.next;
			}
			
			aux = aux.next;
		}
		if(!aux.next.isNIL()) {
			aux = aux.next;
			if(aux.data.equals(element)) {
				aux.data = null;
			}
		}
		
		
		
	}

	@Override
	public T[] toArray() {
		T[] aux = (T[]) new Object[size()];
		
		SingleLinkedListNode aux2 = head;
		
		int i = 0;
		while(!aux2.isNIL()) {
			aux[i] = (T) aux2.data;
			aux2 = aux2.next;
			i++;
		}
		return aux;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
