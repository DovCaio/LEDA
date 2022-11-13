package PorComparacao.DividirParaConquistar;

import java.util.Arrays;

/**
 * A ideia principal do QuickSort é baseada no partition, esse partition ordena o array comparando 
 * ele com um devido valor, esse valor vai ter os outros menores que ele a sua esquerda e os maiores
 * a sua direita, e para isso ele vai ver quais são so menores que ele e vai joga-los a sua esquerda
 * enquanto e depois que não houver nenhum outro valor menor que ele ele retorna a variáve que representa
 * o indice em que o pivot deve ficar, e no final do laço também é feita essa troca do left Index com 
 * o i que foi incrementado toda vez que achou um valor menor que o pivot, assim retornando o indice do pivot.
 * @author onlyd
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> {

	public void sort(T[] array, int  leftIndex, int rigthIndex) {
		
		if(leftIndex < rigthIndex) {
			int index_pivot = partitionCovencional(array, leftIndex, rigthIndex);
			sort(array, leftIndex, index_pivot - 1);
			sort(array, index_pivot + 1, rigthIndex);
		}
		
	}
	
	/**
	 * Partition com pivot começando com o elemento à esquerda.
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rigthIndex
	 * @return
	 */
	public int partitionCovencional(T[] array, int leftIndex, int rigthIndex) {
		
		T pivot = array[leftIndex];
		int i = leftIndex;
		
		for(int j = leftIndex + 1; j <= rigthIndex; j++) {
			if(array[j].compareTo(pivot) <= 0) {
				i++;
				swap(array, i, j);
			}
		}
		
		swap(array, leftIndex, i);
		return i;
		
	}
	
	/**
	 * Escolhe aleatoriamente um pivot, ao invés de sempre pegar o primeiro.
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return
	 */
	public int partitionRandom(T[] array, int leftIndex, int rightIndex) {
		
		int range = rightIndex - leftIndex + 1;
		int rand_pivot_index = (int) (Math.random() * range) + leftIndex;
		
		swap(array, leftIndex, rand_pivot_index);
		
		T pivot = array[leftIndex];
		int i = leftIndex;
		
		for(int j = leftIndex + 1; j <= rightIndex ; j++) {
			if(array[j].compareTo(pivot) <= 0) {
				i++;
				swap(array, i, j);
			}
		}
		
		swap(array, i, leftIndex);
		
		return i;
	}
	
	/**
	 * Pega o pivot como a mediana entre o primeiro elemento, o elemento central e o ultimo elemento.
	 * bom para diminuir a probabilidade do pior caso.
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return
	 */
	public int pickPivotIndex(T[] array, int leftIndex, int rightIndex) {
		int mid = (leftIndex + rightIndex) / 2;
		
		Comparable[] sort = new Comparable[3];
		
		sort[0] = array[leftIndex];
		sort[1] = array[mid];
		sort[2] = array[rightIndex];
		
		Arrays.sort(sort);
		
		if(sort[1].compareTo(array[leftIndex]) == 0) return leftIndex;
		else if(sort[1].compareTo(array[mid]) == 0) return mid;
		else return rightIndex;
	}
	
	/**
	 * Partition que usa a media entre os elmenetos para ser o pivot;
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rigthIndex
	 * @return
	 */
	public int partitionPivotMedian(T[] array, int leftIndex, int rigthIndex) {
		T pivot = array[pickPivotIndex(array, leftIndex, leftIndex)];
		int i = leftIndex;
		
		for(int j = leftIndex + 1; j <= rigthIndex; j++) {
			if(array[j].compareTo(pivot) <= 0) {
				i++;
				swap(array, i, j);
			}
		}
		
		swap(array, leftIndex, i);
		return i;
	}
	
	
	public void swap(T[] array, int i1, int i2) {
		T aux = array[i1];
		array[i1] = array[i2];
		array[i2] = aux;
	}
	
}
