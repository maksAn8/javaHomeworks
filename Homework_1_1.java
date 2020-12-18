import java.util.Random;

public class Homework_1_1 {

	
	public static void main(String args[]) {
		Homework_1_1 h = new Homework_1_1();
		Random random = new Random();
		int a = random.nextInt(50)-25;
		int b = random.nextInt(50)-25;
		int c = random.nextInt(101);
		System.out.println("Исходные данные: "+a+" "+b+" "+c);
		h.task_1(a, b);
		h.task_2(a, b);
		h.task_3(a, b, c);
		h.task_4(a, b, c);
		h.task_5(c);
	}
	
	public int task_1(int a, int b) {
		int result;
		if((a&1)!=1) {
			result=a*b;
			System.out.println("a*b = "+result);
			return result;	
		}
		else {
			result=a+b;
			System.out.println("a+b = "+result);
			return result;	
		}
	}
	
	public void task_2(int x, int y) {
		if(x>0) {
			if(y>0) System.out.println("1-я четверть");
			else if(y<0) System.out.println("4-я четверть");
			else System.out.println("Точка на положительной части оси х");
		} else if(x<0) {
			if(y>0) System.out.println("2-я четверть");
			else if(y<0) System.out.println("3-я четверть");
			else System.out.println("Точка на отрицательной части оси х");
		} else {
			if(y==0) System.out.println("Начало координат");
			if(y>0) System.out.println("Точка на положительной части оси y");
			if(y<0) System.out.println("Точка на отрицательной части оси y");
		}
	}
	
	public int task_3(int a, int b, int c) {
		if(a<0) a=0;
		if(b<0) b=0;
		if(c<0) c=0;
		int result = a+b+c;
		System.out.println("Сумма положительных чисел = "+result);
		return result;
	}
	
	public int task_4(int a, int b, int c) {
		int result;
		if(a+b+c>a*b*c) {
			result = a+b+c+3;
			System.out.println("a+b+c+3 = "+result);
			return result;
		}
		else {
			result = a*b*c+3;
			System.out.println("a*b*c+3 = "+result);
			return a*b*c+3;
		}
	}
	
	public void task_5(int grade) {
		if(grade>=0 && grade<=19) System.out.println("Оценка F");
		else if(grade>=20 && grade<=39) System.out.println("Оценка E");
		else if(grade>=40 && grade<=59) System.out.println("Оценка D");
		else if(grade>=60 && grade<=74) System.out.println("Оценка C");
		else if(grade>=75 && grade<=89) System.out.println("Оценка B");
		else System.out.println("Оценка A");
	}

}
