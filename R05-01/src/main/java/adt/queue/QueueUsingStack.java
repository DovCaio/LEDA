package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(stack1.isFull()) throw new QueueOverflowException();
		
		try {
			stack1.push(element);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(stack1.isEmpty()) throw new QueueUnderflowException();
		
		while(!stack1.isEmpty()) {
			try {
				stack2.push(stack1.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		T aux = null;
		
		try {
			aux = stack2.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(!stack2.isEmpty()) {
			
			try {
				stack1.push(stack2.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return aux;
	}

	@Override
	public T head() {
		
		while(!stack1.isEmpty()) {
			
			try {
				stack2.push(stack1.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		T cabeca = null;
		
		try {
			cabeca = stack2.pop();
			stack2.push(cabeca);
		} catch (StackUnderflowException | StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(!stack2.isEmpty()) {
			
			try {
				stack1.push(stack2.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return cabeca;
		
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

}
