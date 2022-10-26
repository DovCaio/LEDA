package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0 || rightIndex > array.length )throw new IllegalArgumentException();
		
		for(int i = leftIndex; i < rightIndex + 1; i++) {
			int j = i;
			while(j > 0 && array[j].compareTo(array[j - 1]) < 0) {
					T aux = array[j];
					array[j] = array[j - 1];
					array[j - 1] = aux;
					j--;
			}
			
		}
		
		
	}
}
