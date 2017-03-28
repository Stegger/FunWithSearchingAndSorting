/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.generic;

import java.util.Comparator;

/**
 *
 * @author pgn
 */
public abstract class GenericSort
{

    /**
     * Sorts the array using the Comparable interface.
     *
     * @param <T> The type of data.
     * @param data The Collection of data.
     */
    public <T extends Comparable<? super T>> void sort(T[] data)
    {
        Comparator<T> comparableComparator = new Comparator<T>()
        {
            @Override
            public int compare(T o1, T o2)
            {
                return o1.compareTo(o2);
            }
        };
        sort(data, comparableComparator);
    }

    /**
     * Sorts the array using the given comparator.
     *
     * @param <T> The type of the data.
     * @param data The array to sort.
     * @param c The comparator used for sortiing.
     */
    public abstract <T> void sort(T[] data, Comparator<? super T> c);

    /**
     * Swaps the elements at position a and b in the array data.
     *
     * @param data the array to swap elements in.
     * @param a index of the first element.
     * @param b index of the second element.
     */
    protected void swap(Object[] data, int a, int b)
    {
        Object tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

}
