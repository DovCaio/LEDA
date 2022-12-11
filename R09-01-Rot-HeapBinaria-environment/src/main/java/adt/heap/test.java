package adt.heap;

public class test {

	
	static public void main (String[] args) {
		
		HeapImpl heap = new HeapImpl<>(new ComparatorMaxHeap());
		
		Integer[] array = {4, 1, 6, 1, 2, 7};
		
		
		Comparable[] ordenado = (Comparable[]) heap.heapsort(array);
		
		for(Comparable numero : ordenado) {
			
			System.out.println(numero);
			
		}
	}
	
	
}
