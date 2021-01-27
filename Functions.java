import java.util.Random;

public class Functions {
	
	
	public static void main(String args[]) {
		Homework_1_4 h = new Homework_1_4();
		Random random = new Random();
		int a = random.nextInt(10000);
		System.out.println("Число "+a);
		h.ntos(a);
	}
	
	public void ntos(int n) {
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
