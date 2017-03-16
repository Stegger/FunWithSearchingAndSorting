/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.integers;

/**
 *
 * @author pgn
 */
public class SelectionSort extends IntSortStrategy
{

    public SelectionSort()
    {
        super();
    }

    @Override
    public void sort(int[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            int min = i;
            int j = i + 1;
            while (j < data.length)
            {
                if (data[j] < data[min])
                {
                    min = j;
                }
                j++;
            }
            swap(data, min, i);
        }
    }

    @Override
    public String toString()
    {
        return "Selection Sort";
    }
    
    

}
