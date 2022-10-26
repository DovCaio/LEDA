package sorting.variationsOfSelectionsort;

public class TestandoFuncionalidades {

	
	public static void main(String[] args) {
		
		RecursiveSelectionSort Rs = new RecursiveSelectionSort();
		
		Integer[] array = gerarArray();
		
		Rs.sort(array, 0, 9);
		
		for(Integer numero : array) System.out.println(numero);
	}
	
	public static Integer[] gerarArray() {
		Integer[] array = new Integer[10];
		
		array[0] = 100;
		array[1] = 12;
		array[2] = 4;
		array[3] = 500;
		array[4] = 300;
		array[5] = 100;
		array[6] = 9000;
		array[7] = 31;
		array[8] = -98;
		array[9] = 15;
		
		return array;
	}
	
}
