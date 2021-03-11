package homeworks.device;

public class ProcessorX86 extends Processor {
    private final String architecture = "X86";

    public ProcessorX86(double frequency, int cache, int bitCapacity){
        createProcessor(frequency, cache, bitCapacity);
    }

    @Override
    public String dataProcess(String data) {
        if(data == null) {
            return null;
        }
        return data.replaceAll(".+", "\\$");
    }

    @Override
    public long dataProcess(long data) {
        return ++data;
    }

    @Override
    public String getArchitecture() {
        return architecture;
    }
}
