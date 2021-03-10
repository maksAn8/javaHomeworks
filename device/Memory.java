package homeworks.device;

public class Memory {
    protected String[] memoryCell;
    private int emptyCellIndex;

    Memory(int memorySize) {
        emptyCellIndex = 0;
        memoryCell = new String[memorySize];
    }

    protected String readLast() {
        if(memoryCell[0] == null) {
            return "There are no data in the memory";
        } else {
            return memoryCell[emptyCellIndex - 1];
        }
    }

    protected void removeLast() {
        memoryCell[emptyCellIndex-- - 1] = null;
    }

    protected boolean save(String data) {
        if (emptyCellIndex == memoryCell.length || data == null || data.strip().length() == 0) {
            return false;
        } else {
            memoryCell[emptyCellIndex++] = data;
            return true;
        }
    }

    protected int getEmptyCellIndex() {
        return emptyCellIndex;
    }

    protected MemoryInfo getMemoryInfo() {
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
