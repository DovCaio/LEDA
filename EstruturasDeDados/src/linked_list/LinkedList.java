package linked_list;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

/**
 * Linked list surge para resolver o problema do ArrayList do uso indiscriminado de memória, uma vez
 * que o ArrayList tem a necesidade de criar sempre um novo array interno maior do que o que já tinha
 * antes.
 * 
 * LinkedList é uma lista dinâmica, onde os espaços são criados sob demanda, e isso é feito apartir
 * de referencia aos vizinhos do objeto
 * 
 * @author Caio Jhonatan Alves Pereira
 *
 */
public class LinkedList {

	/**
	 * Para faciliar a inserção de elementos no início do linkedList;
	 */
	private Node head; 
	
	/**
	 * Para facilitar a inserção de elementos no fim do linkedList
	 */
	private Node tail;
	
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	
	/**
	 * Complexidade O(1)
	 * 
	 * @param aluno
	 */
	public void addLast(Aluno aluno) {
		Node newNode = new Node(aluno);
		
		if(isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		}else {
			this.tail.next = newNode;
			newNode.prev = tail;
			this.tail = newNode;
		}
		
		this.size++;
		
	}
	
	/**
	 * Complexidade O(1);
	 * 
	 * @param aluno
	 */
	public void addFirst(Aluno aluno) {
		Node newNode = new Node(aluno);
		
		if(isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		}else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		
		this.size++;
	}
	
	/**
	 * Complexidade O(n)
	 * 
	 * @param index
	 * @param aluno
	 */
	public void add(int index, Aluno aluno) {
		if(index < 0 || index > size) throw new IndexOutOfBoundsException();
		
		Node newNode = new Node(aluno);
		
		if(index == 0) {
			this.addFirst(aluno);
		}else if(index == size - 1) {
			this.addLast(aluno);
		}else {
			Node aux = this.head;
			
			for(int i = 0; i < index - 1; i++) {
				aux = aux.next;
			}
			
			newNode.next = aux.next;
			aux.next = newNode;
			newNode.next.prev = newNode;
			newNode.prev = aux;
			
			size++;
		}
	}
	
	/**
	 * Complexidade O(n)
	 * 
	 * @param index
	 * @return
	 */
	public Aluno get(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		Node aux = this.head;
		
		for(int i = 0 ; i < index ; i++) {
			aux = aux.next;
		}
		
		return aux.aluno;
	}
	
	public int indexOf(Aluno aluno) {
		Node aux  = this.head;
		int index = 0;
		
		while(aux != null) {
			if(aux.aluno.getMatricula() == aluno.getMatricula()) return index;
			aux = aux.next;
			index += 1;
		}
		
		return -1;
	}
	
	public boolean contains(Aluno aluno) {
		return indexOf(aluno) != -1;
	}
	
	public Aluno getFirst() {
		if(isEmpty()) return null;
		return this.head.aluno;
	}
	
	public Aluno getLast() {
		if(isEmpty()) return null;
		return this.tail.aluno;
	}
	
	public Aluno removeFirst() {
		if(isEmpty()) throw new NoSuchElementException();
		
		Aluno aluno = this.head.aluno;
		
		if(this.head.next == null) {
			tail = null;
			head = null;
		}else {
			this.head = this.head.next;
			this.head.prev = null;
		}
		
		size--;
		return aluno;
	}
	
	public Aluno removeLast() {
		if(isEmpty()) throw new NoSuchElementException();
		
		Aluno aluno = this.tail.aluno;
		
		if(this.head.next == null) {
			this.head = null;
			this.tail = null;
		}else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		
		size--;
		return aluno;
	}
	
	public Aluno remove(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		if(index == 0) return removeFirst();
		if(index == size - 1) return removeLast();
		
		Node aux = this.head;
		for(int i  = 0; i < index; i++) {
			aux = aux.next;
		}
		
		aux.prev.next = aux.next;
		aux.next.prev = aux.prev;
		size--;
		return aux.aluno;
	}
	
	public boolean remove(Aluno aluno) {
		
		Node aux = this.head;
		
		for(int i = 0; i < this.size; i++) {
			if(aux.aluno.equals(aluno)) {
				if(i == 0) removeFirst();
				else if(i == size - 1 ) removeLast();
				else {
					aux.prev.next = aux.next;
					aux.next.prev = aux.prev;
					size--;
				}
				return true;
			}
			aux = aux.next;
		}
		return false;
		
	}
	
	
	
	
}

/**
 * 
 * Node é um Nó que guarda o anterior e o próximo elementos linkado.
 * 
 * @author Caio Jhonatan Alves Pereira
 *
 */
class Node {
	
	Aluno aluno;
	Node next;
	Node prev;
	
	public Node(Aluno aluno) {
		this.aluno = aluno;
		this.prev = null;
		this.next = null;
	}
	
}


/**
 * Objeto usado como exemplo.
 * 
 * @author Caio Jhonatan Alves Pereira
 *
 */
class Aluno{

	String nome;
	int matricula;
	
	Aluno(String nome, int matricula){
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public int getMatricula() { return this.matricula;}
}