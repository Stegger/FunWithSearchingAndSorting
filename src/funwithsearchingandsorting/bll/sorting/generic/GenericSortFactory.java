/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.generic;

import funwithsearchingandsorting.bll.sorting.SortingAlgorithm;

/**
 *
 * @author pgn
 */
public class GenericSortFactory
{

    public static GenericSort getGenericSort(SortingAlgorithm type) throws InstantiationException, IllegalAccessException
    {
        switch (type)
        {
            case BUBBLE:
                return new GenericBubbleSort();
            case BINARY_INSERTION:
                return new GenericBinaryInsertionSort();
            case INSERTION:
                return new GenericInsertionSort();
            case JAVA:
                return new GenericJavaSort();
            case JAVA_PARALLEL:
                return new GenericParallelJavaSort();
            case MERGE:
                return new GenericMergeSort();
            case QUICK:
                return new GenericQuickSort();
            case SELECTION:
                return new GenericSelectionSort();
            default:
                throw new IllegalArgumentException("Sort type \"" + type.name() + "\" not implemented yet.");
        }
    }

}
