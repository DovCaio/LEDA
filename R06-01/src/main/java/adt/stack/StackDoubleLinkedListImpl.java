package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) throw new StackOverflowException();
		top.insertFirst(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()) throw new StackUnderflowException();
		
		SingleLinkedListNode aux =  ((SingleLinkedListImpl<T>) top).getHead();
		
		top.removeFirst();
		
		return (T) aux.getData();
	}

	@Override
	public T top() {
		SingleLinkedListNode aux =  ((SingleLinkedListImpl<T>) top).getHead();
		
		return (T) aux.getData();
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		if(top.size() == size) return true;
		return false;
	}

}
