package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if(leftIndex < 0 || rightIndex > array.length )throw new IllegalArgumentException();
		
		boolean swap = true;
		while(swap) {
			swap = false;
			int i = leftIndex;
			int j = leftIndex + 1; 
				
			for (int k = leftIndex; k < rightIndex; k++) {
				if(array[i].compareTo(array[j]) > 0) {
					T aux = array[j];
					array[j] = array[i];
					array[i] = aux;
					swap = true;
					}
				i++;
				j++;
			}
				
			}

	}
}
