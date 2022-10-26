package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex >= rightIndex) return;
		
		int meio = rightIndex - 1;
		
		if(array[leftIndex].compareTo(array[meio]) >= 0) {
			util.Util.swap(array, leftIndex, meio);
		}
		
		if(array[meio].compareTo(array[rightIndex]) >= 0) {
			util.Util.swap(array, meio, rightIndex);
		}
		
		int metade = partition(array, leftIndex, rightIndex - 1);
		
		sort(array, leftIndex, metade - 1);
		sort(array, metade + 1, rightIndex);
		
	}
	
	public int partition(T[] array, int leftIndex, int rightIndex) {

		
		T pivo = array[leftIndex];
		
		int i  = leftIndex;
		
		for(int j = leftIndex + 1 ; j <= rightIndex; j++) {
			if(array[j].compareTo(pivo) <= 0) {
				i++;
				T aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
		}
		
		T aux = array[leftIndex];
		array[leftIndex] = array[i];
		array[i] = aux;
		
		return i;
	}
	
}
