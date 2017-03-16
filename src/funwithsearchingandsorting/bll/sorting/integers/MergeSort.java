/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.integers;

import java.util.Arrays;

/**
 *
 * @author Stegger
 */
public class MergeSort extends IntSortStrategy
{

    @Override
    public void sort(int[] data)
    {
        if (data.length > 1)
        {
            int q = data.length / 2;
            int[] leftArray = Arrays.copyOfRange(data, 0, q);
            int[] rightArray = Arrays.copyOfRange(data, q, data.length);
            sort(leftArray);
            sort(rightArray);
            merge(data, leftArray, rightArray);
        }
    }

    private void merge(int[] arr, int[] left, int[] right)
    {
        int totElem = left.length + right.length;
        //int[] arr = new int[totElem];
        int i, li, ri;
        i = li = ri = 0;
        while (i < totElem)
        {
            // We add the smallest element, from the two subarrays, to the main array, one at a time:
            if ((li < left.length) && (ri < right.length))
            {
                if (left[li] < right[ri])
                {
                    arr[i] = left[li];
                    i++;
                    li++;
                }
                else
                {
                    arr[i] = right[ri];
                    i++;
                    ri++;
                }
            }
            else
            {
                // We add any leftovers from the subarrays to the main array:
                if (li >= left.length)
                {
                    while (ri < right.length)
                    {
                        arr[i] = right[ri];
                        i++;
                        ri++;
                    }
                }
                else if (ri >= right.length)
                {
                    while (li < left.length)
                    {
                        arr[i] = left[li];
                        li++;
                        i++;
                    }
                }
            }
        }
    }

}
