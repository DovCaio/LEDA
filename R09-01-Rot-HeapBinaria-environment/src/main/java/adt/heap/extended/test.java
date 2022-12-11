package adt.heap.extended;

public class test {

	static public void main(String[] args) {
		
		Integer[] valores = {4, 1, 5, 7, 2 , 10, 9, 20};
		
		FloorCeilHeapImpl fchi = new FloorCeilHeapImpl(null);
		
		System.out.println(fchi.floor(valores, 17));
	}
	
}
