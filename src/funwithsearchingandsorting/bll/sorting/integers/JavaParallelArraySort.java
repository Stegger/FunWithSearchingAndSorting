/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.integers;

import java.util.Arrays;

/**
 *
 * @author Stegger
 */
public class JavaParallelArraySort extends IntSortStrategy
{
    
    @Override
    public void sort(int[] data)
    {
        Arrays.parallelSort(data);
    }
    
}
