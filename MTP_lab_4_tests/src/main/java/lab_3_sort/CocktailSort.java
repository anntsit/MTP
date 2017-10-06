package lab_3_sort;

public class CocktailSort implements Sortable {

    public String getName(){return "Cocktail Sort";}

    public void Sort(int[] arr, int... border) {
            int n = arr.length, start = 0, end = n - 1, temp;
            boolean swapped = true;

            while (swapped)
            {
                // reset the swapped flag on entering
                // the loop, because it might be true from
                // a previous iteration.
                swapped = false;
                for (int i = start; i < end; ++i)
                {
                    if (arr[i] > arr[i + 1])
                    {
                        temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
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
                    if (arr[i] > arr[i + 1])
                    {
                        temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        swapped = true;
                    }
                }

                // increase the starting point, because
                // the last stage would have moved the next
                // smallest number to its rightful spot.
                start++;
            }

        }
    }

