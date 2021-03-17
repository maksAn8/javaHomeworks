package homeworks.device;

import static homeworks.device.Constant.*;

public abstract class Processor {
    private double frequency;
    private int cache;
    private int bitCapacity;

    public String getDetails() {
        return frequency + " GHz, " + cache + " MB, " + bitCapacity + "-bit";
    }

    protected void createProcessor(double frequency, int cache, int bitCapacity) {
        setFrequency(frequency);
        setCache(cache);
        setBitCapacity(bitCapacity);
    }

    private void setFrequency(double frequency) {
        if(frequency < MIN_FREQ || frequency > MAX_FREQ) {
            System.out.println(String.format("Processor can not be created with this frequency. Creating with default parameter %s", DEF_FREQ));
            this.frequency = DEF_FREQ;
        } else {
            this.frequency = Device.round(frequency);
        }
    }

    private void setCache(int cache) {
        if(cache < MIN_CACHE || cache > MAX_CACHE) {
            System.out.println(String.format("Processor can not be created with this cache. Creating with default parameter %s", DEF_CACHE));
            this.cache = DEF_CACHE;
        } else {
            this.cache = cache;
        }
    }

    private void setBitCapacity(int bitCapacity) {
        switch (bitCapacity) {
            case X86_BIT_CAP16:
            case ARM_X86_BIT_CAP32:
            case ARM_X86_BIT_CAP64:
                this.bitCapacity = bitCapacity;
                break;
            default:
                System.out.println(String.format("Processor can not be created with this bit capacity. Creating with default parameter %s", DEF_CAP));
                this.bitCapacity = DEF_CAP;
        }
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCache() {
        return cache;
    }

    public int getBitCapacity() {
        return bitCapacity;
    }

    public abstract String dataProcess(String data);
    public abstract long dataProcess(long data);
    public abstract String getArchitecture();
}
