/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.arrayGen;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author stegg_000
 */
public class ArrayFactory
{
    
    public static int[] fillArray(int size, int minValue, int maxValue)
    {
        Random rnd = new Random();
        return fillArray(size, minValue, maxValue, rnd.nextInt());
    }
    
    public static int[] fillArray(int size, int minValue, int maxValue, int seed)
    {
        int[] tmp = new int[size];
        Random random = new Random(seed);
        for (int i = 0; i < size; i++)
        {
            tmp[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return tmp;
    }
    
    public static int[] fillSortedArray(int size, int minValue, int maxValue, int seed)
    {
        int[] tmp = fillArray(size, minValue, maxValue, seed);
        Arrays.parallelSort(tmp);
        return tmp;
    }
    
    public static int[] fillSortedArray(int size, int minValue, int maxValue)
    {
        Random rnd = new Random();
        return fillSortedArray(size, minValue, maxValue, rnd.nextInt());
    }
    
}
