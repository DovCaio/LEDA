package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(elements == array.length) throw new QueueOverflowException();
		if (elements == 0) {
			head++;
			tail += 2;
			array[head] = element;
		}
		else {
			array[tail] = element;
			tail = ((tail + 1) % (array.length - 1)) ;
		}
		elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if(elements == 0 ) throw new QueueUnderflowException();
		
		T aux = array[head];
		head = ((head + 1) % (array.length - 1));
		elements--;
		return aux;
		
	}

	@Override
	public T head() {
		if(head == -1) return null;
		return array[head];
	}

	@Override
	public boolean isEmpty() {
		if(elements == 0) return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(elements == array.length) return true;
		return false;
	}

}
