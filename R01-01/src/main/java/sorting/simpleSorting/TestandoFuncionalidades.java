package sorting.simpleSorting;

public class TestandoFuncionalidades {

	public static void main(String[] args) {
		funcionamentoBubbleSort(retornaArray());
		//funcionamentoInsertionSort();
		//funcionamentoSelectionSort(retornaArray());
	}
	
	public static Integer[] retornaArray() {
		Integer[] array = new Integer[9];
		
		array[0] = 4;
		array[1] = 3;
		array[2] = 9;
		array[3] = 6;
		array[4] = 1;
		array[5] = 0;
		array[6] = 14;
		array[7] = 62;
		array[8] = -1;
		
		return array;
	}
	
	public static void funcionamentoSelectionSort(Integer[] array) {
		
		SelectionSort Ss = new SelectionSort();
		
		Ss.sort(array);
		
		for(Integer i : array) {
			System.out.println(i);
		}
		
	}
	
	public static void funcionamentoInsertionSort(Integer[] array) {
		
		InsertionSort Is = new InsertionSort();
		
		
		
		
		Is.sort(array, 0,8);
		
		
		for(Integer inteiro : array) {
			System.out.println(inteiro);
		}
		
	}
	
	
	public static void funcionamentoBubbleSort(Integer[] array) {
		BubbleSort Bs = new BubbleSort();
		
		
		
		Bs.sort(array, 0, 8);
		
		for(Integer inteiro : array) {
			System.out.println(inteiro);
		}
	}
	
}
