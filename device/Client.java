package homeworks.device;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
//        String[] data = new String[] {"123", "456", "dsf"};
//        Device d = new Device();
//        System.out.println(d.getSystemInfo());
//        d.readAll();
//        d.save(data);
//        System.out.println(d.getSystemInfo());
//        d.dataProcessing();
//        d.save(data);
//        System.out.println(Arrays.toString(d.readAll()));
//        System.out.println(Arrays.toString(d.readAll()));
        new DeviceController().startApp();
    }
}
