import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraysTest {
	
	@Test
	public void test_getMinElementOfArray() {
		int[] array = new int[]{6, 2, 3, 4};
		int actual = Arrays.getMinElementOfArray(array);
		int expected = 2;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_getMinElementOfArray() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()->Arrays.getMinElementOfArray(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_getMaxElementOfArray() {
		int[] array = new int[]{6, 2, 3, 1, 7};
		int actual = Arrays.getMaxElementOfArray(array);
		int expected = 7;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_getMaxElementOfArray() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()->Arrays.getMaxElementOfArray(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_getMinElementIndexOfArray() {
		int[] array = new int[]{6, 2, 3, 1, 7};
		int actual = Arrays.getMinElementIndexOfArray(array);
		int expected = 3;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_getMinElementIndexOfArray() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()-> Arrays.getMinElementIndexOfArray(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_getMaxElementIndexOfArray() {
		int[] array = new int[]{6, 2, 3, 1, 7};
		int actual = Arrays.getMaxElementIndexOfArray(array);
		int expected = 4;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_getMaxElementIndexOfArray() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()-> Arrays.getMaxElementIndexOfArray(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_getSumOfElemetsWithOddIndex() {
		int[] array = new int[]{6, 2, 3, 1, 7};
		int actual = Arrays.getSumOfElemetsWithOddIndex(array);
		int expected = 3;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_getSumOfElemetsWithOddIndex() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()-> Arrays.getSumOfElemetsWithOddIndex(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_oddElems_getReversedArray() {
		int[] array = new int[]{6, 2, 3, 1, 7};
		int[] actual = Arrays.getReversedArray(array);
		int[] expected = {7, 1, 3, 2, 6};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_evenElems_getReversedArray() {
		int[] array = new int[]{6, 2, 3, 1};
		int[] actual = Arrays.getReversedArray(array);
		int[] expected = {1, 3, 2, 6};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_getReversedArray() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()-> Arrays.getReversedArray(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_getAmountOfOddElements() {
		int[] array = new int[]{6, 2, 3, 1, 7};
		int actual = Arrays.getSumOfElemetsWithOddIndex(array);
		int expected = 3;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_getAmountOfOddElements() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()-> Arrays.getAmountOfOddElements(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_oddElems_toSwapTwoPartsOfArray() {
		int[] array = new int[]{6, 2, 3, 1, 7};
		int[] actual = Arrays.toSwapTwoPartsOfArray(array);
		int[] expected = {1, 7, 3, 6, 2};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_evenElems_toSwapTwoPartsOfArray() {
		int[] array = new int[]{6, 2, 3, 1};
		int[] actual = Arrays.toSwapTwoPartsOfArray(array);
		int[] expected = {3, 1, 6, 2};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_toSwapTwoPartsOfArray() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()-> Arrays.toSwapTwoPartsOfArray(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_evenElems_bubbleSort() {
		int[] array = new int[]{6, 2, 3, 1};
		int[] actual = Arrays.bubbleSort(array);
		int[] expected = {1, 2, 3, 6};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_oddElems_bubbleSort() {
		int[] array = new int[]{6, 2, 3, 1, 5};
		int[] actual = Arrays.bubbleSort(array);
		int[] expected = {1, 2, 3, 5, 6};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_bubbleSort() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()-> Arrays.bubbleSort(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_evenElems_selectionSort() {
		int[] array = new int[]{6, 2, 3, 1};
		int[] actual = Arrays.selectionSort(array);
		int[] expected = {1, 2, 3, 6};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_oddElems_selectionSort() {
		int[] array = new int[]{6, 2, 3, 1, 5};
		int[] actual = Arrays.selectionSort(array);
		int[] expected = {1, 2, 3, 5, 6};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_selectionSort() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()-> Arrays.selectionSort(null),
				"Array can't be null!");
	}
	
	@Test
	public void test_evenElems_insertionSort() {
		int[] array = new int[]{6, 2, 3, 1};
		int[] actual = Arrays.insertionSort(array);
		int[] expected = {1, 2, 3, 6};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_oddElems_insertionSort() {
		int[] array = new int[]{6, 2, 3, 1, 5};
		int[] actual = Arrays.selectionSort(array);
		int[] expected = {1, 2, 3, 5, 6};
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_throwException_insertionSort() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()-> Arrays.insertionSort(null),
				"Array can't be null!");
	}
	
}
