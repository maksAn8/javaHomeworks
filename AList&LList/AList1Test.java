package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class AList1Test {
    private static int[] testArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    private static final int DEFAULT_CAPACITY = 10;
    private AList1 myAList;

    @BeforeEach
    public void setUp() {
        myAList = new AList1(testArr);
    }

    @Test
    public void test_AListConstructor1() {
        myAList = new AList1();
        int expected = DEFAULT_CAPACITY;
        int actual = myAList.getCapacity();
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(0, myAList.size());
    }

    @Test
    public void test_AListConstructor2() {
        myAList = new AList1(13);
        int expected = 13;
        int actual = myAList.getCapacity();
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(0, myAList.size());
    }

    @Test
    public void test_sizeAndCapacity() {
        int expected = testArr.length * 3 / 2 + 1;
        int actual = myAList.getCapacity();
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(testArr.length, myAList.size());
    }

    @Test
    public void test_EmptyArr_print() {
        myAList = new AList1();
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        myAList.print();
        String expected = "[]\r\n";
        String actual = outputStreamCaptor.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_print() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        myAList.print();
        String expected = Arrays.toString(testArr) + "\r\n";
        String actual = outputStreamCaptor.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_clear() {
        myAList.clear();
        int expected = 0;
        int actual = myAList.size();
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(DEFAULT_CAPACITY, myAList.getCapacity());
    }

    @Test
    public void test_index0_get() {
        int expected = testArr[0];
        int actual = myAList.get(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_lastIndex_get() {
        int expected = testArr[testArr.length - 1];
        int actual = myAList.get(myAList.size() - 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_midIndex_get() {
        int expected = testArr[testArr.length / 2];
        int actual = myAList.get(myAList.size() / 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_exception1_get() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myAList.get(testArr.length),
                "Illegal index = " + testArr.length + " for array with the size = " + myAList.size());
    }

    @Test
    public void test_exception2_get() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myAList.get(-1),
                "Illegal index = " + -1 + " for array with the size = " + myAList.size());
    }

    @Test
    public void test_add() {
        Assertions.assertTrue(myAList.add(12));
        int expected = testArr.length + 1;
        int actual = myAList.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_add2() {
        Assertions.assertTrue(myAList.add( 0,12));
        int expected = testArr.length + 1;
        int actual = myAList.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_add3() {
        Assertions.assertTrue(myAList.add( testArr.length / 2,12));
        int expected = testArr.length + 1;
        int actual = myAList.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_exception1_add() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myAList.add(testArr.length, 10),
                "Illegal index = " + testArr.length + " for array with the size = " + myAList.size());
    }

    @Test
    public void test_exception2_add() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myAList.add(-1, 10),
                "Illegal index = " + -1 + " for array with the size = " + myAList.size());
    }

    @Test
    public void test_firstElem_remove() {
        Assertions.assertTrue(myAList.remove(testArr[0]));
        int[] expected = Arrays.copyOfRange(testArr, 1, testArr.length);
        int[] actual = myAList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_lastElem_remove() {
        Assertions.assertTrue(myAList.remove(testArr[testArr.length - 1]));
        int[] expected = Arrays.copyOfRange(testArr, 0, testArr.length - 1);
        int[] actual = myAList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_nonExistingElem_remove() {
        Assertions.assertFalse(myAList.remove(testArr[0] - 1337));
        int[] expected = testArr;
        int[] actual = myAList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_index0_removeByIndex() {
        int actualRemovedElem = myAList.removeByIndex(0);
        int expectedRemovedElem = testArr[0];
        int[] expected = Arrays.copyOfRange(testArr, 1, testArr.length);
        int[] actual = myAList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_lastIndex_removeByIndex() {
        int expectedRemovedElem = testArr[testArr.length - 1];
        int actualRemovedElem = myAList.removeByIndex(testArr.length - 1);
        int[] expected = Arrays.copyOfRange(testArr, 0, testArr.length - 1);
        int[] actual = myAList.toArray();
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(expectedRemovedElem, actualRemovedElem);
    }

    @Test
    public void test_exception1_removeByIndex() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myAList.removeByIndex(testArr.length),
                "Illegal index = " + testArr.length + " for array with the size = " + myAList.size());
    }

    @Test
    public void test_exception2_removeByIndex() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myAList.removeByIndex(-1),
                "Illegal index = " + -1 + " for array with the size = " + myAList.size());
    }

    @Test
    public void test_true_removeAll() {
        myAList.add(100);
        Assertions.assertTrue(myAList.removeAll(testArr));
        int[] expected = new int[] {100};
        int[] actual = myAList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_false_removeAll() {
        Assertions.assertFalse(myAList.removeAll(new int[] {-9}));
        int[] expected = testArr;
        int[] actual = myAList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_true_contains() {
        Assertions.assertTrue(myAList.contains(0));
    }

    @Test
    public void test_false_contains() {
        Assertions.assertFalse(myAList.contains(-1337));
    }

    @Test
    public void test_set() {
        Assertions.assertTrue(myAList.set(1, 100));
        testArr[1] = 100;
        int[] expected = testArr;
        int[] actual = myAList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_exception1_set() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myAList.set(testArr.length, 100),
                "Illegal index = " + testArr.length + " for array with the size = " + myAList.size());
    }

    @Test
    public void test_exception2_set() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myAList.set(-1, 100),
                "Illegal index = " + -1 + " for array with the size = " + myAList.size());
    }
}
