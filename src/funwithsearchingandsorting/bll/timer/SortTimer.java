/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.timer;

import funwithsearchingandsorting.bll.sorting.SortingTypes;
import funwithsearchingandsorting.bll.sorting.integers.IntSortStrategy;

/**
 *
 * @author Stegger
 */
public class SortTimer
{

    public double getTimeForSort(SortingTypes sortType, int[] target)
    {
        IntSortStrategy sortingAlgorithm = IntSortStrategy.getSort(sortType);
        MyTimer timer = new MyTimer();
        timer.start();
        sortingAlgorithm.sort(target);
        timer.stop();
        return timer.getSeconds();
    }

}
