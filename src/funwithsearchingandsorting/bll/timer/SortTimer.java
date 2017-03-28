/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.timer;

import funwithsearchingandsorting.bll.sorting.SortingAlgorithm;
import funwithsearchingandsorting.bll.sorting.generic.GenericSort;
import funwithsearchingandsorting.bll.sorting.generic.GenericSortFactory;
import funwithsearchingandsorting.bll.sorting.integers.IntSortStrategy;

/**
 *
 * @author Stegger
 */
public class SortTimer
{

    public <T extends Comparable<? super T>> double getTimeForSort(SortingAlgorithm sortType, T[] target) throws InstantiationException, IllegalAccessException
    {
        GenericSort sortingAlgorithm = GenericSortFactory.getGenericSort(sortType);
        MyTimer timer = new MyTimer();
        timer.start();
        sortingAlgorithm.sort(target);
        timer.stop();
        return timer.getSeconds();
    }

    public double getTimeForSort(SortingAlgorithm sortType, int[] target)
    {
        IntSortStrategy sortingAlgorithm = IntSortStrategy.getSort(sortType);
        MyTimer timer = new MyTimer();
        timer.start();
        sortingAlgorithm.sort(target);
        timer.stop();
        return timer.getSeconds();
    }

}
