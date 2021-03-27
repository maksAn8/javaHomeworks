package collections;

import java.util.Arrays;

public class AList1 implements IList {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentCapacity;
    private int size;
    private int[] array;
    private int[] arrayCopy;

    public AList1() {
        this(DEFAULT_CAPACITY);
    }

    public AList1(int capacity) {
        array = new int[capacity];
        currentCapacity = capacity;
    }

    public AList1(int[] arr) {
        size = arr.length;
        if (size > DEFAULT_CAPACITY) {
            currentCapacity = size * 3 / 2 + 1;
        } else {
            currentCapacity = DEFAULT_CAPACITY;
        }
        array = new int[currentCapacity];
        System.arraycopy(arr, 0, array, 0, size);
    }

    @Override
    public void clear() {
        array = new int[DEFAULT_CAPACITY];
        currentCapacity = DEFAULT_CAPACITY;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean add(int value) {
        ensureCapacity();
        array[size++] = value;
        return true;
    }

    @Override
    public boolean add(int index, int value) {
        checkIndex(index);
        ensureCapacity();
        int[] tempArray = Arrays.copyOfRange(array, index, size);
        array[index] = value;
        for (int i = 0; i < tempArray.length; i++) {
            array[i + index + 1] = tempArray[i];
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                while (i < size - 1) {
                    array[i] = array[++i];
                }
                array[i] = 0;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeByIndex(int index) {
        checkIndex(index);
        int result = array[index];
        System.arraycopy(array, index + 1, array, index, size-- - 1 - index);
        return result;
    }

    @Override
    public boolean removeAll(int[] arr) {
        boolean isChanged = false;
        for (int elem : arr) {
            if(remove(elem)) {
                if (!isChanged) {
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    @Override
    public boolean contains(int value) {
        return Arrays.stream(array).anyMatch(argument -> argument == value);
    }

    @Override
    public boolean set(int index, int value) {
        checkIndex(index);
        array[index] = value;
        return true;
    }

    @Override
    public void print() {
        arrayCopy = new int[size];
        System.arraycopy(array, 0, arrayCopy, 0, size);
        System.out.println(Arrays.toString(arrayCopy));
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOfRange(array, 0, size);
    }

    private void ensureCapacity() {
        if (size == currentCapacity) {
            currentCapacity = currentCapacity * 3 / 2 + 1;
            arrayCopy = array;
            array = new int[currentCapacity];
            System.arraycopy(arrayCopy, 0, array, 0, arrayCopy.length);
        }
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Illegal index = " + index + " for array with the size = " + size);
        }
    }

    public int getCapacity() {
        return currentCapacity;
    }
}
