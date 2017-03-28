/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.integers;

import funwithsearchingandsorting.bll.sorting.SortingAlgorithm;

/**
 *
 * @author pgn
 */
public abstract class IntSortStrategy
{

    /**
     * Factory method for the IntSortStrategy types.
     *
     * @param sortType
     * @return
     */
    public static IntSortStrategy getSort(SortingAlgorithm sortType)
    {
        switch (sortType)
        {
            case BUBBLE:
                return new BubbleSort();
            case INSERTION:
                return new InsertionSort();
            case SELECTION:
                return new SelectionSort();
            case QUICK:
                return new QuickSort();
            case MERGE:
                return new MergeSort();
            case BINARY_INSERTION:
                return new BinaryInsertionSort();
            case JAVA:
                return new JavaArraySort();
            case JAVA_PARALLEL:
                return new JavaParallelArraySort();
            default:
                throw new RuntimeException("Sort method " + sortType + " not yet implemented.");
        }
    }

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
