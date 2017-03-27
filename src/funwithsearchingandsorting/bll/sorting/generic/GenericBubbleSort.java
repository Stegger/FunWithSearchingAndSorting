/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.generic;

import funwithsearchingandsorting.bll.sorting.SortingTypes;
import java.util.Comparator;

/**
 *
 * @author pgn
 * @param <T>
 */
public class GenericBubbleSort<T> extends GenericSort<T>
{

    @Override
    public <T extends Comparable<? super T>> void sort(T[] data)
    {
        int n = data.length;

        while (n > 1)
        {
            boolean swapped = false;
            for (int i = 1; i < n; i++)
            {

                if (data[i].compareTo(data[i - 1]) < 0)
                {
                    swap(data, i, i - 1);
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

    @Override
    public void sort(T[] data, Comparator<? super T> c)
    {
        int n = data.length;

        while (n > 1)
        {
            boolean swapped = false;
            for (int i = 1; i < n; i++)
            {

                if (c.compare(data[i], data[i - 1]) < 0)
                {
                    swap(data, i, i - 1);
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

}
