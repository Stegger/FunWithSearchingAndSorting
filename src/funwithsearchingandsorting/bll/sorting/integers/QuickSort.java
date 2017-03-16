/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.integers;

/**
 *
 * @author Stegger
 */
public class QuickSort extends IntSortStrategy
{

    private int QUICKSORT_INSERTION_THRESHOLD = 14;

    @Override
    public void sort(int[] data)
    {
        if (data == null || data.length < 1)
        {
            return;
        }
        quicksort(data, 0, data.length - 1);
    }

    private void quicksort(int[] data, int low, int high)
    {
        if (low < high)
        {
            if (high - low > QUICKSORT_INSERTION_THRESHOLD)
            {
                int p = partition(data, low, high);
                quicksort(data, low, p);
                quicksort(data, p + 1, high);
            }
            else //Insertion sort:
            {
                InsertionSortInterval(low, high, data);
            }
        }
    }

    private int partition(int[] arr, int low, int high)
    {
        int pivot = (arr[low] + arr[high] + arr[low + (high - low) / 2]) / 3;
        int i = low - 1;
        int j = high + 1;

        // Vi looper uendeligt som udgangspunkt...
        while (true)
        {
            do
            {
                i++;
                // Så længe i er "in bounds" og mindre end vores pivot.
            } while (i < high && arr[i] < pivot);

            do
            {
                j--;
            } while (j > low && arr[j] > pivot); // Så længe j er "in bounds" og større end vores pivot.

            if (i < j)
            {// Hvis ikke vi har krydset møde punktet mellem low og high, aka. vi har traverseret en hel partition af arrayet!
                swap(arr, i, j); //Når vi herind er der uorden i vores partition og i og j skal swappes!
            }
            else
            {// Hvis !(i<j) så har vi været igennem hele partitionen af arrayet og vi kan nu returnere skille punktet imellem den store og lille halvdel:
                return j;
            }
        }
    }

    private void InsertionSortInterval(int low, int high, int[] arr)
    {
        for (int i = low + 1; i <= high; i++)
        {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j])
            {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

}
