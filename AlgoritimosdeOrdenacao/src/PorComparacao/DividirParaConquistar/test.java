package PorComparacao.DividirParaConquistar;

public class test {

	public static void main(String[] args) {
		
		QuickSort ms = new QuickSort();
		
		Integer[] array = {3, 41, 5, 1, 5 ,6};
		
		ms.sort(array, 0, 5);
		
		for(Integer numero : array) System.out.println(numero);	
		
	}
	
}
