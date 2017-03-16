/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll;

import funwithsearchingandsorting.bll.timer.MyTimer;
import funwithsearchingandsorting.bll.arrayGen.ArrayFactory;
import funwithsearchingandsorting.bll.sorting.ArraySorting;
import java.util.HashMap;

/**
 *
 * @author stegg_000
 */
public class SortingAlgoTester
{

    public static void findOptimalThresholdQuickSortInsertionSort()
    {
        ArraySorting as = new ArraySorting();
        MyTimer timer = new MyTimer();
        HashMap<Integer, Long> sizeBestThreshTime = new HashMap<>();
        HashMap<Integer, Integer> sizeBestThreshVal = new HashMap<>();

        for (int i = 10000; i <= 1280000; i = i * 2)
        {
            for (int thresh = 0; thresh <= 100; thresh++)
            {
                long avg = 0;
                for (int j = 1; j <= 10; j++)
                {
                    int[] arr = ArrayFactory.fillArray(i, 1, 100000);
                    timer.reset();
                    timer.start();
                    as.quickSortInsertionThresh(arr, 0, arr.length - 1, thresh);
                    timer.stop();
                    avg = (avg * (j - 1) + timer.getNanoseconds()) / j;
                }
                long currentBest = sizeBestThreshTime.getOrDefault(i, new Long(Long.MAX_VALUE));
                if (avg < currentBest)
                {
                    sizeBestThreshTime.put(i, avg);
                    sizeBestThreshVal.put(i, thresh);
                }
            }
            System.out.println("For size = " + i + " best thresh was " + sizeBestThreshVal.get(i));
        }

        int avgThresh = 0;
        int c = 0;
        for (int size : sizeBestThreshVal.keySet())
        {

            avgThresh = (avgThresh * c + sizeBestThreshVal.get(size)) / (c + 1);
            c++;
        }
        System.out.println("Best thresh = " + avgThresh);
    }

    public static void main(String[] args)
    {
        SortingAlgoTester.findOptimalThresholdQuickSortInsertionSort();
    }

}
