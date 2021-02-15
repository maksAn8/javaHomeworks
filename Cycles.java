
public class Cycles {
	
	
	public static String getEvenNumbersSumAndQuantity() {
		int numCounter = 0, numSum = 0, upperLimit = 98, lowerLimit = 2;
		for(int i = lowerLimit; i <= upperLimit; i += 2) {
			numCounter++;
			numSum += i;
		}
		return "Even numbers quantity = " + numCounter + ", their sum = " + numSum;	
	}
	
	public static boolean isPrimeNumber(int number) {
		if(number <= 1) {
			return false;
		}
		for(int i = 2; i < number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;	
	}
	
	public static String getSqrtWithPrecisionToInteger(int number) {
		
		if(number < 0) {
			throw new IllegalArgumentException("Number must be in the range of 0-2147483647");
		}
			
		if(number < 2) {
			return "SQRT = " + number;
		}
		
		if(number >= 2147395600) {
			return "SQRT = 46340";
		}
		
		String result = "";
			
		//selection method
		for(int i = 1; i <= number / 2; i++) {
			if(i * i <= number && (i + 1) * (i + 1) > number) {
				result = "Selection method: SQRT = " + i;
				break;
			}
		}
		
		//binary search
		int sqrt, leftBoundary = 1, rightBoundary = number / 2;
		
		if(rightBoundary > 46340) {
			rightBoundary = 46340;
		}
		
		while(leftBoundary <= rightBoundary) {
			sqrt = (leftBoundary + rightBoundary) / 2;
			if(sqrt * sqrt == number) {
				result += ". Binary search: SQRT = " + sqrt;
				break;
			} else if(sqrt * sqrt > number) {
				rightBoundary = sqrt;
			} else {
				if(++sqrt * sqrt > number) {
					result += ". Binary search: SQRT = " + --sqrt;
					break;
				} else {
					leftBoundary = sqrt;
				}
			}
		}
		return result;
	}
	
	public static long getFactorial(int number) {
		if(number < 0 || number > 20) {
			throw new IllegalArgumentException("Number must be in the range of 0-20!");
		}
		if(number == 0) {
			return 1;
		}
		long factorial = number;
		while(number > 2) {
			factorial *= --number;			
		}
		return factorial;
	}
	
	public static int getDigitsSum(int number) {
		int sum = 0;
		while(number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
	
	public static String getMirroredNumber(int number) {
		String mirroredNumber = "";
		if(number < 0) {
			mirroredNumber = "-";
			number *= -1;
		}
		while(number != 0) {
			mirroredNumber += number % 10;
			number /= 10;
		}
		return mirroredNumber;
	}
	
}
