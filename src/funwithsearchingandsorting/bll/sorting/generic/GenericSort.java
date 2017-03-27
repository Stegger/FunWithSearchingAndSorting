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
 * @param <T>
 */
public abstract class GenericSort<T>
{
    

    public abstract <T extends Comparable<? super T>> void sort(T[] data);

    public abstract void sort(T[] data, Comparator<? super T> c);

    /**
     * Swaps the elements at position a and b in the array data.
     *
     * @param data the array to swap elements in.
     * @param a    index of the first element.
     * @param b    index of the second element.
     */
    protected void swap(Object[] data, int a, int b)
    {
        Object tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

}
