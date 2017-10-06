package lab_3_sort;

import java.util.Random;

public class Array {
    private int length;
    private int[] arr;
    private Random rand = new Random();

    public Array(int length) {
        this.length = length;
        arr = new int[length];
        for (int i=0; i < length; i++) {
            arr[i] = rand.nextInt();
        }
    }
    public int getLength() {
        return length;
    }

    public int[] getArray() {
        return arr.clone();
    }

}
