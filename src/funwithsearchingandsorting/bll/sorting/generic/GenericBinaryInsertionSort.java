/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.generic;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Stegger
 */
public class GenericBinaryInsertionSort extends GenericSort
{

    @Override
    public <T> void sort(T[] data, Comparator<? super T> c)
    {
        for (int i = 1; i < data.length; i++)
        {
            T val = data[i];                                   // I store the value I'm currently at.
            int pos = Arrays.binarySearch(data, 0, i - 1, val, c); // I find its position in the already sorted array.
            pos = (pos >= 0) ? pos : -(pos + 1);                // I normalize the position to an inbound index
            shiftRightFrom(data, pos, i);                        // I shift all elements to the right to make room for my i value
            data[pos] = val;                                     // I insert the value into the position
        }
    }

    private <T> void shiftRightFrom(T[] arr, int low, int high)
    {
        for (int j = high; j > low && j > 0; j--)
        {
            arr[j] = arr[j - 1];
        }
    }

}
