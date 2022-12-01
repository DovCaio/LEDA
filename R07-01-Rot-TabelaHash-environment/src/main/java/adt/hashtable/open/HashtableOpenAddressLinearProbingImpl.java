package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	private int pegaHash(T element, int probe) {
		return ((HashFunctionLinearProbing) this.hashFunction).hash(element, probe);
	}
	
	@Override
	public void insert(T element) {
		
		if(element == null) return;
		
		
		
		int probe = 0;
		int hash = pegaHash(element, probe);

		
		while(this.table[hash] != null) {
			
			
			hash = pegaHash(element, probe++);

			if(probe > 1) this.COLLISIONS++;
			
			
			
			if(hash > size()) return;

			
		}
		
		
		this.table[hash] = element;
		
		this.elements++;
		
	}

	@Override
	public void remove(T element) {
		if(element == null) return;
		
		int probe = 0;
		int hash = pegaHash(element, probe);
		
		if(this.table[hash] == null) return;
		

		
		while(!this.table[hash].equals(element)) {
			hash = pegaHash(element, probe++);
			
			if(hash > size()) return;
			
		}
		
		
		this.table[hash] = new DELETED();
		this.elements--;
	}

	@Override
	public T search(T element) {
		if(element == null) return null;
		
		int probe = 0;
		int hash = pegaHash(element, probe);
		
		if(this.table[hash] == null) return null;
		

		while(!this.table[hash].equals(element)) {
			hash = pegaHash(element, probe++);
			
			if(hash > size()) return null;
			
			
		}
		
		return (T) this.table[hash];
	}

	@Override
	public int indexOf(T element) {
		if(element == null) return -1;
		
		int probe = 0;
		int hash = pegaHash(element, probe);
		
		if(this.table[hash] == null) return -1;
		
		
		while(!this.table[hash].equals(element)) {
			hash = pegaHash(element, probe++);
			
			if(this.table[hash] == null) return -1;
			
		}
		
		return hash;
	}

}
