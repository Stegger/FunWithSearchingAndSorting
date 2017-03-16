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
public class BubbleSort extends IntSortStrategy
{

    public BubbleSort()
    {
        super();
    }

    @Override
    public void sort(int[] data)
    {
        int n = data.length;

        while (n > 1)
        {
            boolean swapped = false;
            for (int i = 1; i < n; i++)
            {

                if (data[i] < data[i - 1])
                {
                    swap(data, i, i - 1);
                    swapped = true;
                }
            }
            if (!swapped)
            {
                break;
            }
            n--;
        }
    }

    @Override
    public String toString()
    {
        return "Bubble Sort";
    }

}
