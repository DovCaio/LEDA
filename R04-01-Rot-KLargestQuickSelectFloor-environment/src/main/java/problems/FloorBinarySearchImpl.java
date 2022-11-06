package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		return array[binarySearch(array, 0, array.length - 1, x)];
	}
	
	private Integer binarySearch(Integer[] array, int leftIndex, int rigthIndex, Integer x ) {
		
		Integer resultado = null;
		
		
		int meio = (leftIndex + rigthIndex) / 2;
		
		if(array[rigthIndex] < x) {	
			resultado = rigthIndex;
		}else if(array[meio] == x) {
			resultado = meio;
		}else if(meio != 0 && array[meio] > x && array[meio - 1] < x) {
				resultado = meio - 1;
			
		}else if(meio == 0 && array[meio] > x) {
			resultado = -1;
		}else {
			if(array[meio] > x) {
				resultado = binarySearch(array, leftIndex, meio - 1, x);
			}else {
				resultado = binarySearch(array, meio + 1, rigthIndex, x);
			}
		}
		
		return resultado;
	}

}
