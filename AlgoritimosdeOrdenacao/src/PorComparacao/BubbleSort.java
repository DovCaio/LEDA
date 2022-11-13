package PorComparacao;

/**
 * A ideia principal do bubble sort é levar sempre o maior elemento ate o final, e para isso
 * cada elemento vai ser comparado com seu sucessor, caso o sucessor seja menor é feito o swap
 * desses dois elementos.
 * 
 * Pior Caso: n²
 * Caso medio: n²
 * Melhor caso: n
 * 
 * É estável, portanto a ordem em que os elemento repetidos aparecem é mantida apos a ordenação.
 * É in-place, pois não ultiliza nenhuma estrutura de dados auxiliar.
 * 
 * @author Caio Jhonatan Alves Pereira
 *
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> {

	public void sortInteractive(T[] array) {
		boolean swaped = true;
		
		while(swaped) {
			swaped = false;
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i].compareTo(array[i + 1]) > 0) {
					swap(array, i , i + 1);
					swaped = true;
				}
			}
		}
	}
	
	
	public void sortRecursive(T[] array, int leftIndex, int rigthIndex) {
		
		if(leftIndex >= rigthIndex) return;
		
		for(int i = leftIndex; i < rigthIndex; i ++) {
			if(array[i].compareTo(array[i+1]) > 0) {
				swap(array, i, i+1);
			}
		}
		sortRecursive(array, leftIndex, rigthIndex - 1);
	}
	
	
	private void swap(T[] array, int i1, int i2) {
		T aux = array[i1];
		array[i1] = array[i2];
		array[i2] = aux;
	}
}
