package homeworks.device;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class ProcessorArm extends Processor {
    private final String architecture = "ARM";

    public ProcessorArm(double frequency, int cache, int bitCapacity){
        createProcessor(frequency, cache, bitCapacity);
    }

    @Override
    public String dataProcess(String data) {
        if(data == null) {
            return null;
        }
        return data.toUpperCase(Locale.ROOT);
    }

    @Override
    public long dataProcess(long data) {
        return data / 100;
    }

    @Override
    public String getArchitecture() {
        return architecture;
    }
}
