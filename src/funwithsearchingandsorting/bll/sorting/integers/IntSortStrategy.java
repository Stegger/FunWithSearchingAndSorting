/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.integers;

/**
 *
 * @author pgn
 */
public abstract class IntSortStrategy
{

    public abstract void sort(int[] data);

    /**
     * Swaps to elements in the given array.
     *
     * @param arr
     * @param posA
     * @param posB
     */
    public void swap(int[] arr, int posA, int posB)
    {
        int tmp = arr[posA];
        arr[posA] = arr[posB];
        arr[posB] = tmp;
    }

}
