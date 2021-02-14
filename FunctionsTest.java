import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionsTest {

	@Test
	public void test_1_getDayNameByNumber() {
		String actual = Functions.getDayNameByNumber(1);
		String expected = "Sunday";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_2_getDayNameByNumber() {
		String actual = Functions.getDayNameByNumber(2);
		String expected = "Monday";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_3_getDayNameByNumber() {
		String actual = Functions.getDayNameByNumber(3);
		String expected = "Tuesday";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_4_getDayNameByNumber() {
		String actual = Functions.getDayNameByNumber(4);
		String expected = "Wednesday";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_5_getDayNameByNumber() {
		String actual = Functions.getDayNameByNumber(5);
		String expected = "Thursday";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_6_getDayNameByNumber() {
		String actual = Functions.getDayNameByNumber(6);
		String expected = "Friday";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_7_getDayNameByNumber() {
		String actual = Functions.getDayNameByNumber(7);
		String expected = "Saturday";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException1_getDayNameByNumber() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()->Functions.getDayNameByNumber(0),
				"Day number must be in the range of 1-7!");
	}
	
	@Test
	public void test_throwException2_getDayNameByNumber() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()->Functions.getDayNameByNumber(8),
				"Day number must be in the range of 1-7!");
	}
	
	@Test
	public void test_positiveCoords_getDistanceBetwenTwoPoints() {
		double actual = Functions.getDistanceBetweenTwoPoints(1, 1, 5, 1);
		double expected = 4.0;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_origin_getDistanceBetwenTwoPoints() {
		double actual = Functions.getDistanceBetweenTwoPoints(0, 0, 0, 0);
		double expected = 0.0;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_negativeCoords_getDistanceBetwenTwoPoints() {
		double actual = Functions.getDistanceBetweenTwoPoints(-1, -1, -5, -1);
		double expected = 4.0;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_0_convertNumberToString() {
		String actual = Functions.convertNumberToString(0);
		String expected = "ноль";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_9_convertNumberToString() {
		String actual = Functions.convertNumberToString(9);
		String expected = "девять";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_11_convertNumberToString() {
		String actual = Functions.convertNumberToString(11);
		String expected = "одиннадцать";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_19_convertNumberToString() {
		String actual = Functions.convertNumberToString(19);
		String expected = "девятнадцать";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_10_convertNumberToString() {
		String actual = Functions.convertNumberToString(10);
		String expected = "десять";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_90_convertNumberToString() {
		String actual = Functions.convertNumberToString(90);
		String expected = "девяносто";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_100_convertNumberToString() {
		String actual = Functions.convertNumberToString(100);
		String expected = "сто";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_900_convertNumberToString() {
		String actual = Functions.convertNumberToString(900);
		String expected = "девятьсот";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_405_convertNumberToString() {
		String actual = Functions.convertNumberToString(405);
		String expected = "четыреста пять";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_513_convertNumberToString() {
		String actual = Functions.convertNumberToString(513);
		String expected = "пятьсот тринадцать";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_620_convertNumberToString() {
		String actual = Functions.convertNumberToString(620);
		String expected = "шестьсот двадцать";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_877_convertNumberToString() {
		String actual = Functions.convertNumberToString(877);
		String expected = "восемьсот семьдесят семь";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException1_convertNumberToSring() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()->Functions.convertNumberToString(-1),
				"Number can be in the range of 0-999");
	}
	
	@Test
	public void test_throwException2_convertNumberToSring() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()->Functions.convertNumberToString(1000),
				"Number can be in the range of 0-999");
	}
	
	@Test
	public void test_0_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("   ноль");
		int expected = 0;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_9_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("девять    ");
		int expected = 9;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_11_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("одиннадцать");
		int expected = 11;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_19_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("девятнадцать");
		int expected = 19;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_10_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("  ДЕСЯТЬ  ");
		int expected = 10;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_90_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("девяносто");
		int expected = 90;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_100_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("сто");
		int expected = 100;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_900_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("девятьсот");
		int expected = 900;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_405_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("четыреста    пять");
		int expected = 405;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_513_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("  пятьсот  тринадцать   ");
		int expected = 513;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_620_convertStringToNumber() {
		int actual = Functions.convertStringToNumber("шестьсот двадцать");
		int expected = 620;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_877_convertStringToNumber() {
		int actual = Functions.convertStringToNumber(" восемьсот   семьдесят   семь ");
		int expected = 877;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException1_convertStringToNumber() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()->Functions.convertStringToNumber(null),
				"Number can not be empty!");
	}
	
	@Test
	public void test_throwException2_convertStringToNumber() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()->Functions.convertStringToNumber("    "),
				"Number can not be empty!");
	}
	
	@Test
	public void test_throwException3_convertStringToNumber() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()->Functions.convertStringToNumber("  dsg dfg  "),
				"Incorrect spell!");
	}
	
}
