
public class Arrays {
	
	public static int getMinElementOfArray(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		return array[getMinElementIndexOfArray(array)];
	}
	
	public static int getMaxElementOfArray(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		return array[getMaxElementIndexOfArray(array)];
	}
	
	public static int getMinElementIndexOfArray(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		int minElement, indexMin;
		minElement = array[0];
		indexMin = 0;
		for(int i = 1; i < array.length; i++) {
			if(minElement > array[i]) {
				minElement = array[i];
				indexMin = i;
			}
		}
		return indexMin;		
	}
	
	public static int getMaxElementIndexOfArray(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		int maxElement, indexMax;
		maxElement = array[0];
		indexMax = 0;
		for(int i = 1; i < array.length; i++) {
			if(maxElement < array[i]) {
				maxElement = array[i];
				indexMax = i;
			}
		}
		return indexMax;
	}
	
	public static int getSumOfElemetsWithOddIndex(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		int sum = 0;
		for(int i = 1; i <= array.length - 1; i += 2) {
			sum += array[i];
		}
		return sum;
	}
	
	public static int[] getReversedArray(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		for(int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return array;
	}
	
	public static int getAmountOfOddElements(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		int oddElementsCounter = 0;
		for(int arrayElement : array) {
			if((arrayElement & 1) == 1) {
				oddElementsCounter++;
			}
		}
		return oddElementsCounter;
	}
	
	public static int[] toSwapTwoPartsOfArray(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		int arrayMiddle = 0;
		if((array.length & 1) == 0) {
			arrayMiddle = array.length / 2;
		}
		else {
			arrayMiddle = array.length / 2 + 1;
		}
		for(int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[arrayMiddle + i];
			array[arrayMiddle + i] = temp;
		}
		return array;
	}
	
	public static int[] bubbleSort(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		boolean isSorted = false;
		while(!isSorted) {
			isSorted = true;
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i] > array[i + 1]) {
					isSorted = false;
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
		return array;
	}
	
	public static int[] selectionSort(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		for (int left = 0; left < array.length; left++) {
			int minIndex = left;
			for (int i = left; i < array.length; i++) {
				if (array[minIndex] > array[i]) {
					minIndex = i;
				}
			}
			int temp = array[left];
			array[left] = array[minIndex];
			array[minIndex] = temp;
		}
		return array;
	}
	
	public static int[] insertionSort(int[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Array can't be null!");
		}
		for (int left = 1; left < array.length; left++) {
			int minElement = array[left];
			int i = left - 1;
			while (i >= 0 && array[i] > minElement) {
				array[i + 1] = array[i];
				i--;
			} 
			array[i + 1] = minElement;
		}
		return array;
	}
		
}
