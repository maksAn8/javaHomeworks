package homeworks.device;

public class ProcessorX86 extends Processor {
    private final String architecture = "X86";

    public ProcessorX86(double frequency, int cache, int bitCapacity){
        createProcessor(frequency, cache, bitCapacity);
    }

    @Override
    protected String dataProcess(String data) {
        if(data == null) {
            return null;
        }
        return data.replaceAll(".+", "\\$");
    }

    @Override
    protected long dataProcess(long data) {
        try {
            return ++data;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    protected String getArchitecture() {
        return architecture;
    }
}
