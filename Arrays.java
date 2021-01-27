import java.util.Random;

public class Arrays {
	
	
	public static void main(String args[]) {
		Homework_1_3 h = new Homework_1_3();
		Random random = new Random();
		int length = random.nextInt(6)+5;
		h.task_1_4(length, 1, 100);
	}
	
	public void printArray(int arr[], int length) {
		for(int i=0; i<length; i++) System.out.print(arr[i]+" ");
		System.out.println("");
	}
	
	public void task_1_4(int length, int min, int max) {
		Random random = new Random();
		int arr[]= new int[length];
		int minElement, maxElement, indexMin, indexMax;
		for(int i=0; i<length; i++) arr[i]=random.nextInt(max-min+1)+min;
		printArray(arr, length);
		minElement=maxElement=arr[0];
		indexMin=indexMax=0;
		for(int i=1; i<length; i++) {
			if(minElement>arr[i]) {
				minElement=arr[i];
				indexMin=i;
			} else if(maxElement<arr[i]) {
				maxElement=arr[i];
				indexMax=i;
			}
		}
		System.out.println("Минимальный элемент массива = "+minElement+", его индекс = "+indexMin);
		System.out.println("Максимальный элемент массива = "+maxElement+", его индекс = "+indexMax);
		task_5(arr, length);
		task_6(arr, length);
		task_7(arr, length);
		task_8(arr, length);
		task_9(arr, length);
	}
	
	public void task_5(int arr[], int length) {
		int sum=0;
		for(int i=1; i<=length-1; i+=2) {
			sum=sum+arr[i];
		}
		System.out.println("Сумма элементов массива с нечётными индексами = "+sum);
	}
	
	public void task_6(int arr[], int length) {
		for(int i=0; i<length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[length-i-1];
			arr[length-i-1] = temp;
		}
		System.out.print("Реверс массива: ");
		printArray(arr, length);
	}
	
	public void task_7(int arr[], int length) {
		int amnt = 0;
		for(int i = 0; i<length; i++) {
			if((arr[i]&1)==1) amnt++;
		}
		System.out.println("Кол-во нечётных элементов массива = "+amnt);
	}
	
	public void task_8(int arr[], int length) {
		int c = 0;
		if(length%2==0) c = length/2;
		else c = length/2+1;
		for(int i=0; i<length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[c+i];
			arr[c+i] = temp;
		}
		System.out.print("Меняем местами 1-ю и 2-ю половины массива: ");
		printArray(arr, length);
	}
	
	public void task_9(int arr[], int length) {
		boolean isSorted = false;
		while(!isSorted) {
			isSorted=true;
			for(int i=0; i<length-1; i++) {
				if(arr[i]>arr[i+1]) {
					isSorted = false;
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		System.out.print("Bubble: ");
		printArray(arr, length);
		
		for (int left = 0; left < length; left++) {
			int minIndex = left;
			for (int i = left; i < length; i++) {
				if (arr[i] < arr[minIndex]) {
					minIndex = i;
				}
			}
			int temp = arr[left];
			arr[left] = arr[minIndex];
			arr[minIndex] = temp;
		}
		System.out.print("Select: ");
		printArray(arr, length);
		
		for (int left = 1; left < length; left++) {
			int value = arr[left];
			int i = left - 1;
			while (i >= 0 && value<arr[i]) {
				arr[i + 1] = arr[i];
			} 
			arr[i + 1] = value;
		}
		System.out.print("Insert: ");
		printArray(arr, length);

	}

}
