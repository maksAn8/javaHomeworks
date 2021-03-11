package homeworks.device;

import java.util.Collection;

public interface Executable {
    void write(Device device);
    Device[] read();
    //Collection getCollection();
}
