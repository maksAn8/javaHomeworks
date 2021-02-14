import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CyclesTest {

	@Test
	public void test_getEvenNumbersSumAndQuantity() {
		String actual = Cycles.getEvenNumbersSumAndQuantity();
		String expected = "Even numbers quantity = 49, their sum = 2450";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_10_isPrimeNumber() {
		boolean actual = Cycles.isPrimeNumber(10);
		boolean expected = false;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_13_isPrimeNumber() {
		boolean actual = Cycles.isPrimeNumber(13);
		boolean expected = true;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_1_isPrimeNumber() {
		boolean actual = Cycles.isPrimeNumber(1);
		boolean expected = false;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_1_getSqrtWithPrecisionToInteger() {
		String actual = Cycles.getSqrtWithPrecisionToInteger(1);
		String expected = "SQRT = 1";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_2147395600_getSqrtWithPrecisionToInteger() {
		String actual = Cycles.getSqrtWithPrecisionToInteger(2147395600);
		String expected = "SQRT = 46340";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_getSqrtWithPrecisionToInteger() {
		Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Cycles.getSqrtWithPrecisionToInteger(-1),
                "Number must be in the range of 0-2147483647");
	}
	
	@Test
	public void test_4_getSqrtWithPrecisionToInteger() {
		String actual = Cycles.getSqrtWithPrecisionToInteger(4);
		String expected = "Selection method: SQRT = 2. Binary search: SQRT = 2";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_223_getSqrtWithPrecisionToInteger() {
		String actual = Cycles.getSqrtWithPrecisionToInteger(223);
		String expected = "Selection method: SQRT = 14. Binary search: SQRT = 14";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_0_getFactorial() {
		long actual = Cycles.getFactorial(0);
		long expected = 1;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_6_getFactorial() {
		long actual = Cycles.getFactorial(6);
		long expected = 720;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_20_getFactorial() {
		long actual = Cycles.getFactorial(20);
		long expected = 2432902008176640000L;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException1_getFactorial() {
		Assertions.assertThrows(IllegalArgumentException.class, 
				()-> Cycles.getFactorial(21),
				"Number must be in the range of 0-20!");		
	}
	
	@Test
	public void test_throwException2_getFactorial() {
		Assertions.assertThrows(IllegalArgumentException.class, 
				()-> Cycles.getFactorial(-1),
				"Number must be in the range of 0-20!");		
	}
	
	@Test
	public void test_123_getDigitsSum() {
		int actual = Cycles.getDigitsSum(123);
		int expected = 6;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_minus123_getDigitsSum() {
		int actual = Cycles.getDigitsSum(-123);
		int expected = -6;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_0_getDigitsSum() {
		int actual = Cycles.getDigitsSum(0);
		int expected = 0;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_12_getMirroredNumber() {
		String actual = Cycles.getMirroredNumber(12);
		String expected = "21";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_minus127_getMirroredNumber() {
		String actual = Cycles.getMirroredNumber(-127);
		String expected = "-721";
		Assertions.assertEquals(expected, actual);
	}
	
}
