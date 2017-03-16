/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting;

import funwithsearchingandsorting.be.Account;
import java.util.Comparator;

/**
 *
 * @author Stegger
 */
public class GenericSorting
{

    /**
     * Sorts the array using the bubble sort algorithm.
     *
     * @param <T>
     * @param arr
     * @param ct
     */
    public <T> void bubbleSort(T[] arr, Comparator<T> ct)
    {
        int n = arr.length;

        while (n > 1)
        {
            boolean swapped = false;
            for (int i = 1; i < n; i++)
            {
                if (ct.compare(arr[i], arr[i - 1]) < 0)
                {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }
            if (!swapped)
            {
                break;
            }
            n--;
        }
    }

    /**
     * Sorts the array using the bubble sort algorithm.
     *
     * @param arr
     */
    public void bubbleSort(Comparable[] arr)
    {
        int n = arr.length;

        while (n > 1)
        {
            boolean swapped = false;
            for (int i = 1; i < n; i++)
            {
                if (arr[i].compareTo(arr[i - 1]) < 0)
                {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }
            if (!swapped)
            {
                break;
            }
            n--;
        }
    }

    /**
     * Swaps to elements in the given array.
     *
     * @param arr
     * @param posA
     * @param posB
     */
    private void swap(Object[] arr, int posA, int posB)
    {
        Object tmp = arr[posA];
        arr[posA] = arr[posB];
        arr[posB] = tmp;
    }

}
