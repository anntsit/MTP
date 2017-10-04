package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(150);
        int count = 3;
        while(count > 0) {
            Sort(1,3, array.getArray());
            Sort(2,3, array.getArray());
            Sort(3,3, array.getArray());
            Sort(4,3, array.getArray());
            Sort(5,3, array.getArray());
            Sort(6,3, array.getArray());
            Sort(7,3, array.getArray());
            count--;
        }
    }

    public static void BubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void InsertionSort(int[] arr){
        int  key, j;
        for (int i = 1; i < arr.length; i++)
        {
            key = arr[i];
            j = i-1;

            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    public static void QuickSort(int[] arr, int start, int end){
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (arr[i] <= arr[cur])) {
                i++;
            }
            while (j > cur && (arr[cur] <= arr[j])) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        QuickSort(arr, start, cur);
        QuickSort(arr, cur+1, end);

    }

    public static void CycleSort(int[] arr){
        for (int cycleStart = 0; cycleStart < arr.length - 1; cycleStart++) {
            int val = arr[cycleStart];

            // count the number of values that are smaller than val
            // since cycleStart
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < arr.length; i++)
                if (arr[i] < val)
                    pos++;

            // there aren't any
            if (pos == cycleStart)
                continue;

            // skip duplicates
            while (val == arr[pos])
                pos++;

            // put val into final position
            int tmp = arr[pos];
            arr[pos] = val;
            val = tmp;


            // repeat as long as we can find values to swap
            // otherwise start new cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < arr.length; i++)
                    if (arr[i] < val)
                        pos++;

                while (val == arr[pos])
                    pos++;

                tmp = arr[pos];
                arr[pos] = val;
                val = tmp;

            }
        }
    }

    public static void MergeSort(int[] arr, int lowerIndex, int higherIndex){

        if (lowerIndex < higherIndex)
        {
            // Find the middle point
            int middle = (lowerIndex + higherIndex)/2;

            // Sort first and second halves
            MergeSort(arr, lowerIndex, middle);
            MergeSort(arr , middle+1, higherIndex);

            // Merge the sorted halves
            Merge(arr, lowerIndex, middle, higherIndex);
        }
    }
    private static void Merge(int arr[], int lowerIndex, int middle, int higherIndex)
    {
        // Find sizes of two subarrays to be merged
        int n1 = middle - lowerIndex + 1;
        int n2 = higherIndex - middle;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[lowerIndex + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[middle + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = lowerIndex;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void CocktailSort(int array[]){
        int n = array.length, start = 0, end = n - 1, temp;
        boolean swapped = true;

        while (swapped)
        {
            // reset the swapped flag on entering
            // the loop, because it might be true from
            // a previous iteration.
            swapped = false;
            for (int i = start; i < end; ++i)
            {
                if (array[i] > array[i + 1])
                {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            // if nothing moved, then array is sorted.
            if (!swapped) break;

            // otherwise, reset the swapped flag so that it
            // can be used in the next stage
            swapped = false;

            // move the end point back by one, because
            //  item at the end is in its rightful spot
            end--;

            // from right to left, doing the
            // same comparison as in the previous stage
            for (int i = end - 1; i >= start; --i)
            {
                if (array[i] > array[i + 1])
                {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            // increase the starting point, because
            // the last stage would have moved the next
            // smallest number to its rightful spot.
            start++;
        }
        //System.out.println("lab3.Lab3.cocktail()" + Arrays.toString(array));
    }

    public static void Sort(int num, int count, int[] arr){
        Watch watch = new Watch();
        for (int i = 0; i < count; i++) {
            switch(num) {
                case 1:
                    watch.start();
                    BubbleSort(arr);
                    watch.stop();
                    watch.printInfo("Bubble Sort");
                    break;
                case 2:
                    watch.start();
                    InsertionSort(arr);
                    watch.stop();
                    watch.printInfo("Insertion Sort");
                    break;
                case 3:
                    watch.start();
                    QuickSort(arr, 0, arr.length - 1);
                    watch.stop();
                    watch.printInfo("Quick Sort");
                    break;
                case 4:
                    watch.start();
                    CycleSort(arr);
                    watch.stop();
                    watch.printInfo("Cycle Sort");
                    break;
                case 5:
                    watch.start();
                    MergeSort(arr, 0 , arr.length - 1);
                    watch.stop();
                    watch.printInfo("Merge Sort");
                    break;
                case 6:
                    watch.start();
                    Arrays.sort(arr);
                    watch.stop();
                    watch.printInfo("Arrays Sort");
                    break;
                case 7:
                    watch.start();
                    CocktailSort(arr);
                    watch.stop();
                    watch.printInfo("Cocktail Sort");
                    break;
            }
        }
        System.out.println();
    }

}
