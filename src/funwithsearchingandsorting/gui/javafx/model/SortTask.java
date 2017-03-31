/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.model;

import funwithsearchingandsorting.bll.facade.SortFacade;
import funwithsearchingandsorting.bll.sorting.DataType;
import funwithsearchingandsorting.bll.sorting.SortingAlgorithm;
import java.util.concurrent.Callable;

/**
 *
 * @author Stegger
 */
public class SortTask implements Callable<SortTask>
{

    private SortFacade sortFacade;
    private SortingAlgorithm sortType;
    private int n, minVal, maxVal, seed;
    private DataType dataType;
    private Double timeToSort;

    public SortTask(SortFacade sortFacade, SortingAlgorithm sortType, int n, int minVal, int maxVal, DataType dataType, int seed)
    {
        this.sortFacade = sortFacade;
        this.sortType = sortType;
        this.n = n;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.seed = seed;
        this.dataType = dataType;
        timeToSort = 0.0;
    }

    public SortTask(SortFacade sortFacade, SortingAlgorithm sortType, int n, int minVal, int maxVal, DataType dataType)
    {
        this(sortFacade, sortType, n, minVal, maxVal, dataType, 0);
    }

    @Override
    public SortTask call() throws Exception
    {
        if (seed != 0)
        {
            timeToSort = sortFacade.getTimeToSort(getSortType(), getN(), minVal, maxVal, dataType);
        } else
        {
            timeToSort = sortFacade.getTimeToSort(getSortType(), getN(), minVal, maxVal, dataType, seed);
        }
        return this;
    }

    /**
     * @return the sortType
     */
    public SortingAlgorithm getSortType()
    {
        return sortType;
    }

    /**
     * @return the n
     */
    public int getN()
    {
        return n;
    }

    public Double getTimeToSort()
    {
        return timeToSort;
    }

}
