package adt.heap.extended;

import java.util.Comparator;import adt.heap.ComparatorMaxHeap;
import adt.heap.ComparatorMinHeap;
import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		
		Comparator comparadorNormal = this.getComparator();
		
		this.setComparator(new ComparatorMaxHeap());
		
		
		
		for(int i = 0 ; i < array.length; i++) {
			
			if(array[i] <= numero) {
				this.insert(array[i]);
			}
			
		}
		
		Integer resultado = this.extractRootElement();
		
		this.heap = new Integer[0];
		
		this.setComparator(comparadorNormal);
		
		return resultado;
		
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		
		Comparator comparadorNormal = this.getComparator();
		
		this.setComparator(new ComparatorMinHeap());
		
				
		for(int i  = 0; i < array.length; i++) {
			
			if(array[i] >= numero) {
				insert(array[i]);
			}
			
		}
		
		Integer resultado = extractRootElement();
		
		this.setComparator(comparadorNormal);
		
		this.heap = new Integer[1];
		
		return resultado;
	}

}
