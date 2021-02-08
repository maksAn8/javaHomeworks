
public class Functions {
	
	public static String[] numbers0_19  = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
			"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", 
			"семнадцать", "восемнадцать", "девятнадцать"};
	public static String[] numbers20_90 = {"двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", 
			"восемьдесят", "девяносто"};
	public static String[] numbersHundreds = {"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
			"восемьсот", "девятьсот"};
	public static String[] numbersThousands = {"одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", " тысяч"};
	
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
		int[] arr = new int[9];
		int d = 0; 
		int number = n;
		if(n == 0) {
			System.out.println(numbers0_19[0]);
			return;
		}
		while(n!=0) {
			int a = (n % 10);
			arr[d] = a;
			n = n / 10;
			d++;
		}

		while(number != 0) {
			switch(d) {
			case 4:
				d--;
				if(arr[3] == 0) break;
				if(arr[3] > 4) System.out.print(numbers0_19[arr[3]] + numbersThousands[4] + " ");
				else System.out.print(numbersThousands[arr[3] - 1] + " ");
				number = number - arr[3] * 1000;
			case 3:
				d--;
				if(arr[2] == 0) break;
				System.out.print(numbersHundreds[arr[2] - 1] + " ");
				number = number - arr[2] * 100;
			case 2:
				d--;
				if(arr[1] == 0) break;
				if(number != 0 && number < 20) {
					System.out.println(numbers0_19[number] + " ");
					number = 0;
					break;
				}
				else {
					System.out.print(numbers20_90[arr[1] - 2] + " ");
					number = number - arr[1] * 10;
					if(arr[0] == 0) break;
				}
			case 1:
				System.out.println(numbers0_19[arr[0]] + " ");
				number = 0;
			}

		}
	}
	
	public static void convertStringToNumber(String number) {	
		if(number == null) {
			throw new IllegalArgumentException("Number can not be null!");
		}
		String lowerCase = number.toLowerCase();
		number = "";
		String[] splitNumber = lowerCase.split(" ");
		switch(splitNumber.length) {
		case 3:
			for(int i = 0; i < numbersHundreds.length; i++) {
				if(splitNumber[0].equals(numbersHundreds[i])) {
					number += numbersHundreds[i];
				}
			}
			break;
		case 2:
			
			break;
		case 1:
			
			break;
		}
	}

}
