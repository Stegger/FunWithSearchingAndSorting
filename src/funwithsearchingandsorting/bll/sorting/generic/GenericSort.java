/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.generic;

/**
 *
 * @author pgn
 * @param <T>
 */
public abstract class GenericSort<T extends Comparable<T>>
{

    public abstract void sort(T[] data);

    /**
     * Swaps the elements at position a and b in the array data.
     *
     * @param data the array to swap elements in.
     * @param a    index of the first element.
     * @param b    index of the second element.
     */
    protected void swap(T[] data, int a, int b)
    {
        T tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

}
