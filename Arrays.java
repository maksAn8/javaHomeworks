
public class Arrays {
	
	public static void getMinAndMaxElementsOfArray(int[] array) {
		int minElement, maxElement, indexMin, indexMax;
		minElement=maxElement=array[0];
		indexMin=indexMax=0;
		for(int i=1; i<array.length; i++) {
			if(minElement>array[i]) {
				minElement=array[i];
				indexMin=i;
			} else if(maxElement<array[i]) {
				maxElement=array[i];
				indexMax=i;
			}
		}
		System.out.println("Minimal element = "+minElement+", its index = "+indexMin);
		System.out.println("Maximal element = "+maxElement+", its index = "+indexMax);
		
	}
	
	public static int getSumOfElemetsWithOddIndex(int[] array) {
		int sum=0;
		for(int i=1; i<=array.length-1; i+=2) sum += array[i];
		return sum;
	}
	
	public static int[] getReversedArray(int[] array) {
		for(int i=0; i<array.length/2; i++) {
			int temp = array[i];
			array[i] = array[array.length-i-1];
			array[array.length-i-1] = temp;
		}
		return array;
	}
	
	public static int getAmountOfOddElements(int[] array) {
		int oddElementsCounter = 0;
		for(int i = 0; i<array.length; i++)
			if((array[i]&1)==1) oddElementsCounter++;
		return oddElementsCounter;
	}
	
	public static int[] toSwapTwoPartsOfArray(int[] array) {
		int arrayMiddle = 0;
		if((array.length&1)==0) arrayMiddle = array.length/2;
		else arrayMiddle = array.length/2+1;
		for(int i=0; i<array.length/2; i++) {
			int temp = array[i];
			array[i] = array[arrayMiddle+i];
			array[arrayMiddle+i] = temp;
		}
		return array;
	}
	
	public static int[] bubbleSort(int[] array) {
		boolean isSorted = false;
		while(!isSorted) {
			isSorted=true;
			for(int i=0; i<array.length-1; i++) {
				if(array[i]>array[i+1]) {
					isSorted = false;
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
		return array;
	}
	
	public static int[] selectionSort(int[] array) {
		for (int left = 0; left < array.length; left++) {
			int minIndex = left;
			for (int i = left; i < array.length; i++) {
				if (array[i] < array[minIndex]) {
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
		for (int left = 1; left < array.length; left++) {
			int value = array[left];
			int i = left - 1;
			while (i >= 0 && value<array[i]) {
				array[i + 1] = array[i];
				i--;
			} 
			array[i + 1] = value;
		}
		return array;
	}
		
}
