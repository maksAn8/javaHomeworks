package homeworks.device.tests;

import homeworks.device.Processor;
import homeworks.device.ProcessorArm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class ProcessorArmTest {
    private static Processor processor;
    private static int cache;
    private static int bitCapacity;
    private static double frequency;
    private static String strDataTest;
    private static long longDataTest;

    private void setDefaultProc() {
        processor = new ProcessorArm(frequency, cache, bitCapacity);
    }

    @BeforeAll
    public static void setUpBeforeAll() {
        strDataTest = "qwe";
        longDataTest = 1000;
        cache = 12;
        frequency = 2.5;
        bitCapacity = 64;
        processor = new ProcessorArm(frequency, cache, bitCapacity);
    }

    @Test
    public void test_invalid2_createProcessor() {
        processor = new ProcessorArm(5, 100, 128);
        Assertions.assertEquals(2.0, processor.getFrequency());
        Assertions.assertEquals(12, processor.getCache());
        Assertions.assertEquals(32, processor.getBitCapacity());
        setDefaultProc();
    }

    @Test
    public void test_String_dataProcess() {
        String expected = strDataTest.toUpperCase(Locale.ROOT);
        String actual = processor.dataProcess(strDataTest);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_StringNull_dataProcess() {
        Assertions.assertNull(processor.dataProcess(null));
    }

    @Test
    public void test_long_dataProcess() {
        long expected = longDataTest / 100;
        long actual = processor.dataProcess(longDataTest);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_arm_getArchitecture() {
        processor = new ProcessorArm(frequency, cache, bitCapacity);
        String expected = "ARM";
        String actual = processor.getArchitecture();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_getDetails() {
        String expected = frequency + " GHz, " + cache + " MB, " + bitCapacity + "-bit";
        String actual = processor.getDetails();
        Assertions.assertEquals(expected, actual);
    }
}
