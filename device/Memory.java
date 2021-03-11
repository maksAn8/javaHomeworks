package homeworks.device;

public class Memory {
    public String[] memoryCell;
    private int emptyCellIndex;

    public Memory(int memorySize) {
        emptyCellIndex = 0;
        memoryCell = new String[memorySize];
    }

    public String readLast() {
        if(memoryCell[0] == null) {
            return "There are no data in the memory";
        } else {
            return memoryCell[emptyCellIndex - 1];
        }
    }

    public void removeLast() {
        if (emptyCellIndex == 0) {
            throw new ArrayIndexOutOfBoundsException("There are nothing to remove!");
        }
        memoryCell[emptyCellIndex-- - 1] = null;
    }

    public boolean save(String data) {
        if (emptyCellIndex == memoryCell.length || data == null || data.strip().length() == 0) {
            return false;
        } else {
            memoryCell[emptyCellIndex++] = data;
            return true;
        }
    }

    public int getEmptyCellIndex() {
        return emptyCellIndex;
    }

    public MemoryInfo getMemoryInfo() {
        return new MemoryInfo();
    }

    public class MemoryInfo {
        private int memorySize;
        private double occupiedMemory;

        private MemoryInfo() {
            memorySize = memoryCell.length;
            occupiedMemory = (double) emptyCellIndex / memorySize * 100;
        }

        public int getMemorySize() {
            return memorySize;
        }

        public double getOccupiedMemory() {
            return Device.round(occupiedMemory);
        }

    }
}
