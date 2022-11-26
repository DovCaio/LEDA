package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
		this.data = null;
		this.next = null;
	}


	@Override
	public boolean isEmpty() {
		if (data == null) return true;
		return false;
	}

	@Override
	public int size() {
		if (isEmpty()) return 0;
		
		if(next == null) {
			return 0;
		}else {
			return 1 + next.size();			
		}
		
	}

	@Override
	public T search(T element) {
		if (this.isEmpty()) return null;
		
		T retorno = null;
		if(data.equals(element)) {
			retorno = data;
		}else {
			retorno = next.search(element);
		}
		return retorno;
	}

	@Override
	public void insert(T element) {
		if(next == null) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<>();
		}else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(data.equals(element)) {
			this.data = null;
		}else if (next.data == null){
			//Do nothing
		}else {
			this.next.remove(element);
		}
	}

	@Override
	public T[] toArray() {
		
		Object[] retorno = new Object[1];
		
		if(this.isEmpty()){
			Object[] erro = new Object[0];
			return (T[]) erro;
		}else if( next.data == null) {
			Object[] aux = {data};
			
			return (T[]) aux;
		}else {
			
			retorno[0] = data;
			
			retorno = concat(retorno, next.toArray());
			
		}
		
		return (T[]) retorno;
		
		
	}
	
	
	protected Object[] concat(Object[] array1, Object[] array2) {
		int tamanho_total = array1.length + array2.length;
		Object[] aux = new Object[tamanho_total];
		
		int j = array1.length - 1;
		for(int i = 0 ; i < tamanho_total; i++) {
			if(i < array1.length) {
				aux[i] =  array1[i];
			}else {
				aux[i] = array2[j];
				j++;
			}
		}
		
		
		return aux;
	}
	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
