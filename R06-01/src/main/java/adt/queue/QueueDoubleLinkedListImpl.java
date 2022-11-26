package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) throw new QueueOverflowException();
		list.insertFirst(element);
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(list.isEmpty()) throw new QueueUnderflowException();
		
		
		DoubleLinkedListImpl aux = (DoubleLinkedListImpl) list;
		
		list.removeFirst();
		
		return (T) aux.getLast().getData();
	}

	@Override
	public T head() {
		if(this.isEmpty()) return null;
		
		DoubleLinkedListNode<T> aux = ((DoubleLinkedListImpl<T>) list).getLast();
		
		return aux.getData();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		if(list.size() == size) return true;
		return false;
	}

}
