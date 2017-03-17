/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.controller;

import funwithsearchingandsorting.bll.facade.SortFacade;
import funwithsearchingandsorting.bll.sorting.SortingTypes;
import javafx.concurrent.Task;

/**
 *
 * @author Stegger
 */
public class SortTask extends Task<Double>
{

    private SortFacade sortFacade;
    private SortingTypes sortType;
    private int n, minVal, maxVal, seed;

    public SortTask(SortFacade sortFacade, SortingTypes sortType, int n, int minVal, int maxVal, int seed)
    {
        this.sortFacade = sortFacade;
        this.sortType = sortType;
        this.n = n;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.seed = seed;
    }

    public SortTask(SortFacade sortFacade, SortingTypes sortType, int n, int minVal, int maxVal)
    {
        this(sortFacade, sortType, n, minVal, maxVal, 0);
    }

    @Override
    protected Double call() throws Exception
    {
        if (seed != 0)
        {
            return sortFacade.getTimeToSort(sortType, n, minVal, maxVal);
        } else
        {
            return sortFacade.getTimeToSort(sortType, n, minVal, maxVal, seed);
        }
    }

}
