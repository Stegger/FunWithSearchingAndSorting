/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.generic;

import java.util.Comparator;

/**
 *
 * @author Stegger
 */
public class GenericQuickSort extends GenericSort
{

    private int QUICKSORT_INSERTION_THRESHOLD = 14;

    @Override
    public <T> void sort(T[] data, Comparator<? super T> c)
    {
        if (data != null && data.length > 1)
        {
            quicksort(data, 0, data.length - 1, c);
        }
    }

    private <T> void quicksort(T[] data, int low, int high, Comparator<? super T> c)
    {
        if (low < high)
        {
            if (high - low > QUICKSORT_INSERTION_THRESHOLD)
            {
                int p = partition(data, low, high, c);
                quicksort(data, low, p, c);
                quicksort(data, p + 1, high, c);
            }
            else //Insertion sort:
            {
                InsertionSortInterval(low, high, data, c);
            }
        }
    }

    private <T> int partition(T[] arr, int low, int high, Comparator<? super T> c)
    {
        T pivot = arr[low + (high - low) / 2];
        int i = low - 1;
        int j = high + 1;

        // Vi looper uendeligt som udgangspunkt...
        while (true)
        {
            do
            {
                i++;
                // Så længe i er "in bounds" og mindre end vores pivot.
            } while (i < high && c.compare(arr[i], pivot) < 0);

            do
            {
                j--;
            } while (j > low && c.compare(arr[j], pivot) > 0); // Så længe j er "in bounds" og større end vores pivot.

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

    private <T> void InsertionSortInterval(int low, int high, T[] arr, Comparator<? super T> c)
    {
        for (int i = low + 1; i <= high; i++)
        {
            int j = i;
            while (j > 0 && c.compare(arr[j - 1], arr[j]) > 0)
            {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

}
