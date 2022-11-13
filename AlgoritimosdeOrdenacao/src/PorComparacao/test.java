package PorComparacao;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		
		InsertionSort bs = new InsertionSort();
		
		Integer[] array = {4, 1, 5, 2, 5, 1};
		Integer[] arraysorted = {4, 1, 5, 2, 5, 1};
		Arrays.sort(arraysorted);
		
		bs.sortRecursive(array, 0 , 5);
		
		for(Integer numero : array) {
			System.out.println(numero);
		}
		
	}
	
}
