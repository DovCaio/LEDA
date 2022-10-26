package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		boolean swap = true;
		
		while(swap) {
			swap = false;
			int i = leftIndex;
			int j = leftIndex + 1;
			
			for(int k = leftIndex; k < rightIndex; k++) {
				if(array[i].compareTo(array[j]) > 0) {
					T aux = array[j];
					array[j] = array[i];
					array[i] = aux;
					swap = true;
				}
				i++; j++;
			}
			
			int m = rightIndex;
			int n = rightIndex - 1;
			
			for(int l = rightIndex; l > leftIndex; l--) {
				if(array[m].compareTo(array[n]) < 0) {
					T aux = array[n];
					array[n] = array[m];
					array[m] = aux;
					swap =  true;
				}
				m--;
				n--;
			}
			
		}
		
	}
}
