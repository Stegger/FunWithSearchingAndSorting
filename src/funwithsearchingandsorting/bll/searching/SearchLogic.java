/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.searching;

/**
 *
 * @author stegg_000
 */
public class SearchLogic
{

    /**
     * Return the index of the first occurrence of the key value in the array b.
     * If the key value is not in the array b, -1 is returned.
     *
     * @param key The int to search for.
     * @param b The array to search in.
     * @return The index of the first occurence of key, or -1 if there are no
     * occurences.
     */
    public int findFirst(int key, int[] b)
    {
        for (int i = 0; i < b.length; i++)
        {
            if (b[i] == key)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Return the index of the last occurrence of the key value in the array b.
     * If the key value is not in the array b, -1 is returned.
     *
     * @param key The key to search for.
     * @param b The array to search in.
     * @return The last occurence of key, or -1 if there are no occurences.
     */
    public int findLast(int key, int[] b)
    {
        for (int i = b.length - 1; i >= 0; i--)
        {
            if (b[i] == key)
            {
                return i;
            }
        }
        return -1;
    }

    public int rangeBinarySearch(int[] data, int low, int high, int value)
    {
        if (low <= high)
        {
            int mid = (low + high) / 2;
            if (data[mid] == value)
            {
                return mid;
            }
            else if (data[mid] < value)
            {
                return rangeBinarySearch(data, mid + 1, high, value);
            }
            else
            {
                return rangeBinarySearch(data, low, mid - 1, value);
            }
        }
        else
        {
            return -1 - low;
        }
    }

    /**
     * Return the index of the first occurrence of the key value in the array b.
     * If the key value is not in the array b, -1 is returned. The array must be
     * sorted.
     *
     * @param key The value to search for.
     * @param b The array to search in.
     * @return The index of the first occurence of key, or -1 if there are no
     * occurences.
     */
    public int binSearch(int key, int[] b)
    /**
     * pre: The array is sorted 
     * post: Returns the index of the key value, if the
     * key value is found in the array b, otherwise return -1.
     */
    {
        int first, middle, last;
        first = 0;
        last = b.length - 1;
        while (first < last)
        {
            middle = last + (first - last) / 2;

            if (b[middle] == key)
            {
                return middle;
            }
            else if (key < b[middle])
            {
                last = middle;
            }
            else
            {
                first = middle + 1;
            }
        }
        return -1;
    }

    /**
     *
     * @param key
     * @param b
     * @return
     */
    public int binFindFirst(int key, int[] b)
    /**
     * pre: The array is sorted post: Returns the index of the first occurrence
     * of the key value, if the key value is found in the array b, otherwise
     * return -1.
     */
    {
        int first, middle, last;
        first = 0;
        last = b.length - 1;
        while (first < last)
        {
            middle = (last + first) / 2;

            if (b[middle] >= key)
            {
                last = middle;
            }
            else
            {
                first = middle + 1;
            }
        }
        return (b[first] == key ? first : -1);
    }

    public int binFindLast(int key, int[] b)
    /**
     * pre: The array is sorted post: Returns the index of the last occurrence
     * of the key value, if the key value is found in the array b, otherwise
     * return -1.
     */
    {
        int first, middle, last;
        first = 0;
        last = b.length - 1;
        while (first < last)
        {
            //A more elegant middle calculation where I round up if need be:
            middle = (last + first) / 2 + ((last + first) % 2 == 0 ? 0 : 1);

            if (b[middle] <= key)
            {
                first = middle;
            }
            else
            {
                last = middle - 1;
            }
        }
        return (b[first] == key ? last : -1);
    }

}
