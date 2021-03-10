package homeworks.device;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static homeworks.device.Constant.RND_SCALE;

public class Device {
    private Processor processor;
    private Memory memory;

    public Device(String procArch, double f, int c, int bitC, int memSize) {
        createProc(procArch, f, c, bitC);
        memory = new Memory(memSize);
    }

    public static double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(RND_SCALE, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void save(String[] data) {
        for(int i = 0; i < data.length; i++) {
            if(memory.save(data[i]));
            else if(memory.getEmptyCellIndex() == memory.memoryCell.length){
                System.out.println("Memory is full! " + --i + " elements were saved.");
                break;
            }
        }
    }

    public String[] readAll() {
        String[] data = null;
        int freeCellIndex = memory.getEmptyCellIndex();
        if(freeCellIndex == 0) {
            System.out.println("Memory is empty!");
        } else {
            data = new String[freeCellIndex];
            while (freeCellIndex != 0) {
                data[freeCellIndex-- - 1] = memory.readLast();
                memory.removeLast();
            }
        }
        return data;
    }

    public void dataProcessing() {
        for(int i = 0; i < memory.getEmptyCellIndex(); i++) {
            memory.memoryCell[i] = processor.dataProcess(memory.memoryCell[i]);
        }
    }

    public String getSystemInfo() {
        Memory.MemoryInfo mInfo = memory.getMemoryInfo();
        return "Processor " + processor.getArchitecture() + ": " + processor.getDetails()
                + "\nMemory info: size = " + mInfo.getMemorySize() + ", occupied memory: " + mInfo.getOccupiedMemory() + " %";
    }

    public Processor getProcessor() {
        return processor;
    }

    public Memory getMemory() {
        return memory;
    }

    private void createProc(String procArch, double f, int c, int bitC) {
        if (procArch.equals("X86")) {
            processor = new ProcessorX86(f, c, bitC);
        } else {
            processor = new ProcessorArm(f, c, bitC);
        }
    }

    @Override
    public String toString() {
        return getSystemInfo();
    }

}
