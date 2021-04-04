package collections;

import java.util.NoSuchElementException;

public class LList1 implements IList {
    private Node first;
    private Node last;
    private int size;

    public LList1() { }

    public LList1(int[] array) {
        addArray(array);
    }

    @Override
    public void clear() {
        for (Node elem = first; elem != null;) {
            Node nextElem = elem.next;
            elem.prev = null;
            elem.next = null;
            elem = nextElem;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        Node temp = first;
        for (int i = 0; ; i++) {
            if (i == index) {
                return temp.value;
            } else {
                temp = temp.next;
            }
        }
    }

    @Override
    public boolean add(int value) {
        if (first == null) {
            first = last = new Node(value);
        } else {
            last.next = new Node(value);
            last.next.prev = last;
            last = last.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, int value) {
        checkIndex(index);
        Node oldElem = first;
        Node newElem = new Node(value);
        for (int i = 0; ; i++) {
            if (i == index) {
                if (i == 0) {
                    newElem.next = first;
                    first.prev = newElem;
                    first = newElem;
                } else {
                    newElem.prev = oldElem.prev;
                    oldElem.prev = newElem;
                    newElem.next = oldElem;
                    newElem.prev.next = newElem;
                }
                break;
            } else {
                oldElem = oldElem.next;
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(int value) {
        for (Node elem = first; elem != null;) {
            if (elem.value == value) {
                innerRemove(elem);
                return true;
            } else {
                elem = elem.next;
            }
        }
        return false;
    }

    @Override
    public int removeByIndex(int index) {
        checkIndex(index);
        Node elem = first;
        for (int i = 0; ; i++) {
            if (i == index) {
                int removedItemValue = elem.value;
                innerRemove(elem);
                return removedItemValue;
            } else {
                elem = elem.next;
            }
        }
    }

    @Override
    public boolean contains(int value) {
        for (Node elem = first; elem != null; elem = elem.next) {
            if (elem.value == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
        checkIndex(index);
        Node elem = first;
        for (int i = 0; ; i++, elem = elem.next) {
            if (i == index) {
                elem.value = value;
                return true;
            }
        }
    }

    @Override
    public void print() {
        if (size == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (Node elem = first; elem != null; elem = elem.next) {
            System.out.print(elem.value);
            if (elem.next == null) {
                System.out.println("]");
            } else {
                System.out.print(", ");
            }
        }
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[size];
        Node elem = first;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = elem.value;
            elem = elem.next;
        }
        return arr;
    }

    @Override
    public boolean removeAll(int[] arr) {
        boolean result = false;
        for (Node elem = first; elem != null; elem = elem.next) {
            for (int arrVal : arr) {
                if (elem.value == arrVal) {
                    innerRemove(elem);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private void innerRemove(Node elem) {
        if (elem == first) {
            first.next.prev = null;
            first = first.next;
        } else if (elem == last) {
            last.prev.next = null;
            last = last.prev;
        } else {
            elem.prev.next = elem.next;
            elem.next.prev = elem.prev;
        }
        size--;
    }

    private void addArray(int[] array) {
        for (int elem : array) {
            add(elem);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index = " + index + " for linked list with the size = " + size);
        }
    }

    private class Node {
        private int value;
        private Node prev;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }
}
