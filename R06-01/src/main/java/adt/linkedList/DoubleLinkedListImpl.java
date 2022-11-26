package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl(){
		DoubleLinkedListNode aux = new DoubleLinkedListNode<>();
		
		aux.next = new DoubleLinkedListNode<>();
		aux.previous = new DoubleLinkedListNode();
		
		head = aux;
		last = (DoubleLinkedListNode<T>) head;
	}
	
	@Override
	public void insertFirst(T element) {
		if(this.isEmpty()) {

			
			head.data = element;
			last = (DoubleLinkedListNode) head;
			
			
		}else {
			
			SingleLinkedListNode aux = new DoubleLinkedListNode<>();
			
			DoubleLinkedListNode aux2 = new DoubleLinkedListNode<>();
			
			aux2 = (DoubleLinkedListNode<T>) head;
			
			aux.data = element;
			aux.next = aux2;
			
			aux2.previous = (DoubleLinkedListNode) aux;
			
			head = aux;
			
		}
	}
	
	@Override
	public void insert(T element) {
		if(this.isEmpty()) {
			
			head.data = element;
			
			head.next = (DoubleLinkedListNode) new DoubleLinkedListNode();
			
			last = (DoubleLinkedListNode) head;
			
			
		}else {
			
			last.next.data = element;
			last.next.next = new DoubleLinkedListNode();
			last = (DoubleLinkedListNode<T>) last.next;
			
		}
		
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty()) return;
		
		head = head.next;
	}

	@Override
	public void removeLast() {
		if(this.isEmpty()) return;
		last.data = null;
		last = last.previous;
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
