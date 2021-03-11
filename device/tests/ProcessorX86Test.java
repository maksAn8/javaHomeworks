package homeworks.device.tests;

import homeworks.device.Processor;
import homeworks.device.ProcessorX86;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProcessorX86Test {
    private static Processor processor;
    private static int cache;
    private static int bitCapacity;
    private static double frequency;
    private static String strDataTest;
    private static long longDataTest;

    @BeforeAll
    public static void setUpBeforeAll() {
        strDataTest = "qwe";
        longDataTest = 1000;
        cache = 12;
        frequency = 2.5;
        bitCapacity = 64;
        processor = new ProcessorX86(frequency, cache, bitCapacity);
    }

    @Test
    public void test_valid_createProcessor() {
        processor = new ProcessorX86(2.5, 13, 64);
        Assertions.assertEquals(2.5, processor.getFrequency());
        Assertions.assertEquals(13, processor.getCache());
        Assertions.assertEquals(64, processor.getBitCapacity());
    }

    @Test
    public void test_invalid1_createProcessor() {
        processor = new ProcessorX86(0, 0, 0);
        Assertions.assertEquals(2.0, processor.getFrequency());
        Assertions.assertEquals(12, processor.getCache());
        Assertions.assertEquals(32, processor.getBitCapacity());
    }

    @Test
    public void test_String_dataProcess() {
        String expected = "$";
        String actual = processor.dataProcess(strDataTest);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_StringNull_dataProcess() {
        Assertions.assertNull(processor.dataProcess(null));
    }

    @Test
    public void test_long_dataProcess() {
        long expected = longDataTest + 1;
        long actual = processor.dataProcess(longDataTest);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_x86_getArchitecture() {
        String expected = "X86";
        String actual = processor.getArchitecture();
        Assertions.assertEquals(expected, actual);
    }

}
