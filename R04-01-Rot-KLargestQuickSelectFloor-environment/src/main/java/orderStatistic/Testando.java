package orderStatistic;

public class Testando {

	public static void main(String[] args) {
		QuickSelect qs = new QuickSelect();
		
		Integer[] array = {4, 1, 5, 6, 10};
		
		Integer resultado = (Integer) qs.quickSelect(array, 4);
		System.out.println(resultado);
	}
	
	private static void klargest() {
		KLargestOrderStatisticsImpl klosi = new KLargestOrderStatisticsImpl();
		
		Integer[] array = {4, 12, 5, 61, 6};
		
		//Integer ola = (Integer) klosi.orderStatistics(array, 3);
		
		Comparable[] ola =  klosi.getKLargest(array, 3);
		
		for(Comparable numero : ola) {
			System.out.println(numero);
		}
		
	}
	
}
