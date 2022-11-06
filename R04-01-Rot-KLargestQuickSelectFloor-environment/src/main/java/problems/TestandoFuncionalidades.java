package problems;

public class TestandoFuncionalidades {

	public static void main(String[] args) {
		
		Integer[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 19};
		
		FloorBinarySearchImpl floor = new FloorBinarySearchImpl();
		Integer resultado = floor.floor(array, 4); 
		System.out.println(resultado);
	}
	
}
