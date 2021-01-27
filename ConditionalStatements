public class ConditionalStatemants {

	public int sumOrMultiply(int a, int b) {
		return (a&1) != 1 ? a*b : a+b;
	}
	
	public String pointPosition(int x, int y) {
		if(x>0) {
			if(y>0) return "1-я четверть";
			else if(y<0) return "4-я четверть";
			else return"Точка на положительной части оси х";
		} else if(x<0) {
			if(y>0) return "2-я четверть";
			else if(y<0) return "3-я четверть";
			else return "Точка на отрицательной части оси х";
		}
		if(y>0) return "Точка на положительной части оси y";
		if(y<0) return "Точка на отрицательной части оси y";
		return "Начало координат";
	}
	
	public int positiveNumbersSum(int a, int b, int c) {
		if(a<0) a=0;
		if(b<0) b=0;
		if(c<0) c=0;
		return a+b+c;
	}
	
	public int maxSumOrProduct(int a, int b, int c) {
		int sum = a+b+c, multiply = a*b*c;
		if(sum>multiply) return sum+3;
		else return multiply+3;
	}
	
	public char getGrade(int grade) {
		if(grade>=0 && grade<=19) return 'F';
		else if(grade>=20 && grade<=39) return 'E';
		else if(grade>=40 && grade<=59) return 'D';
		else if(grade>=60 && grade<=74) return 'C';
		else if(grade>=75 && grade<=89) return 'B';
		return 'A';
	}
	
}
