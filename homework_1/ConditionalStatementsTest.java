import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConditionalStatementsTest {

	@Test
	public void test_evenNumber_getSumOrProduct() {
		int actual = ConditionalStatements.getSumOrProduct(2, 6);
		int expected = 12;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
    public void test_oddNumber_getSumOrProduct() {
        int actual = ConditionalStatements.getSumOrProduct(3, 10);
        int expected = 13;
        Assertions.assertEquals(expected, actual);
    }
	
	@Test
	public void test_I_getQuadrantByCoordinates() {
		String actual = ConditionalStatements.getQuadrantByCoordinates(3, 3);
		String expected = "The first quadrant.";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_II_getQuadrantByCoordinates() {
		String actual = ConditionalStatements.getQuadrantByCoordinates(-3, 3);
		String expected = "The second quadrant.";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_III_getQuadrantByCoordinates() {
		String actual = ConditionalStatements.getQuadrantByCoordinates(-3, -3);
		String expected = "The third quadrant.";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_IV_getQuadrantByCoordinates() {
		String actual = ConditionalStatements.getQuadrantByCoordinates(3, -3);
		String expected = "The fourth quadrant.";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_betweenI_IV_getQuadrantByCoordinates() {
		String actual = ConditionalStatements.getQuadrantByCoordinates(3, 0);
		String expected = "The point is on the X axis between I and IV quadrants.";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_betweenI_II_getQuadrantByCoordinates() {
		String actual = ConditionalStatements.getQuadrantByCoordinates(0, 3);
		String expected = "The point is on the Y axis between I and II quadrants.";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_betweenII_III_getQuadrantByCoordinates() {
		String actual = ConditionalStatements.getQuadrantByCoordinates(-3, 0);
		String expected = "The point is on the X axis between II and III quadrants.";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_betweenIII_IV_getQuadrantByCoordinates() {
		String actual = ConditionalStatements.getQuadrantByCoordinates(0, -3);
		String expected = "The point is on the Y axis between III and IV quadrants.";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_origin_getQuadrantByCoordinates() {
		String actual = ConditionalStatements.getQuadrantByCoordinates(0, 0);
		String expected = "The origin.";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_111_getPositiveNumbersSum() {
		int actual = ConditionalStatements.getPositiveNumbersSum(1, 1, 1);
		int expected = 3;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_000_getPositiveNumbersSum() {
		int actual = ConditionalStatements.getPositiveNumbersSum(0, 0, 0);
		int expected = 0;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_negativeNumbers_getPositiveNumbersSum() {
		int actual = ConditionalStatements.getPositiveNumbersSum(-1, -1, -1);
		int expected = 0;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_111_getMaxBetweenSumAndProduct() {
		int actual = ConditionalStatements.getMaxBetweenSumAndProduct(1, 1, 1);
		int expected = 6;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_222_getMaxBetweenSumAndProduct() {
		int actual = ConditionalStatements.getMaxBetweenSumAndProduct(2, 2, 2);
		int expected = 11;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_negativeNumbers_getMaxBetweenSumAndProduct() {
		int actual = ConditionalStatements.getMaxBetweenSumAndProduct(-2, -2, -2);
		int expected = -3;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
    public void test_throwException1_getGradeByRating() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ConditionalStatements.getGradeByRating(-1),
                "The rating must be in the range of 0-100!");
    }

    @Test
    public void test_throwException2_getGradeByRating() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ConditionalStatements.getGradeByRating(101),
                "The rating must be in the range of 0-100!");
    }
    
    @Test
    public void test_F_getGradeByRating() {
        char actual = ConditionalStatements.getGradeByRating(19);
        char expected = 'F';
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void test_E_getGradeByRating() {
    	char actual = ConditionalStatements.getGradeByRating(39);
        char expected = 'E';
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void test_D_getGradeByRating() {
    	char actual = ConditionalStatements.getGradeByRating(59);
        char expected = 'D';
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void test_C_getGradeByRating() {
    	char actual = ConditionalStatements.getGradeByRating(74);
        char expected = 'C';
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void test_B_getGradeByRating() {
    	char actual = ConditionalStatements.getGradeByRating(89);
        char expected = 'B';
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void test_A_getGradeByRating() {
    	char actual = ConditionalStatements.getGradeByRating(100);
        char expected = 'A';
        Assertions.assertEquals(expected, actual);
    }
	
}
