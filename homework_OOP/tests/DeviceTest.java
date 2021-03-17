package homeworks.device.tests;

import static homeworks.device.Constant.*;
import homeworks.device.Device;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class DeviceTest {
    private Device device;
    private final static String X86 = "X86";
    private final static String ARM = "ARM";
    private final static int MEM_SIZE = 3;
    private static String[] strDataTest = {"qwe", "qwe", "qwe"};

    @BeforeEach
    public void setUpBeforeAll() {
        device = new Device();
    }

    @Test
    public void test_createDeviceWithArchX86() {
        device = new Device(X86, DEF_FREQ, DEF_CACHE, DEF_CAP, MEM_SIZE);
        Assertions.assertEquals(X86, device.getProcessor().getArchitecture());
        Assertions.assertEquals(DEF_FREQ, device.getProcessor().getFrequency());
        Assertions.assertEquals(DEF_CACHE, device.getProcessor().getCache());
        Assertions.assertEquals(DEF_CAP, device.getProcessor().getBitCapacity());
        Assertions.assertEquals(MEM_SIZE, device.getMemory().getMemoryInfo().getMemorySize());
    }

    @Test
    public void test_createDeviceWithArchArm() {
        device = new Device(ARM, DEF_FREQ, DEF_CACHE, DEF_CAP, MAX_MEM_SIZE);
        Assertions.assertEquals(ARM, device.getProcessor().getArchitecture());
    }

    @Test
    public void test_round() {
        double expected = 20.6;
        double actual = Device.round(20.5789789);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_null_save() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->device.save(null), "Data can not be null!");
    }

    @Test
    public void test_fullMem_save() {
        device.save(strDataTest);
        Assertions.assertArrayEquals(strDataTest, device.getMemory().memoryCell);
    }

    @Test
    public void test_overMemSize_save() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        device.save(strDataTest);
        device.save(strDataTest);
        String expected = "Memory is full!\r\n";
        String actual = outputStreamCaptor.toString();
        Assertions.assertEquals(expected, actual);
        Assertions.assertArrayEquals(strDataTest, device.getMemory().memoryCell);
    }

    @Test
    public void test_fromEmptyMem_readAll() {
        Assertions.assertNull(device.readAll());
    }

    @Test
    public void test_readAll() {
        device.save(strDataTest);
        String[] expected = strDataTest;
        String[] actual = device.readAll();
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertTrue(Arrays.stream(device.getMemory().memoryCell).allMatch(Objects::isNull));
    }

    @Test
    public void test_DeviceX86WithEmptyMem_dataProcessing() {
        device.dataProcessing();
        Assertions.assertTrue(Arrays.stream(device.getMemory().memoryCell).allMatch(Objects::isNull));
    }

    @Test
    public void test_DeviceX86_dataProcessing() {
        String[] expected = {"$", "$", "$"};
        device.save(strDataTest);
        device.dataProcessing();
        Assertions.assertArrayEquals(expected, device.getMemory().memoryCell);
    }

    @Test
    public void test_DeviceArm_dataProcessing() {
        device = new Device(ARM, DEF_FREQ, DEF_CACHE, DEF_CAP, MAX_MEM_SIZE);
        device.save(strDataTest);
        device.dataProcessing();
        for(int i = 0; i < strDataTest.length; i++) {
            Assertions.assertEquals(strDataTest[i].toUpperCase(Locale.ROOT), device.getMemory().memoryCell[i]);
        }
    }

    @Test
    public void test_getSystemInfo() {
        String expected = "Processor " + device.getProcessor().getArchitecture() + ": " + device.getProcessor().getDetails()
                + "\nMemory info: size = " + device.getMemory().getMemoryInfo().getMemorySize() + ", occupied memory: " + device.getMemory().getMemoryInfo().getOccupiedMemory() + " %";
        String actual = device.getSystemInfo();
        Assertions.assertEquals(expected, actual);
    }

}
