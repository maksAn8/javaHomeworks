
public class Functions {
	
	public static String getDayNameByNumber(int dayNumber) {
		if(dayNumber < 1 || dayNumber > 7) {
			throw new IllegalArgumentException("Day number must be in the range of 1-7!");
		}
		switch(dayNumber) {
		case 2:
			return "Monday";
		case 3:
			return "Tuesday";
		case 4:
			return "Wednesday";
		case 5:
			return "Thursday";
		case 6:
			return "Friday";
		case 7:
			return "Saturday";
		default:
			return "Sunday";
		}
	}
	
	public static double getDistanceBetweenTwoPoints(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
	
	public static void convertNumberToString(int n) {
		String[] sn1  = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
				"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", 
				"семнадцать", "восемнадцать", "девятнадцать"};
		String[] sn2 = {"двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", 
				"восемьдесят", "девяносто"};
		String[] sn3 = {"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
				"восемьсот", "девятьсот"};
		String[] sn4 = {"одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", " тысяч"};
		int[] arr = new int[9];
		int d = 0; 
		int number = n;
		if(n==0) {
			System.out.println(sn1[0]);
			return;
		}
		while(n!=0) {
			int a=(n%10);
			arr[d]=a;
			n=n/10;
			d++;
		}

		while(number!=0) {
			
			switch(d) {
			case 4:
				d--;
				if(arr[3]==0) break;
				if(arr[3]>4) System.out.print(sn1[arr[3]] + sn4[4] +" ");
				else System.out.print(sn4[arr[3]-1] +" ");
				number=number-arr[3]*1000;
			case 3:
				d--;
				if(arr[2]==0) break;
				System.out.print(sn3[arr[2]-1] +" ");
				number=number-arr[2]*100;
			case 2:
				d--;
				if(arr[1]==0) break;
				if(number!=0 && number<20) {
					System.out.println(sn1[number] +" ");
					number=0;
					break;
				}
				else {
					System.out.print(sn2[arr[1]-2] +" ");
					number=number-arr[1]*10;
					if(arr[0]==0) break;
				}
			case 1:
				System.out.println(sn1[arr[0]] +" ");
				number=0;
			}

		}
	}

}
