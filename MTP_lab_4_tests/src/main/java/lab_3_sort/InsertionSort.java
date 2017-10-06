package lab_3_sort;

public class InsertionSort implements Sortable {

    public String getName(){return "Insertion Sort";}

    public void Sort(int[] arr, int ... border){
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
}
