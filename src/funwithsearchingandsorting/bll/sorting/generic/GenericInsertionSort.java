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
public class GenericInsertionSort extends GenericSort
{

    @Override
    public <T> void sort(T[] data, Comparator<? super T> c)
    {
        for (int i = 1; i < data.length; i++)
        {
            int j = i;
            while (j > 0 && c.compare(data[j - 1], data[j]) > 0)
            {
                swap(data, j, j - 1);
                j--;
            }
        }
    }

}
