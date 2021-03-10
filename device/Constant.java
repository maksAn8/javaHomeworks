package homeworks.device;

class Constant {
    final static double MIN_FREQ = 1.0;
    final static double MAX_FREQ = 3.8;
    final static double DEF_FREQ = 2.0;
    final static int MIN_CACHE = 1;
    final static int MAX_CACHE = 32;
    final static int DEF_CACHE = 12;
    final static int X86_BIT_CAP16 = 16;
    final static int ARM_X86_BIT_CAP32 = 32, DEF_CAP = 32;
    final static int ARM_X86_BIT_CAP64 = 64;
    final static int DEF_MEM_SIZE = 3;
    final static int MAX_MEM_SIZE = 10;
    final static int NUM_MIN_POWER = 4;
    final static int RND_SCALE = 1;

    final static String CREATE = "create";
    final static String READ = "read";
    final static String SELECT = "select";
    final static String SORT = "sort";
    final static String HELP = "help";
    final static String EXIT = "exit";
    final static String BACK = "back";
    final static String INFO = "info";
    final static String PROC = "proc";
    final static String SAVE = "save";
    final static String FILTER = "filter";
    final static String MAIN_INFO = "Enter your command, please (create, read, select, filter, sort, help, exit)";
    final static String MAIN_HELP = "Available commands: \n" +
            "1. create - create a new device\n" +
            "2. read - show created devices list\n" +
            "3. select 'device id' - select device from list\n" +
            "4. filter - filter devices list" +
            "5. sort - sort devices list\n" +
            "6. exit - quit the application\n";
    final static String DEV_INFO = "Enter your command to control device (save, read, proc, info, help, back, exit)";
    final static String DEV_HELP = "Available commands: \n" +
            "1. save 'your data separated by spaces' - save your data in this device memory\n" +
            "2. read - read a data from device memory (and clear it)\n" +
            "3. proc - process your data\n" +
            "4. info - get system information about this device\n" +
            "5. back - go back to main menu\n" +
            "6. exit - quit the application\n";
    final static String CMD_ARCH = "arch";
    final static String CMD_FREQ = "freq";
    final static String CMD_CACHE = "cache";
    final static String CMD_BIT = "bit";
    final static String CMD_MEM_SIZE = "memsize";
    final static String CMD_OCC_MEM = "occmem";
    final static String SORT_INFO = "Select sort mode: arch, freq, cache, bit, memsize, occmem";
    final static String FILTER_INFO = "Select filter by: arch, freq, cache, bit, memsize, occmem (syntax: filter_mode 'filter parameter')";
    final static String PARAM_ERR_MSG = "Incorrect parameter in the command! Enter parameter again, please...";
}
