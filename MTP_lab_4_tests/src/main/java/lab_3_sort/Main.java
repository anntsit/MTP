package lab_3_sort;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(150);
        Sortable [] sorts = {new BubbleSort(), new CocktailSort(), new CycleSort(), new InsertionSort()};
        Sortable [] paramSorts = {new QuickSort(), new MergeSort()};
        int count = 3;
        while(count > 0) {
            for (int i=0; i<sorts.length; i++) {
                Sort(sorts[i], 3, array.getArray());
            }
            for (int i=0; i<paramSorts.length; i++) {
                Sort(paramSorts[i], 3, array.getArray(), 0, array.getLength()-1);
            }
            count--;
        }
    }

    public static void Sort(Sortable sorts, int count, int[] arr, int...borders){
        Watch watch = new Watch();
        for (int i = 0; i < count; i++) {
            if(borders.length>0){
                watch.start();
                sorts.Sort(arr, borders[0], borders[1]);
                watch.stop();
                watch.printInfo(sorts.getName());
            }
            else {
                watch.start();
                sorts.Sort(arr);
                watch.stop();
                watch.printInfo(sorts.getName());
            }
        }
        System.out.println();
    }
}
