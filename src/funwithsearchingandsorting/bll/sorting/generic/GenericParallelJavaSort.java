/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.generic;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Stegger
 */
public class GenericParallelJavaSort extends GenericSort
{
    
    @Override
    public <T> void sort(T[] data, Comparator<? super T> c)
    {
        Arrays.parallelSort(data, c);
    }
    
}
