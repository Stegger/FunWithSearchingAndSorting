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
public class InsertionSort extends IntSortStrategy
{

    public InsertionSort()
    {
        super();
    }

    @Override
    public void sort(int[] data)
    {
        for (int i = 1; i < data.length; i++)
        {
            int j = i;
            while (j > 0 && data[j - 1] > data[j])
            {
                swap(data, j, j - 1);
                j--;
            }
        }
    }

    @Override
    public String toString()
    {
        return "Insertion Sort";
    }

}
