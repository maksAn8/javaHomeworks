package homeworks.device;

public class Constant {
    public final static double MIN_FREQ = 1.0;
    public final static double MAX_FREQ = 3.8;
    public final static double DEF_FREQ = 2.0;
    public final static int MIN_CACHE = 1;
    public final static int MAX_CACHE = 32;
    public final static int DEF_CACHE = 12;
    public final static int X86_BIT_CAP16 = 16;
    public final static int ARM_X86_BIT_CAP32 = 32, DEF_CAP = 32;
    public final static int ARM_X86_BIT_CAP64 = 64;
    public final static int MAX_MEM_SIZE = 10;
    public final static int DEF_MEM_SIZE = 3;
    public final static int NUM_MIN_POWER = 4;
    public final static int RND_SCALE = 1;

    public final static String CREATE = "create";
    public final static String READ = "read";
    public final static String SELECT = "select";
    public final static String SORT = "sort";
    public final static String HELP = "help";
    public final static String EXIT = "exit";
    public final static String BACK = "back";
    public final static String INFO = "info";
    public final static String PROC = "proc";
    public final static String SAVE = "save";
    public final static String FILTER = "filter";
    public final static String MAIN_INFO = "Enter your command, please (create, read, select, filter, sort, help, exit)";
    public final static String MAIN_HELP = "Available commands: \n" +
            "1. create - create a new device\n" +
            "2. read - show created devices list\n" +
            "3. select 'device id' - select device from list\n" +
            "4. filter - filter devices list" +
            "5. sort - sort devices list\n" +
            "6. exit - quit the application\n";
    public final static String DEV_INFO = "Enter your command to control device (save, read, proc, info, help, back, exit)";
    public final static String DEV_HELP = "Available commands: \n" +
            "1. save 'your data separated by spaces' - save your data in this device memory\n" +
            "2. read - read a data from device memory (and clear it)\n" +
            "3. proc - process your data\n" +
            "4. info - get system information about this device\n" +
            "5. back - go back to main menu\n" +
            "6. exit - quit the application\n";
    public final static String CMD_ARCH = "arch";
    public final static String CMD_FREQ = "freq";
    public final static String CMD_CACHE = "cache";
    public final static String CMD_BIT = "bit";
    public final static String CMD_MEM_SIZE = "memsize";
    public final static String CMD_OCC_MEM = "occmem";
    public final static String SORT_INFO = "Select sort mode: arch, freq, cache, bit, memsize, occmem";
    public final static String FILTER_INFO = "Select filter by: arch, freq, cache, bit, memsize, occmem (syntax: filter_mode 'filter parameter')";
    public final static String PARAM_ERR_MSG = "Incorrect parameter in the command! Enter parameter again, please...";
}
