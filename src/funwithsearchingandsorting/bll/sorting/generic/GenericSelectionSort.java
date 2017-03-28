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
public class GenericSelectionSort extends GenericSort
{

    @Override
    public <T> void sort(T[] data, Comparator<? super T> c)
    {
        for (int i = 0; i < data.length; i++)
        {
            int min = i;
            int j = i + 1;
            while (j < data.length)
            {
                if (c.compare(data[j], data[min]) < 0)
                {
                    min = j;
                }
                j++;
            }
            swap(data, min, i);
        }
    }

}
