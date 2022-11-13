package PorComparacao;


/**
 * A ideia principal do SelectionSort e levar sempre o menor elmento para
 * o início do array, e para isso tem sempre uma variável que assume o
 * primeiro indice como sendo o menor, e dai em diante vai verificando se
 * existe um elemento menor do que seu o indice que a posição que está
 * o indice do menor, e toda vez que o laço se encerra incrementa uma
 *  unidade o menor elemento.
 *  
 *  Complexidade O(n²)
 *  
 *  
 *  Não é estável, portanto a ordem que os elemento repetidos aparecem
 *  não é mantida.
 *  
 *  É in-place, pois não ultiliza estrutura auxiliar.
 * @author onlyd
 *
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> {

	public void sortInteractive(T[] array) {
		int i = 0;
		while(i < array.length) {
			int menor = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[i].compareTo(array[j]) > 0) {
					menor  = j;
				}
			}
			swap(array, menor, i);
			i++;
		}
	}
	
	public void sortRecursive(T[] array, int leftIndex, int rigthIndex) {
		if(leftIndex >= rigthIndex) return;
		
		int menor  = leftIndex;
		for (int i = leftIndex + 1; i < rigthIndex + 1; i++) {
			if(array[menor].compareTo(array[i]) > 0) {
				menor = i;
			}
		}
		swap(array, leftIndex, menor);
		sortRecursive(array, leftIndex + 1, rigthIndex);
	}
	
	
	private void swap(T[] array, int i1, int i2) {
		T aux = array[i1];
		array[i1] = array[i2];
		array[i2] = aux;
	}
}
