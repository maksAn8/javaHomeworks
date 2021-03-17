package homeworks.device;

import java.util.List;
import java.util.stream.Collectors;

public class DeviceFilter {

    public List<Device> filterDevicesByProc(String procArch) {
        List<Device> devicesList = Model.devicesArrList.stream()
                .filter(device -> device.getProcessor().getArchitecture().equalsIgnoreCase(procArch)).collect(Collectors.toList());
//        for (Device d : list.read()) {
//            if (d.getProcessor().getArchitecture().equalsIgnoreCase(procArch)) {
//                devicesList.add(d);
//            }
//        }
        return devicesList;
    }

    public List<Device> filterDevicesByProc(short bitParam) {
        List<Device> devicesList = Model.devicesArrList.stream()
                .filter(device -> device.getProcessor().getBitCapacity() == bitParam).collect(Collectors.toList());

//            for (Device d : list.read()) {
//                if (d.getProcessor().getBitCapacity() == filterParam) {
//                    devicesList.add(d);
//                }
//            }

        return devicesList;
    }

    public List<Device> filterDevicesByProc(double freq, boolean isMore) {
        List<Device> devicesList;
        if(isMore) {
            devicesList = Model.devicesArrList.stream()
                    .filter(device -> device.getProcessor().getFrequency() > freq).collect(Collectors.toList());
        } else {
            devicesList = Model.devicesArrList.stream()
                    .filter(device -> device.getProcessor().getFrequency() < freq).collect(Collectors.toList());
        }
        //Another realization: List<Device> devicesList = select(Model.devicesArrList, having(on(Device.class).getProcessor().getFrequency(), greaterThan(freq)));
//        for (Device d : list.read()) {
//            if (d.getProcessor().getFrequency() > freq) {
//                devicesList.add(d);
//            }
//        }
        return devicesList;
    }

    public List<Device> filterDevicesByProc(int cache, boolean isMore) {
        List<Device> devicesList;
        if (isMore) {
            devicesList = Model.devicesArrList.stream().filter(device -> device.getProcessor().getCache() > cache).collect(Collectors.toList());
        } else {
            devicesList = Model.devicesArrList.stream().filter(device -> device.getProcessor().getCache() < cache).collect(Collectors.toList());

        }
//        for (Device d : list.read()) {
//            if (d.getProcessor().getCache() > cache) {
//                devicesList.add(d);
//            }
//        }
        return devicesList;
    }

    public List<Device> filterDevicesByMemory(int memSize, boolean isMore) {
        List<Device> devicesList;
        if(isMore) {
            devicesList = Model.devicesArrList.stream().filter(device -> device.getMemory().getMemoryInfo().getMemorySize() > memSize).collect(Collectors.toList());
        } else {
            devicesList = Model.devicesArrList.stream().filter(device -> device.getMemory().getMemoryInfo().getMemorySize() < memSize).collect(Collectors.toList());

        }
//        for (Device d : list.read()) {
//            if (d.getMemory().getMemoryInfo().getMemorySize() > memSize) {
//                devicesList.add(d);
//            }
//        }
        return devicesList;
    }

    public List<Device> filterDevicesByMemory(double occMem , boolean isMore) {
        List<Device> devicesList;
        if(isMore) {
            devicesList = Model.devicesArrList.stream().filter(device -> device.getMemory().getMemoryInfo().getOccupiedMemory() > occMem).collect(Collectors.toList());
        } else {
            devicesList = Model.devicesArrList.stream().filter(device -> device.getMemory().getMemoryInfo().getOccupiedMemory() < occMem).collect(Collectors.toList());
        }
//        for (Device d : list.read()) {
//            if (d.getMemory().getMemoryInfo().getOccupiedMemory() > occMem) {
//                devicesList.add(d);
//            }
//        }
        return devicesList;
    }
}
