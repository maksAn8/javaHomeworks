package homeworks.device;

import java.util.Collection;

public class ExecutorArrayList implements Executable {
    @Override
    public void write(Device device) {
        Model.devicesArrList.add(device);
    }

    @Override
    public Device[] read() {
        Device[] devices = new Device[Model.devicesArrList.size()];
        int index = 0;
        for (Object device : Model.devicesArrList.toArray()) {
            devices[index++] = (Device) device;
        }
        return devices;
    }

//    @Override
//    public Collection<Device> getCollection() {
//        return Model.devicesArrList;
//    }

}
