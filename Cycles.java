import java.util.Random;

public class Cycles {

	
	public static void main(String args[]) {
		Random random = new Random();
		int a = random.nextInt(100)+1;
		Homework_1_2 h = new Homework_1_2();
		System.out.println("Исходные данные "+a);
		h.task_1();
		h.task_2(a);
		h.task_3(a);
		h.task_5(a);
		h.task_6(a);
		a = random.nextInt(6);
		h.task_4(a);
	}
	
	public void task_1() {
		int numCounter=0, numSum=0;
		for(int i=1; i<100; i++) {
			if((i&1)!=1) {
				numCounter++;
				numSum=numSum+i;
			}
		}
		System.out.println("Кол-во чётных чисел = "+numCounter+", их сумма = "+numSum);	
	}
	
	public void task_2(int a) {
		for(int i=2; i<=a; i++) {
			if(a%i==0 && i!=a) {
				System.out.println("Число составное");
				return;
			}
		}
		System.out.println("Число простое");	
	}
	
	public void task_3(int a) {
		for(int i=1; i<=a/2; i++) {
			if(i*i==a) {
				System.out.println("Корень = "+i);
				break;
			}
			else if(i*i<a && (i+1)*(i+1)>a) {
				System.out.println("Корень = "+i);
				break;
			}
		}
		
		//бинарный поиск
		
		System.out.println("Бинарный поиск:");
		int firstElement=1;
		int lastElement=a/2;
		if(lastElement==0) System.out.println("Корень = "+a);
		if(lastElement*lastElement==a) System.out.println("Корень = "+lastElement);
		while(firstElement<=lastElement) {
			int middleElement=(firstElement+lastElement)/2;
			if(middleElement*middleElement==a || 
					middleElement*middleElement<a && (middleElement+1)*(middleElement+1)>a) {
				System.out.println("Корень = "+middleElement);
				break;
			}
			if(middleElement*middleElement>a) lastElement=middleElement;
			if(middleElement*middleElement<a) firstElement=middleElement;
		}
	}
	
	public int task_4(int n) {
		int f = n;
		int i = 1;
		do {
			f=f*(n-i);	
			i++;
		} while(i!=n);
		System.out.println(n+"! = "+ f);
		return f;
	}
	
	public int task_5(int a) {
		int sum=0;
		int d = a;
		while(a!=0) {
			sum=sum+(a%10);
			a=a/10;
		}
		System.out.println("Сумма цифр числа "+ d +" = "+ sum);
		return sum;
	}
	
	public void task_6(int a) {
		System.out.print("Зеркальное отображение числа:");
		while(a!=0) {
			int d=(a%10);
			System.out.print(d);
			a=a/10;
		}
		System.out.println("");
	}
	
}
