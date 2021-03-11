package homeworks.device.tests;

import homeworks.device.Device;
import homeworks.device.DeviceFilter;
import homeworks.device.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DeviceFilterTest {
    private List<Device> devicesList = new ArrayList<>();
    private Device device1, device2, device3, device4, device5, device6, device7, device8, device9, device10;
    private String[] testData = {"qwe", "qwe", "qwe"};

    @BeforeEach
    public void setUp() {
        device1 = new Device("X86", 1.0, 1, 16, 3);
        device2 = new Device("ARM", 1.5, 4, 32, 4);
        device3 = new Device("X86", 3.2, 6, 64, 5);
        device4 = new Device("ARM", 1.3, 10, 16, 3);
        device5 = new Device("X86", 1.8, 8, 32, 9);
        device6 = new Device("ARM", 2.0, 28, 64, 10);
        device7 = new Device("X86", 3.4, 23, 16, 5);
        device8 = new Device("ARM", 2.5, 10, 32, 7);
        device9 = new Device("X86", 2.8, 12, 64, 8);
        device10 = new Device("ARM", 3.8, 32, 64, 7);
        device1.save(testData);
        device2.save(testData);
        device3.save(testData);
        device4.save(testData);
        device5.save(testData);
        device6.save(testData);
        device7.save(testData);
        device8.save(testData);
        device9.save(testData);
        device10.save(testData);
        Model.devicesArrList.add(device1);
        Model.devicesArrList.add(device2);
        Model.devicesArrList.add(device3);
        Model.devicesArrList.add(device4);
        Model.devicesArrList.add(device5);
        Model.devicesArrList.add(device6);
        Model.devicesArrList.add(device7);
        Model.devicesArrList.add(device8);
        Model.devicesArrList.add(device9);
        Model.devicesArrList.add(device10);
    }

    @AfterEach
    public void clearList() {
        Model.devicesArrList.clear();
    }

    @Test
    public void test_Arm_filterDevicesByProc() {
        List<Device> expected = new ArrayList<>();
        expected.add(device2);
        expected.add(device4);
        expected.add(device6);
        expected.add(device8);
        expected.add(device10);
        List<Device> actual = new DeviceFilter().filterDevicesByProc("ARM");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_X86_filterDevicesByProc() {
        List<Device> expected = new ArrayList<>();
        expected.add(device1);
        expected.add(device3);
        expected.add(device5);
        expected.add(device7);
        expected.add(device9);
        List<Device> actual = new DeviceFilter().filterDevicesByProc("X86");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_64bit_filterDevicesByProc() {
        List<Device> expected = new ArrayList<>();
        expected.add(device3);
        expected.add(device6);
        expected.add(device9);
        expected.add(device10);
        List<Device> actual = new DeviceFilter().filterDevicesByProc((short)64);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_moreThanFreq_filterDevicesByProc() {
        List<Device> expected = new ArrayList<>();
        expected.add(device3);
        expected.add(device7);
        expected.add(device8);
        expected.add(device9);
        expected.add(device10);
        List<Device> actual = new DeviceFilter().filterDevicesByProc(2.0, true);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_lessThanFreq_filterDevicesByProc() {
        List<Device> expected = new ArrayList<>();
        expected.add(device1);
        expected.add(device2);
        expected.add(device4);
        List<Device> actual = new DeviceFilter().filterDevicesByProc(1.8, false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_moreThanCache_filterDevicesByProc() {
        List<Device> expected = new ArrayList<>();
        expected.add(device6);
        expected.add(device7);
        expected.add(device10);
        List<Device> actual = new DeviceFilter().filterDevicesByProc(20, true);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_lessThanCache_filterDevicesByProc() {
        List<Device> expected = new ArrayList<>();
        expected.add(device1);
        expected.add(device2);
        expected.add(device3);
        expected.add(device5);
        List<Device> actual = new DeviceFilter().filterDevicesByProc(10, false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_moreThanMemSize_filterDevicesByMemory() {
        List<Device> expected = new ArrayList<>();
        expected.add(device5);
        expected.add(device6);
        expected.add(device9);
        List<Device> actual = new DeviceFilter().filterDevicesByMemory(7, true);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_lessThanMemSize_filterDevicesByMemory() {
        List<Device> expected = new ArrayList<>();
        expected.add(device1);
        expected.add(device2);
        expected.add(device4);
        List<Device> actual = new DeviceFilter().filterDevicesByMemory(5, false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_moreThanOccupiedMem_filterDevicesByMemory() {
        List<Device> expected = new ArrayList<>();
        expected.add(device1);
        expected.add(device2);
        expected.add(device3);
        expected.add(device4);
        expected.add(device7);
        List<Device> actual = new DeviceFilter().filterDevicesByMemory(50.0, true);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_lessThanOccupiedMem_filterDevicesByMemory() {
        List<Device> expected = new ArrayList<>();
        expected.add(device5);
        expected.add(device6);
        expected.add(device9);
        List<Device> actual = new DeviceFilter().filterDevicesByMemory(40.0, false);
        Assertions.assertEquals(expected, actual);
    }

}
