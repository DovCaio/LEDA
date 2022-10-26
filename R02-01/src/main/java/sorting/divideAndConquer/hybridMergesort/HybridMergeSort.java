package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		
		if(leftIndex >=  rightIndex) {
			return;
		}
		
		if ((rightIndex - leftIndex) <= SIZE_LIMIT) {
			this.INSERTIONSORT_APPLICATIONS++;
			
			for(int k = leftIndex ; k < rightIndex + 1; k++) {
				if(array[k].compareTo(array[leftIndex]) < 0) {
					T aux = array[k];
					array[k] = array[leftIndex];
					array[leftIndex] = aux;
				}
			}
			sort(array, leftIndex + 1, rightIndex);
		}else {
			this.MERGESORT_APPLICATIONS++;
			
			int meio = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			
			merge(array, leftIndex, meio, rightIndex);
		}
		
	}
	
	public void selection(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex) return;
		
		int indice = leftIndex;
		
		for(int i = leftIndex + 1; i < rightIndex; i++) {
			if(array[indice].compareTo(array[i]) < 0) {
				indice = i;
			}
		}
		
		T aux = array[leftIndex];
		array[leftIndex] = array[indice];
		array[indice] = aux;
		
		selection(array, leftIndex + 1, rightIndex);
		
	}
	
	public void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {

		
		int i = leftIndex;
		int j = middleIndex + 1;
		int k = leftIndex;
		
		Object[] aux = new Object[array.length];
		int l = 0;
		
		for(T elemento : array) {
			aux[l] = elemento;
			l++;
			}
		
		while(i <= middleIndex && j <= rightIndex) {
			
			if(((T) aux[i]).compareTo((T) aux[j]) < 0) {
				array[k] = (T) aux[i];
				i++;
			}else  {
				array[k] = (T) aux[j];
				j++;
			}
			
			k++;
			
		}
		
		while(i <= middleIndex) {
			array[k] = (T) aux[i];
			i++;
			k++;
		}
		
		while(j <= rightIndex) {
			array[k] = (T) aux[j];
			j++;
			k++;
		}
		
	}
	
	public int getVezesMergeSortUsado() {
		return this.MERGESORT_APPLICATIONS;
	}
	
	public int getVezesInsersionSortUsado() {
		return this.INSERTIONSORT_APPLICATIONS;
	}
}
