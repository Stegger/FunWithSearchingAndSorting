/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.integers;

import funwithsearchingandsorting.bll.searching.SearchLogic;

/**
 *
 * @author Stegger
 */
public class BinaryInsertionSort extends IntSortStrategy
{

    @Override
    public void sort(int[] data)
    {
        SearchLogic sl = new SearchLogic();
        for (int i = 1; i < data.length; i++)
        {
            int val = data[i];                                   // I store the value I'm currently at.
            int pos = sl.rangeBinarySearch(data, 0, i - 1, val); // I find its position in the already sorted array.
            pos = (pos >= 0) ? pos : -(pos + 1);                // I normalize the position to an inbound index
            shiftRightFrom(data, pos, i);                        // I shift all elements to the right to make room for my i value
            data[pos] = val;                                     // I insert the value into the position
        }
    }

    private void shiftRightFrom(int[] arr, int low, int high)
    {
        for (int j = high; j > low && j > 0; j--)
        {
            arr[j] = arr[j - 1];
        }
    }

}
