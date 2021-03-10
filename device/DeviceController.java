package homeworks.device;

import java.util.*;

import static homeworks.device.Constant.*;

public class DeviceController {
    private Scanner scanner;
    private Device device;
    private Executable executor;
    private boolean isWrongCmd, isFilter, isMore;

    public DeviceController() {
        scanner = new Scanner(System.in);
        executor = new ExecutorArrayList();
    }

    void startApp() {
        while(true) {
            System.out.println(MAIN_INFO);
            switch (scanner.next().toLowerCase(Locale.ROOT).replaceAll("\\s+", " ").split(" ", 1)[0]) {
                case CREATE:
                    createDevice();
                    break;
                case READ:
                    printDevices();
                    break;
                case SELECT:
                    if(!isEmptyList()) {
                        selectDevice();
                    }
                    break;
                case FILTER:
                    if(!isEmptyList()) {
                        setIsMoreForFilter();
                        sortAndFilterMenu();
                    }
                    break;
                case SORT:
                    if(!isEmptyList()) {
                        sortAndFilterMenu();
                    }
                    break;
                case HELP:
                    help();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printErrMsg();
            }
        }
    }

    private void createDevice() {
        isWrongCmd = true;
        System.out.println("Create random or custom device? (enter 1 or 2)");
        while(isWrongCmd) {
            switch (scanner.next()) {
                case "1":
                    isWrongCmd = false;
                    createRandomDevice();
                    break;
                case "2":
                    isWrongCmd = false;
                    createCustomDevice();
                    break;
                default:
                    System.out.println("Enter 1 or 2, please...");
            }
        }
    }

    private void createCustomDevice() {

    }

    private void createRandomDevice() {
        System.out.println("How many devices you want to create?");
        int devNum = getIntFromUser();
        for(int i = 0; i < devNum; i++) {
            Model.devicesArrList.add(new Device(getRandomProcArch(), getRandomFreq(), getRandomCache(), getRandomCap(), getRandomMemSize()));
        }
        System.out.println("Created successfully");
    }

    private String getRandomProcArch() {
        return (Math.random() > 0.5) ? "X86" : "ARM";
    }

    private double getRandomFreq() {
        return MIN_FREQ + Math.random() * (MAX_FREQ - MIN_FREQ);
    }

    private int getRandomCache() {
        return MIN_CACHE + (int) (Math.random() * (MAX_CACHE - MIN_CACHE + 1));
    }

    private int getRandomCap() {
        return (int) Math.pow(2, new Random().nextInt(3) + NUM_MIN_POWER);
    }

    private int getRandomMemSize() {
        return new Random().nextInt(MAX_MEM_SIZE) + 1;
    }

    private void printDevices() {
        if(!isEmptyList()) {
            Device[] devices = executor.read();
            int i = 1;
            for(Device device : devices) {
                System.out.println("--------------------------------------------");
                System.out.println("Device " + i++);
                System.out.println(device);
            }
            System.out.println("--------------------------------------------");
        }
    }

    private void printDevices(List<Device> deviceList) {
        int i = 1;
        for(Device device : deviceList) {
            System.out.println("--------------------------------------------");
            System.out.println("Device " + i++);
            System.out.println(device);
        }
        System.out.println("--------------------------------------------");
    }

    private void selectDevice() {
        try {
            int userChoice = Integer.parseInt(scanner.nextLine().replaceFirst(SELECT + "\\s+", "").strip());
            try {
                device = executor.read()[userChoice - 1];
            } catch (IndexOutOfBoundsException e) {
                printErrMsg();
            }
        } catch (NumberFormatException e) {
            printErrMsg();
        }
        if(device != null) {
            deviceMenu();
        }
    }

    private void deviceMenu() {
        boolean isBack = false;
        System.out.println(DEV_INFO);
        while(!isBack) {
            switch (scanner.next().toLowerCase(Locale.ROOT)) {
                case SAVE:
                    device.save(scanner.nextLine().toLowerCase(Locale.ROOT).replaceFirst(SAVE + " ", "")
                            .replaceAll("\\s+", " ").split(" "));
                    break;
                case READ:
                    System.out.println(Arrays.toString(device.readAll()));
                    break;
                case PROC:
                    device.dataProcessing();
                    System.out.println("Data processing was completed successfully.");
                    break;
                case INFO:
                    System.out.println(device.getSystemInfo());
                    break;
                case HELP:
                    help();
                    break;
                case BACK:
                    isBack = true;
                    device = null;
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printErrMsg();
            }
        }
    }

    private void sortAndFilterMenu() {
        boolean isBack = false;
        while(!isBack) {
            System.out.println(isFilter ? FILTER_INFO : SORT_INFO);
            String cmd = scanner.next();
            switch (cmd) {
                case CMD_ARCH:
                    if(isFilter) {
                        printDevices(new DeviceFilter().filterDevicesByProc(executor, scanner.nextLine().strip()));
                        break;
                    }
                case CMD_BIT:
                    if(isFilter) {
                        printDevices(new DeviceFilter().filterDevicesByProc(scanner.nextLine().strip(), executor));
                        break;
                    }
                case CMD_FREQ:
                case CMD_CACHE:
                case CMD_MEM_SIZE:
                case CMD_OCC_MEM:
                    if(isFilter) {
                        switchFilter(cmd);
                        break;
                    } else {
                        switchSort(cmd);
                        System.out.println("The list was successfully sorted.");
                    }
                case BACK:
                    isFilter = false;
                    isBack = true;
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printErrMsg();
            }
        }
    }

    private void setIsMoreForFilter() {
        isFilter = true;
        isWrongCmd = true;
        System.out.println("Show devices with a parameter more (yes) or less (no) than your value?");
        while(isWrongCmd) {
            switch (scanner.next().toLowerCase(Locale.ROOT)) {
                case "yes":
                    isWrongCmd = false;
                    isMore = true;
                    break;
                case "no":
                    isWrongCmd = false;
                    isMore = false;
                    break;
                default:
                    printErrMsg();
            }
        }
    }

    private void switchFilter(String cmd) {
        double filterParam = getFilterParam();
        switch (cmd) {
            case CMD_FREQ:
                printDevices(new DeviceFilter().filterDevicesByProc(executor, filterParam, isMore));
                break;
            case CMD_CACHE:
                printDevices(new DeviceFilter().filterDevicesByProc(executor, (int) filterParam, isMore));
                break;
            case CMD_MEM_SIZE:
                printDevices(new DeviceFilter().filterDevicesByMemory(executor, (int) filterParam, isMore));
                break;
            case CMD_OCC_MEM:
                printDevices(new DeviceFilter().filterDevicesByMemory(executor, filterParam, isMore));
                break;
        }
    }

    private double getFilterParam() {
        double filterParam = 0.0;
        isWrongCmd = true;
        while(isWrongCmd) {
            try {
                filterParam = Double.parseDouble(scanner.nextLine().strip());
                isWrongCmd = false;
            } catch (NumberFormatException e) {
                printErrMsgParam();
            }
        }
        return filterParam;
    }

    private void help() {
        if(device != null) {
            System.out.println(DEV_HELP);
        } else {
            System.out.println(MAIN_HELP);
        }
    }

    private void exit() {
        isWrongCmd = true;
        System.out.println("Are you sure? (Yes/No)");
        while(isWrongCmd) {
            switch (scanner.next().toLowerCase(Locale.ROOT)) {
                case "yes":
                    System.out.println("Application is closed.");
                    System.exit(0);
                    break;
                case "no":
                    isWrongCmd = false;
                    break;
                default:
                    System.out.println("Enter yes or no, please...");
            }
        }
    }

    private void printListEmptyMsg() {
        System.out.println("Devices list is empty, create a new device and it will be added in the list!");
    }

    private void printErrMsg() {
        System.out.println("Wrong command! Try again, please...");
    }

    private void printErrMsgParam() {
        System.out.println(PARAM_ERR_MSG);
    }

    private boolean isEmptyList() {
        if(executor.read().length == 0) {
            printListEmptyMsg();
            return true;
        } else {
            return false;
        }
    }

    private int getIntFromUser() {
        while(!scanner.hasNextInt()) {
            if (scanner.next().toLowerCase(Locale.ROOT).equals(EXIT)) {
                exit();
            } else {
                printErrMsg();
            }
        }
        return scanner.nextInt();
    }

    private void switchSort(String sortMode) {
        switch (sortMode) {
            case "arch":
                Model.devicesArrList.sort(new SortByProcArch());
                break;
            case "freq":
                Model.devicesArrList.sort(new SortByFreq());
                break;
            case "cache":
                Model.devicesArrList.sort(new SortByCache());
                break;
            case "bit":
                Model.devicesArrList.sort(new SortByBit());
                break;
            case "memsize":
                Model.devicesArrList.sort(new SortByMemSize());
                break;
            case "occmem":
                Model.devicesArrList.sort(new SortByOccMem());
                break;
        }
    }

    private class SortByProcArch implements Comparator<Device> {
        @Override
        public int compare(Device o1, Device o2) {
            if (o1.getProcessor().getArchitecture().compareTo(o2.getProcessor().getArchitecture()) < 0) {
                return -1;
            } else if (o2.getProcessor().getArchitecture().compareTo(o2.getProcessor().getArchitecture()) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private class SortByFreq implements Comparator<Device> {
        @Override
        public int compare(Device o1, Device o2) {
            if (o1.getProcessor().getFrequency() > o2.getProcessor().getFrequency()) {
                return 1;
            } else if (o1.getProcessor().getFrequency() < o2.getProcessor().getFrequency()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private class SortByCache implements Comparator<Device> {
        @Override
        public int compare(Device o1, Device o2) {
            if (o1.getProcessor().getCache() > o2.getProcessor().getCache()) {
                return 1;
            } else if (o1.getProcessor().getCache() < o2.getProcessor().getCache()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private class SortByBit implements Comparator<Device> {
        @Override
        public int compare(Device o1, Device o2) {
            if (o1.getProcessor().getBitCapacity() > o2.getProcessor().getBitCapacity()) {
                return 1;
            } else if (o1.getProcessor().getBitCapacity() < o2.getProcessor().getBitCapacity()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private class SortByMemSize implements Comparator<Device> {
        @Override
        public int compare(Device o1, Device o2) {
            if (o1.getMemory().getMemoryInfo().getMemorySize() > o2.getMemory().getMemoryInfo().getMemorySize()) {
                return 1;
            } else if (o1.getMemory().getMemoryInfo().getMemorySize() < o2.getMemory().getMemoryInfo().getMemorySize()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private class SortByOccMem implements Comparator<Device> {
        @Override
        public int compare(Device o1, Device o2) {
            if (o1.getMemory().getMemoryInfo().getOccupiedMemory() > o2.getMemory().getMemoryInfo().getOccupiedMemory()) {
                return 1;
            } else if (o1.getMemory().getMemoryInfo().getOccupiedMemory() < o2.getMemory().getMemoryInfo().getOccupiedMemory()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
