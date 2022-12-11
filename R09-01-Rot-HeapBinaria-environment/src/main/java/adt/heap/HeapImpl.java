package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o menor sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 2 < 3),
 * essa heap deixa os elementos menores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. 
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma max-heap 
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é
	 * mudar apenas o comparator e mandar reordenar a heap usando esse
	 * comparator. Assim os metodos da heap não precisam saber se vai funcionar
	 * como max-heap ou min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma
	 * min-heap. OU seja, voce deve considerar que a heap usa o comparator
	 * interno e se o comparator responde compare(x,y) < 0 entao o x eh menor
	 * e sobe na heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (int i = 0; i <= this.index; i++) {
			resp.add(this.heap[i]);
		}
		return (T[])resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode
	 * ser a raiz da heap ou de uma sub-heap. O heapify deve usar o comparator
	 * para subir os elementos na heap.
	 */
	private void heapify(int position) {
		
		int esquerda = left(position);
		int direita = right(position);
		
		if(esquerda > this.index && direita > this.index) return;
		
		int maior = position;
		
		if(comparator.compare(this.heap[maior], (this.heap[esquerda])) < 0) {maior = esquerda;}
		
		if(comparator.compare(this.heap[maior], this.heap[direita]) < 0) maior = direita;
		
		if(maior != position) {
			swap(position, maior);
			heapify(maior);
			
		}
		
	}
	
	
	private void swap(int posicao1, int posicao2) {
		
		T aux = this.heap[posicao1];
		this.heap[posicao1] = this.heap[posicao2];
		this.heap[posicao2] = aux;
		
	}
	

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		// /////////////////////////////////////////////////////////////////
		// TODO Implemente a insercao na heap aqui.
		
		if(element != null) {
			
			this.index++;
			
			this.heap[index] = element;

			int i = this.index;
			
			while(i > 0 && comparator.compare(this.heap[parent(i)], this.heap[i]) < 0) {
				
				swap(parent(i), i);
				i = parent(i);
				
			}
			
			
		}
		
		
	}

	@Override
	public void buildHeap(T[] array) {
		
		
		if(array != null) {
			
			this.heap = (T[]) new Comparable[array.length];
			
			for(T elemento : array) {
				
				insert(elemento);
				
			}
			
			
		}
		
	}

	@Override
	public T extractRootElement() {
		T resultado = null;
		
		if(!isEmpty()) {
			
			resultado = this.heap[0];
			this.heap[0] = this.heap[this.index];
			this.index--;
			
			heapify(0);
			
		}
		
		
		return resultado;
	}

	@Override
	public T rootElement() {
		T resultado = null;
		
		
		if(!isEmpty()) {
			
			resultado = this.heap[0];
			
		}
		
		
		return resultado;
	}

	@Override
	public T[] heapsort(T[] array) {
		
		
		if(array != null) {
			buildHeap(array);
			
			//System.out.println(this.heap[0]);
			sort(0, array.length - 1);
			System.out.println(this.index);
			
			
		}
		T[] resultado = this.toArray();
		this.heap = (T[]) new Comparable[0];
		this.index = -1;
		
		return resultado;
		
	}
	
	
	
	private void sort(int left, int right) {
		
		if(left < right) {
			int pivot = partitionCovencional(left, right);
			sort(left, pivot - 1);
			sort(pivot + 1, right);
			
		}
		
		
		
		
	}
	
	public int partitionCovencional( int leftIndex, int rigthIndex) {
		
		T pivot = this.heap[leftIndex];
		int i = leftIndex;
		
		for(int j = leftIndex + 1; j <= rigthIndex; j++) {
			if(this.heap[j].compareTo(pivot) <= 0) {
				i++;
				swap( i, j);
			}
		}
		
		swap(leftIndex, i);
		return i;
		
	}
	
	
	

	@Override
	public int size() {
		return this.index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
