package lab_3_sort;

public class CycleSort implements  Sortable{

    public String getName(){return "Cycle Sort";}

    public void Sort(int[] arr, int ... border){
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
}
