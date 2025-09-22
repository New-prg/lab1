
public class Main {
    public static void main(String[] args) {
        IntContainer c = new IntContainer();
        
    }
}

class IntContainer {
    private int[] data;
    private int size;

    public IntContainer() {
        data = new int[10]; 
        size = 0;
        
    }


    public void add(int value) {
        if (size == data.length) {
            grow();
        }
        data[size] = value;

        size++;
    }


    public int get(int index) {
        checkIndex(index);
        return data[index];
    }


    public int remove(int index) {

        checkIndex(index);
        int removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;


    }


    public int size() {
        return size;
    }


    private void grow() {
        int newCapacity = data.length == 0 ? 1 : data.length * 2;
        int[] tmp = new int[newCapacity];
        for (int i = 0; i < data.length; i++) {
            tmp[i] = data[i];
        }
        data = tmp;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }
}
