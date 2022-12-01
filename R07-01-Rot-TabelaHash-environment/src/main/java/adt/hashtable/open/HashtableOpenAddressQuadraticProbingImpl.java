package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	private int pegaHash(T element, int probe) {
		return ((HashFunctionQuadraticProbing) this.hashFunction).hash(element, probe);
	}
	
	@Override
	public void insert(T element) {
		if (isFull()) {
			return;
		}
		
		if(element == null) return;
		
		int probe = 0;
		int hash = pegaHash(element, probe);
		
		while (this.table[hash] != null  && probe < this.table.length) {
			probe += 1;
			hash = pegaHash(element, probe);
			this.COLLISIONS += 1;
		}
		this.table[hash] = element;
		this.elements += 1;
		
		
		
	}

	@Override
	public void remove(T element) {
		if(element == null) return;
		if(isEmpty()) return;
		
		int probe = 0;
		int hash = pegaHash(element, probe);
		
		while(probe < this.table.length && this.table[hash] != null && !this.table[hash].equals(element)) {
			
			hash = pegaHash(element, probe++);
			

			
		}
		
		if(this.table[hash] != null && this.table[hash].equals(element)) {
			this.table[hash] = new DELETED();
			this.elements--;
			
		}
		
	}

	@Override
	public T search(T element) {
		
		if(element == null) return null;
		if(isEmpty()) return null;
		
		if(indexOf(element) < 0) return null;
		
		return (T) this.table[indexOf(element)];
	}

	@Override
	public int indexOf(T element) {
		int resultado = -1;
		if(isEmpty()) return -1;
		if(element == null) return -1;

		int probe = 0;
		int hash = pegaHash(element, probe);

		while (this.table[hash] != null && !this.table[hash].equals(element) && probe < this.table.length) {
			probe += 1;
			hash = pegaHash(element, probe);
			}
		if (probe < this.table.length) {
			resultado = hash;
		}
			
		
		return resultado;
	}
}
