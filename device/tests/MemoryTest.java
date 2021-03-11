package homeworks.device.tests;

import homeworks.device.Memory;
import org.junit.jupiter.api.*;

public class MemoryTest {
    private Memory memory;
    private int memorySize;
    private String dataTest;

    private void addDataToMemory(int amount) {
        for (int i = 0; i < amount; i++) {
            memory.save(dataTest);
        }
    }

    @BeforeEach
    public void setUp() {
        dataTest = "123";
        memorySize = 5;
        memory = new Memory(memorySize);
    }

    @AfterAll
    public static void tearDown() {

    }

    @Test
    public void test_null_readLast() {
        String actual = "There are no data in the memory";
        String expected = memory.readLast();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_1elem_readLast() {
        addDataToMemory(1);
        String actual = memory.memoryCell[0];
        String expected = memory.readLast();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_lastElem_readLast() {
        addDataToMemory(memorySize);
        String actual = memory.memoryCell[memorySize - 1];
        String expected = memory.readLast();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_null_save() {
        boolean actual = memory.save(null);
        Assertions.assertNull(memory.memoryCell[0]);
        Assertions.assertFalse(actual);
    }

    @Test
    public void test_blankString_save() {
        boolean actual = memory.save("   ");
        Assertions.assertNull(memory.memoryCell[0]);
        Assertions.assertFalse(actual);
    }

    @Test
    public void test_moreThanMemorySize_save() {
        for (int i = 0; i <= memorySize; i++) {
            if(i < memorySize) {
                Assertions.assertTrue(memory.save(dataTest));
            } else {
                Assertions.assertFalse(memory.save(dataTest));
            }

        }
    }

    @Test
    public void test_123_save() {
        boolean actual = memory.save(dataTest);
        Assertions.assertEquals(dataTest, memory.memoryCell[0]);
        Assertions.assertTrue(actual);
    }

    @Test
    public void test_1elem_removeLast() {
        memory.save(dataTest);
        memory.removeLast();
        Assertions.assertNull(memory.memoryCell[0]);
    }

    @Test
    public void test_2elem_removeLast() {
        addDataToMemory(2);
        memory.removeLast();
        Assertions.assertNull(memory.memoryCell[1]);
        Assertions.assertEquals(dataTest, memory.memoryCell[0]);

    }

    @Test
    public void test_throwExc_removeLast() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                ()->memory.removeLast(), "There are nothing to remove");
    }

    @Test
    public void test_getEmptyCellIndex() {
        addDataToMemory(memorySize - 1);
        Assertions.assertEquals(memorySize - 1, memory.getEmptyCellIndex());
    }

    @Test
    public void test_memSize_getMemoryInfo() {
        int expected = memorySize;
        int actual = memory.getMemoryInfo().getMemorySize();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_occupiedMem_getMemoryInfo() {
        double expected = 0.0;
        double actual = memory.getMemoryInfo().getOccupiedMemory();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_occMem20_getMemoryInfo() {
        int amount = 2;
        addDataToMemory(amount);
        double expected = (double) amount / memorySize * 100;
        double actual = memory.getMemoryInfo().getOccupiedMemory();
        Assertions.assertEquals(expected, actual);
    }

}
