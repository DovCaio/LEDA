package orderStatistic;

import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		
		OrderStatisticsHeapImpl order =  new OrderStatisticsHeapImpl<>() ;
		
		
		Integer[] numeros = {5, 3 , 10, 1, 2};
		
		System.out.println(order.getOrderStatistics(numeros, 4));
		
	}
	
}
