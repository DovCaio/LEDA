package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		previous = null;
		next = null;
	}

	@Override
	public void insertFirst(T element) {
		if(this.data == null && next == null && previous == null) {
			this.data = element;
			
			RecursiveSingleLinkedListImpl<T> aux1 = new RecursiveDoubleLinkedListImpl<>();
			RecursiveDoubleLinkedListImpl<T> aux2 = new RecursiveDoubleLinkedListImpl<>();
			
			aux1.next = this;
			aux2.previous = this;
			
			this.previous = (RecursiveDoubleLinkedListImpl<T>) aux1;
			this.next = aux2;
			
		}else if (this.data == null && this.previous == null){
			this.data = element;
			
			RecursiveDoubleLinkedListImpl aux = new RecursiveDoubleLinkedListImpl<>();
			
			aux.next = this;
			
			this.previous = aux;
		
			
			
		}else {
			previous.insertFirst(element);
		}
	}
	
	@Override
	public void insert(T element) {
		if(this.isEmpty() && this.next == null && this.previous == null) {
			this.data = element;
			RecursiveSingleLinkedListImpl aux1 = new RecursiveDoubleLinkedListImpl<>();
			RecursiveDoubleLinkedListImpl<T> aux2 = new RecursiveDoubleLinkedListImpl<>();
			
			aux1.next = this;
			aux2.previous = this;
			
			this.previous = (RecursiveDoubleLinkedListImpl<T>) aux1;
			this.next = aux2;
		}else if(this.data == null && this.next == null) {
			this.data = element;
			
			RecursiveDoubleLinkedListImpl aux = new RecursiveDoubleLinkedListImpl<>();
			
			aux.previous = this;
			
			this.next  = aux;
		}else {
			
			next.insert(element);
			
		}
	}
	
	
	@Override
	public T[] toArray() {
	
		Object[] retorno;
		
		if (isEmpty()) {retorno = new Object[0];}
		else if(this.previous.data == null && this.next.data != null) retorno = toArrayPraFrente();
		else if(this.next.data == null && this.previous.data != null) retorno = inverteArray(toArrayPraTras());
		else { retorno = concat(inverteArray(previous.toArrayPraTras()), toArrayPraFrente());}
		
		
		
		return (T[]) retorno;
		
	}
	
	private T[] inverteArray(T[] array) {
		Object[] aux = new Object[array.length];
		
		int j = 0;
		for(int i = array.length - 1; i >= 0; i--) {
			aux[j] = array[i];
			j++;
		}
		
		return (T[]) aux;
	}
	
	private T[] toArrayPraFrente() {
	
		
		Object[] retorno = new Object[1];
		
		if(isEmpty()) {
			return (T[]) retorno;
		}else if(this.next.data == null) {
			
			Object[] aux = {this.data};
			return (T[]) aux;
		}else {
			
			retorno[0] = this.data;
			
			retorno = concat(retorno, ((RecursiveDoubleLinkedListImpl<T>) this.next).toArrayPraFrente());
			
		}
		
		return (T[]) retorno;
		
	}
	
	private T[] toArrayPraTras() {
		
		Object[] retorno = new Object[1];
		
		if(isEmpty()) {
			return (T[]) retorno;
		}else if(this.previous.data == null) {
			Object[] aux = {this.data};
			return (T[]) aux;
		}else {
			retorno[0] = this.data;
			
			retorno = concat(retorno, this.previous.toArrayPraTras());
		}
		
		return (T[]) retorno;
	}
	
	
	@Override
	public int size() {

		return tamanhoPraTras() + tamanhoPraFrente();
	}
	
	private int tamanhoPraTras() {
		if(previous == null) return 0;
		if (this.previous.data == null) return 0;
		else {
			return 1 + this.previous.tamanhoPraTras();
		}
	}
	
	private int tamanhoPraFrente() {
		if(this.data == null) return 0;
		else {
			return 1 + ((RecursiveDoubleLinkedListImpl<T>) this.next).tamanhoPraFrente();
		}
	}
	
	

	@Override
	public void removeFirst() {
		if(data == null && next == null && previous == null) return;
		
		if(this.previous.data == null) {
			
			this.afasta(this);
			
		}else {
			previous.removeFirst();
		}
	}
	
	public void afasta(RecursiveDoubleLinkedListImpl<T> aux) {
		
		if(next.data != null){
			aux.data = next.data;
			aux.afasta((RecursiveDoubleLinkedListImpl<T>) next);
		}else if(next.data == null) {
			next = null;
			this.data = null;
		}
	}

	@Override
	public void removeLast() {
		if(this.isEmpty() && next == null && previous == null) {
			return;
		}
		
		if(this.next.data == null) {
			this.data = null;
			this.next = null;
		}else {
			((DoubleLinkedList<T>) next).removeLast();
		}
		
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
