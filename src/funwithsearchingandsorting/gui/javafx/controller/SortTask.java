/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.controller;

import funwithsearchingandsorting.bll.facade.SortFacade;
import funwithsearchingandsorting.bll.sorting.DataType;
import funwithsearchingandsorting.bll.sorting.SortingAlgorithm;
import javafx.concurrent.Task;

/**
 *
 * @author Stegger
 */
public class SortTask extends Task<Double>
{

    private SortFacade sortFacade;
    private SortingAlgorithm sortType;
    private int n, minVal, maxVal, seed;
    private DataType dataType;

    public SortTask(SortFacade sortFacade, SortingAlgorithm sortType, int n, int minVal, int maxVal, DataType dataType, int seed)
    {
        this.sortFacade = sortFacade;
        this.sortType = sortType;
        this.n = n;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.seed = seed;
        this.dataType = dataType;
    }

    public SortTask(SortFacade sortFacade, SortingAlgorithm sortType, int n, int minVal, int maxVal, DataType dataType)
    {
        this(sortFacade, sortType, n, minVal, maxVal, dataType, 0);
    }

    @Override
    protected Double call() throws Exception
    {
        if (seed != 0)
        {
            return sortFacade.getTimeToSort(sortType, n, minVal, maxVal, dataType);
        }
        else
        {
            return sortFacade.getTimeToSort(sortType, n, minVal, maxVal, dataType, seed);
        }
    }

}
