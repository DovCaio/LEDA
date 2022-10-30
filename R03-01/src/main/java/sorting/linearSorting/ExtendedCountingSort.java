package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
if (array.length == 0) return;
		
		int max = array[leftIndex];
		int min = array[leftIndex];
		
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			if(max < array[i]) max = array[i];
			if(min > array[i]) min = array[i];
		}
		
		int k = max -  min + 1;
		
		int[] arrayAux = new int[k];
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			arrayAux[array[i] - min] += 1;
		}
		
		for (int i = 1; i < arrayAux.length; i++) {
			arrayAux[i] += arrayAux[i - 1];
		}

		int[] aux2 = new int[array.length];
		
		for (int i = rightIndex; i >= leftIndex; i--) {
			aux2[arrayAux[array[i] - min] - 1] = array[i];
			arrayAux[array[i] - min] -= 1;
		}
		
		//for(Integer numero : aux2) System.out.println(numero);
		
		int j = 0;
		for(int i = 0	; i <= array.length; i++) {
			if(i >= leftIndex && i <= rightIndex) {
				array[i] = aux2[j];
				j++;
			}
		}

	}
}
