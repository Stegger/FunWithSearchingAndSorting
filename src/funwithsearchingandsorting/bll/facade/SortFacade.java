/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.facade;

import funwithsearchingandsorting.be.Account;
import funwithsearchingandsorting.bll.arrayGen.AccountArrayGenerator;
import funwithsearchingandsorting.bll.arrayGen.ArrayFactory;
import funwithsearchingandsorting.bll.input.InputConverter;
import funwithsearchingandsorting.bll.sorting.DataType;
import funwithsearchingandsorting.bll.sorting.SortingAlgorithm;
import funwithsearchingandsorting.bll.timer.SortTimer;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public double getTimeToSort(SortingAlgorithm sortType, int n, DataType dataType)
    {
        return getTimeToSort(sortType, n, Integer.MIN_VALUE, Integer.MAX_VALUE, dataType);
    }

    public double getTimeToSort(SortingAlgorithm sortType, int n, int minVal, int maxVal, DataType dataType, int seed)
    {
        if (dataType == DataType.INT)
        {
            int[] target = ArrayFactory.fillArray(n, minVal, maxVal, seed);
            return new SortTimer().getTimeForSort(sortType, target);
        }
        else if (dataType == DataType.GENERIC_OBJECT)
        {
            try
            {
                Account[] target = AccountArrayGenerator.fillArray(n, minVal, maxVal, seed);
                return new SortTimer().getTimeForSort(sortType, target);
            } catch (Exception ex)
            {
                throw new RuntimeException("Could not create or sort Account array.", ex);
            }
        }
        else
        {
            throw new IllegalArgumentException("Unknown datatype. Can only sort Accounts and integers.");
        }
    }

    public double getTimeToSort(SortingAlgorithm sortType, int n, int minVal, int maxVal, DataType dataType)
    {
        if (dataType == DataType.INT)
        {
            int[] target = ArrayFactory.fillArray(n, minVal, maxVal);
            return new SortTimer().getTimeForSort(sortType, target);
        }
        else if (dataType == DataType.GENERIC_OBJECT)
        {
            try
            {
                Account[] target = AccountArrayGenerator.fillArray(n, minVal, maxVal);
                return new SortTimer().getTimeForSort(sortType, target);
            } catch (Exception ex)
            {
                throw new RuntimeException("Could not create or sort Account array.", ex);
            }
        }
        else
        {
            throw new IllegalArgumentException("Unknown datatype. Can only sort Accounts and integers.");
        }
    }

    public SortingAlgorithm[] getAllSortingTypes()
    {
        return SortingAlgorithm.GetAll();
    }

}
