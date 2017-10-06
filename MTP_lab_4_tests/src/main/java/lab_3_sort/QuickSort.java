package lab_3_sort;

public class QuickSort implements Sortable{

    public String getName(){return "Quick Sort";}

    public  void Sort(int[] arr, int ... border){
        if (border[0] >= border[1])
            return;
        int i = border[0], j = border[1];
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
        Sort(arr, border[0], cur);
        Sort(arr, cur+1, border[1]);

    }
}
