public class ConditionalStatements {

	public int getSumOrProduct(int a, int b) {
		return (a&1) != 1 ? a*b : a+b;
	}
	
	public String getQuadrantByCoordinates(int x, int y) {
		if(x>0) {
			if(y>0) return "The first quadrant.";
			else if(y<0) return "The fourth quadrant.";
			else return"The point is on the X axis between I and IV quadrants.";
		} else if(x<0) {
			if(y>0) return "The second quadrant.";
			else if(y<0) return "The third quadrant.";
			else return "The point is on the X axis between II and III quadrants.";
		}
		if(y>0) return "The point is on the Y axis between I and II quadrants.";
		if(y<0) return "The point is on the Y axis between III and IV quadrants.";
		return "The origin.";
	}
	
	public int getPositiveNumbersSum(int a, int b, int c) {
		int result = 0;
		if(a>0) result += a;
		if(b>0) result += b;
		if(c>0) result += c;
		return result;
	}
	
	public int getMaxBetweenSumAndProduct(int a, int b, int c) {
		int sum = a+b+c, multiply = a*b*c;
		if(sum > multiply) return sum + 3;
		else return multiply + 3;
	}
	
	public char getGradeByRating(int rating) {
		if(rating < 0 || rating > 100) {
			throw new IllegalArgumentException("The rating must be in the range of 0-100!");
		}
		if(rating >=0 && rating <= 19) return 'F';
		else if(rating <= 39) return 'E';
		else if(rating <= 59) return 'D';
		else if(rating <= 74) return 'C';
		else if(rating <= 89) return 'B';
		return 'A';
	}
	
}
