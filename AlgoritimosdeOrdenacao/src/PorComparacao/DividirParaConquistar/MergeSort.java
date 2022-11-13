package PorComparacao.DividirParaConquistar;

public class MergeSort<T extends Comparable<T>> {

	public void sort(T[] array, int leftIndex, int rigthIndex) {
		
		if(leftIndex >= rigthIndex) {
			return;
		}
		
		int middle = (leftIndex + rigthIndex) / 2;
		sort(array, leftIndex, middle);
		sort(array, middle + 1, rigthIndex);
		
		merge(array, leftIndex, middle, rigthIndex);
		
	}
	
	public void merge(T[] array, int leftIndex, int middle, int rigthIndex) {
		
		Comparable[] auxiliar = new Comparable[array.length]; 
		
		for(int i  = 0; i < array.length; i++) {
			auxiliar[i] = array[i];
		}
		
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;
		
		while(i <= middle && j <= rigthIndex) {
			if(auxiliar[i].compareTo(auxiliar[j]) < 0) {
				array[k] = (T) auxiliar[i];
				i++;
			}else {
				array[k] = (T) auxiliar[j];
				j++;
			}
			k++;
		}
		
		while(i <= middle) {
			array[k] = (T) auxiliar[i];
			i++;
			k++;
		}
		
		while(j <= rigthIndex) {
			array[k] = (T) auxiliar[j];
			j++;
			k++;
		}
	}
	
}
