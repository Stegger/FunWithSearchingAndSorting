/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.facade;

import funwithsearchingandsorting.bll.arrayGen.ArrayFactory;
import funwithsearchingandsorting.bll.input.InputConverter;
import funwithsearchingandsorting.bll.sorting.SortingTypes;
import funwithsearchingandsorting.bll.sorting.integers.IntSortStrategy;
import funwithsearchingandsorting.bll.timer.MyTimer;
import funwithsearchingandsorting.bll.timer.SortTimer;

/**
 *
 * @author Stegger
 */
public class SortFacade
{

    public int[] getArrayLengthsFromInput(String txtArrSizes)
    {
        return InputConverter.getArrayLengthsFromInput(txtArrSizes);
    }

    public double getTimeToSort(SortingTypes sortType, int n)
    {
        return getTimeToSort(sortType, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public double getTimeToSort(SortingTypes sortType, int n, int minVal, int maxVal, int seed)
    {
        int[] target = ArrayFactory.fillArray(n, minVal, maxVal, seed);
        return new SortTimer().getTimeForSort(sortType, target);
    }

    public double getTimeToSort(SortingTypes sortType, int n, int minVal, int maxVal)
    {
        int[] target = ArrayFactory.fillArray(n, minVal, maxVal);
        return new SortTimer().getTimeForSort(sortType, target);
    }

    public SortingTypes[] getAllSortingTypes()
    {
        return SortingTypes.GetAll();
    }

}
