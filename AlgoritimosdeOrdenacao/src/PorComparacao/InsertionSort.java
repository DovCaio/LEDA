package PorComparacao;

public class InsertionSort<T extends Comparable<T>> {

	public void sortInteractive(T[] array) {
		
		for(int i = 1 ; i < array.length; i++) {
			int j = i;
			
			while(j > 0 && array[j].compareTo(array[j - 1]) < 0) {
				T aux = array[j];
				array[j] = array[j - 1];
				array[j - 1] = aux;
				j--;
 			}
		}
		
	}
	
	public void sortRecursive(T[] array, int leftIndex, int rigthIndex) {
		if(leftIndex >= rigthIndex) return;
		
		int i = leftIndex + 1;
		while(i > 0 && array[i].compareTo(array[i - 1]) < 0) {
			T aux = array[i];
			array[i] = array[i - 1];
			array[i - 1] = aux;
			i--;
		}
		sortRecursive(array, leftIndex + 1, rigthIndex);
	}
	
}
