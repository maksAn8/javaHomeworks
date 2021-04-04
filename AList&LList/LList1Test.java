package collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class LList1Test {
    private static int[] testArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    private LList1 myLList;

    @BeforeEach
    public void setUp() {
        myLList = new LList1(testArr);
    }

    @AfterEach
    public void tearDown() {
        myLList = null;
    }

    @Test
    public void test_LListConstructor1() {
        myLList = new LList1();
        Assertions.assertEquals(0, myLList.size());
    }

    @Test
    public void test_LListConstructor2() {
        myLList = new LList1(testArr);
        int expected = testArr.length;
        int actual = myLList.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_emptyArr_print() {
        myLList = new LList1();
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        myLList.print();
        String expected = "[]\r\n";
        String actual = outputStreamCaptor.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_print() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        myLList.print();
        String expected = Arrays.toString(testArr) + "\r\n";
        String actual = outputStreamCaptor.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_clear() {
        myLList.clear();
        int expected = 0;
        int actual = myLList.size();
        Assertions.assertEquals(expected, actual);
        test_emptyArr_print();
    }

    @Test
    public void test_first_get() {
        int expected = testArr[0];
        int actual = myLList.get(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_last_get() {
        int expected = testArr[testArr.length - 1];
        int actual = myLList.get(myLList.size() - 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_midElem_get() {
        int expected = testArr[testArr.length / 2];
        int actual = myLList.get(myLList.size() / 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_exception1_get() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myLList.get(testArr.length),
                "Illegal index = " + testArr.length + " for array with the size = " + myLList.size());
    }

    @Test
    public void test_exception2_get() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myLList.get(-1),
                "Illegal index = " + -1 + " for array with the size = " + myLList.size());
    }

    @Test
    public void test_last_add() {
        Assertions.assertTrue(myLList.add(12));
        int expected = testArr.length + 1;
        int actual = myLList.size();
        Assertions.assertEquals(expected, actual);
        AList1 temp = new AList1(testArr);
        temp.add(12);
        Assertions.assertArrayEquals(temp.toArray(), myLList.toArray());
    }

    @Test
    public void test_first_add() {
        Assertions.assertTrue(myLList.add( 0,12));
        int expected = testArr.length + 1;
        int actual = myLList.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_inMid_add() {
        Assertions.assertTrue(myLList.add( testArr.length / 2,12));
        int expected = testArr.length + 1;
        int actual = myLList.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_exception1_add() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myLList.add(testArr.length, 10),
                "Illegal index = " + testArr.length + " for linked list with the size = " + myLList.size());
    }

    @Test
    public void test_exception2_add() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myLList.add(-1, 10),
                "Illegal index = " + -1 + " for linked list with the size = " + myLList.size());
    }

    @Test
    public void test_firstElem_remove() {
        Assertions.assertTrue(myLList.remove(testArr[0]));
        int[] expected = Arrays.copyOfRange(testArr, 1, testArr.length);
        int[] actual = myLList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_lastElem_remove() {
        Assertions.assertTrue(myLList.remove(testArr[testArr.length - 1]));
        int[] expected = Arrays.copyOfRange(testArr, 0, testArr.length - 1);
        int[] actual = myLList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_nonExistingElem_remove() {
        Assertions.assertFalse(myLList.remove(testArr[0] - 1337));
        int[] expected = testArr;
        int[] actual = myLList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_index0_removeByIndex() {
        int expectedRemovedElem = testArr[0];
        int actualRemovedElem = myLList.removeByIndex(0);
        int[] expected = Arrays.copyOfRange(testArr, 1, testArr.length);
        int[] actual = myLList.toArray();
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(expectedRemovedElem, actualRemovedElem);
    }

    @Test
    public void test_midElem_removeByIndex() {
        int expectedRemovedElem = testArr[testArr.length / 2];
        int actualRemovedElem = myLList.removeByIndex(testArr.length / 2);
        int[] expected = Arrays.stream(testArr).filter(elem -> elem != testArr[testArr.length / 2]).toArray();
        int[] actual = myLList.toArray();
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(expectedRemovedElem, actualRemovedElem);
    }

    @Test
    public void test_lastIndex_removeByIndex() {
        int actualRemovedElem = myLList.removeByIndex(testArr.length - 1);
        int expectedRemovedElem = testArr[testArr.length - 1];
        int[] expected = Arrays.copyOfRange(testArr, 0, testArr.length - 1);
        int[] actual = myLList.toArray();
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(expectedRemovedElem, actualRemovedElem);
    }

    @Test
    public void test_exception1_removeByIndex() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myLList.removeByIndex(testArr.length),
                "Illegal index = " + testArr.length + " for linked list with the size = " + myLList.size());
    }

    @Test
    public void test_exception2_removeByIndex() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myLList.removeByIndex(-1),
                "Illegal index = " + -1 + " for linked list with the size = " + myLList.size());
    }

    @Test
    public void test_true_removeAll() {
        Assertions.assertTrue(myLList.add(101));
        Assertions.assertTrue(myLList.removeAll(testArr));
        int[] expected = new int[] {101};
        int[] actual = myLList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_false_removeAll() {
        Assertions.assertFalse(myLList.removeAll(new int[] {-9}));
        int[] expected = testArr;
        int[] actual = myLList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_true_contains() {
        Assertions.assertTrue(myLList.contains(0));
    }

    @Test
    public void test_false_contains() {
        Assertions.assertFalse(myLList.contains(-1337));
    }

    @Test
    public void test_set() {
        Assertions.assertTrue(myLList.set(1, 100));
        testArr[1] = 100;
        int[] expected = testArr;
        int[] actual = myLList.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_exception1_set() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myLList.set(testArr.length, 100),
                "Illegal index = " + testArr.length + " for linked list with the size = " + myLList.size());
    }

    @Test
    public void test_exception2_set() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->myLList.set(-1, 100),
                "Illegal index = " + -1 + " for linked list with the size = " + myLList.size());
    }
}
