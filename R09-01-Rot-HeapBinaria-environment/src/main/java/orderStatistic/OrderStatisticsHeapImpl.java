package orderStatistic;

import java.util.PriorityQueue;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem. 
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 *   uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve retornar null 
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	
	@Override
	public T getOrderStatistics(T[] array, int k) {
		PriorityQueue<T> heap = new PriorityQueue<T>();
		//[4, 1, 5, 2, 10, 3, 90, 400]
		//[1, 2, 3, 4, 5, 10, 90, 400]
		for(int i = 0; i < array.length; i++) {
			
			heap.add(array[i]);
			
		}
		T resultado = null;
		
		for(int j = 0 ; j <  k; j++) {
			
			resultado = heap.remove();
			
		}
		
		return resultado;
	}

	
	
}
