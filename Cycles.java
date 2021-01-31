
public class Cycles {
	
	public static void getEvenNumbersSumAndQuantity() {
		int numCounter = 0, numSum = 0, upperLimit = 98, lowerLimit = 2;
		for(int i=lowerLimit; i<=upperLimit; i+=2) {
			numCounter++;
			numSum+=i;
		}
		System.out.println("Even numbers quantity = "+numCounter+", their sum = "+numSum);	
	}
	
	public static boolean isPrimeNumber(int number) {
		if(number<=1) return false;
		for(int i=2; i<number; i++) {
			if(number%i==0) return false;
		}
		return true;	
	}
	
	public static void getSqrtWithPrecisionToInteger(int number) {
		
		if(number<0)
			throw new IllegalArgumentException("Number must be in the range of 0-2147483647");
		
		if(number<2) {
			System.out.println("SQRT = "+number);
			return;
		}
		
		if(number>=2147395600) {
			System.out.println("SQRT = 46340");
			return;
		}
			
		//selection method
		for(int i=1; i<=number/2; i++) {
			if(i*i<=number && (i+1)*(i+1)>number) {
				System.out.println("SQRT = "+i);
				break;
			}
		}
		
		//binary search
		System.out.println("Binary search:");
		int sqrt, leftBoundary=1, rightBoundary=number/2;
		
		if(rightBoundary>46340) rightBoundary=46340;
		
		while(leftBoundary<=rightBoundary) {
			sqrt = (leftBoundary+rightBoundary)/2;
			if(sqrt*sqrt==number) {
				System.out.println("SQRT = "+sqrt);
				return;
			} else if(sqrt*sqrt>number){
				rightBoundary=sqrt;
			} else if(sqrt*sqrt<number) {
				if(++sqrt*sqrt>number) {
					System.out.println("SQRT = "+--sqrt);
					return;
				} else {
					leftBoundary=sqrt;
				}
			}
		}
	}
	
	public static int getFactorial(int number) {
		if(number<0)
			throw new IllegalArgumentException("Factorial can be found only for positive integers and zero!");
		if(number==0) return 1;
		int factorial = number;
		while(number>2) factorial *= --number;			
		return factorial;
	}
	
	public static int getDigitsSum(int number) {
		int sum = 0;
		while(number!=0) {
			sum += (number%10);
			number/=10;
		}
		return sum;
	}
	
	public static String getMirroredNumber(int number) {
		String mirroredNumber="";
		if(number<0) {
			mirroredNumber = "-";
			number*=-1;
		}
		while(number!=0) {
			mirroredNumber += number%10;
			number/=10;
		}
		return mirroredNumber;
	}
	
}
