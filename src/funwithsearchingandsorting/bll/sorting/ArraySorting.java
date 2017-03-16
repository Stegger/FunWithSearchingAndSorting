/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting;

import funwithsearchingandsorting.bll.searching.SearchLogic;
import java.util.Arrays;

/**
 *
 * @author stegg_000
 */
public class ArraySorting
{

    private final int QUICKSORT_INSERTION_THRESHOLD = 14;
    private final int MERGESORT_INSERTION_THRESHOLD = 32; //Untested

    ///
    /// Java's built in sort
    ///
    public void javaSort(int[] arr)
    {
        Arrays.sort(arr);
    }

    public void parallelJavaSort(int[] arr)
    {
        Arrays.parallelSort(arr);
    }

    ///
    /// Bubble Sort
    ///
    /**
     * Sorts the array using the bubble sort algorithm.
     *
     * @param arr
     */
    public void bubbleSort(int[] arr)
    {
        int n = arr.length;

        while (n > 1)
        {
            boolean swapped = false;
            for (int i = 1; i < n; i++)
            {

                if (arr[i] < arr[i - 1])
                {
                    swap(arr, i, i - 1);
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

    ///
    /// Selection Sort
    ///
    /**
     * Sorts the array using the selection sort algorithm.
     *
     * @param arr
     */
    public void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int min = i;
            int j = i + 1;
            while (j < arr.length)
            {
                if (arr[j] < arr[min])
                {
                    min = j;
                }
                j++;
            }
            swap(arr, min, i);
        }
    }

    ///
    /// Insertion Sort
    ///
    /**
     * Sorts the array using the insertion sort algorithm.
     *
     * @param arr
     */
    public void binaryInsertionSort(int[] arr)
    {
        SearchLogic sl = new SearchLogic();
        for (int i = 1; i < arr.length; i++)
        {
            int val = arr[i]; // I store the value I'm currently at.
            int pos = sl.rangeBinarySearch(arr, 0, i - 1, val); // I find its position in the already sorted array.
            pos = (pos >= 0) ? pos : -(pos + 1); // I normalize the position to an inbound index
            shiftRightFrom(arr, pos, i); // I shift all elements to the right to make room for my i value
            arr[pos] = val; // I insert the value into the position
        }
    }

    private void shiftRightFrom(int[] arr, int low, int high)
    {
        for (int j = high; j > low && j > 0; j--)
        {
            arr[j] = arr[j - 1];
        }
    }

    ///
    /// Insertion Sort
    ///
    /**
     * Sorts the array using the insertion sort algorithm.
     *
     * @param arr
     */
    public void insertionSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j])
            {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    ///
    /// MergeSort
    ///
    /**
     * Sorts the given array using the merge sort algorithm.
     *
     * @param arr
     */
    public void mergeSort(int[] arr)
    {
        if (arr.length > 1)
        {
            int q = arr.length / 2;
            int[] leftArray = Arrays.copyOfRange(arr, 0, q);
            int[] rightArray = Arrays.copyOfRange(arr, q, arr.length);
            mergeSort(leftArray);
            mergeSort(rightArray);
            merge(arr, leftArray, rightArray);
        }
    }

    private void merge(int[] arr, int[] left, int[] right)
    {
        int totElem = left.length + right.length;
        //int[] arr = new int[totElem];
        int i, li, ri;
        i = li = ri = 0;
        while (i < totElem)
        {
            // We add the smallest element, from the two subarrays, to the main array, one at a time:
            if ((li < left.length) && (ri < right.length))
            {
                if (left[li] < right[ri])
                {
                    arr[i] = left[li];
                    i++;
                    li++;
                }
                else
                {
                    arr[i] = right[ri];
                    i++;
                    ri++;
                }
            }
            else
            {
                // We add any leftovers from the subarrays to the main array:
                if (li >= left.length)
                {
                    while (ri < right.length)
                    {
                        arr[i] = right[ri];
                        i++;
                        ri++;
                    }
                }
                else if (ri >= right.length)
                {
                    while (li < left.length)
                    {
                        arr[i] = left[li];
                        li++;
                        i++;
                    }
                }
            }
        }
    }

    ///
    /// Quicksort methods:
    ///
    /**
     * Sorts the given array using the quick sort algorithm.
     *
     * @param arr
     */
    public void quicksort(int[] arr)
    {
        if (arr == null || arr.length < 1)
        {
            return;
        }
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            if (high - low > QUICKSORT_INSERTION_THRESHOLD)
            {
                int p = partition(arr, low, high);
                quicksort(arr, low, p);
                quicksort(arr, p + 1, high);
            }
            else //Insertion sort:
            {
                InsertionSortInterval(low, high, arr);
            }
        }
    }

    private void InsertionSortInterval(int low, int high, int[] arr)
    {
        for (int i = low + 1; i <= high; i++)
        {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j])
            {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public void quickSortInsertionThresh(int[] arr, int low, int high, int thresh)
    {
        if (low < high)
        {
            if (high - low > thresh)
            {
                int p = partition(arr, low, high);
                quickSortInsertionThresh(arr, low, p, thresh);
                quickSortInsertionThresh(arr, p + 1, high, thresh);
            }
            else //Insertion sort:
            {
                for (int i = low + 1; i <= high; i++)
                {
                    int j = i;
                    while (j > 0 && arr[j - 1] > arr[j])
                    {
                        swap(arr, j, j - 1);
                        j--;
                    }
                }
            }
        }
    }

    private int partition(int[] arr, int low, int high)
    {
        int pivot = (arr[low] + arr[high] + arr[low + (high - low) / 2]) / 3;
        int i = low - 1;
        int j = high + 1;

        // Vi looper uendeligt som udgangspunkt...
        while (true)
        {
            do
            {
                i++;
                // Så længe i er "in bounds" og mindre end vores pivot.
            } while (i < high && arr[i] < pivot);

            do
            {
                j--;
            } while (j > low && arr[j] > pivot); // Så længe j er "in bounds" og større end vores pivot.

            if (i < j)
            {// Hvis ikke vi har krydset møde punktet mellem low og high, aka. vi har traverseret en hel partition af arrayet!
                swap(arr, i, j); //Når vi herind er der uorden i vores partition og i og j skal swappes!
            }
            else
            {// Hvis !(i<j) så har vi været igennem hele partitionen af arrayet og vi kan nu returnere skille punktet imellem den store og lille halvdel:
                return j;
            }
        }
    }

    ///
    /// Shared utility methods:
    ///
    /**
     * Swaps to elements in the given array.
     *
     * @param arr
     * @param posA
     * @param posB
     */
    private void swap(int[] arr, int posA, int posB)
    {
        int tmp = arr[posA];
        arr[posA] = arr[posB];
        arr[posB] = tmp;
    }

    /**
     * Reverses the given array's elements.
     *
     * @param arr
     */
    public void reverse(int[] arr)
    {
        for (int i = 0; i < arr.length / 2; i++)
        {
            swap(arr, i, arr.length - 1 - i);
        }
    }

    /**
     * Tests if the array is sorted.
     *
     * @param arr
     * @return
     */
    public boolean isSorted(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] < arr[i - 1])
            {
                return false;
            }
        }
        return true;
    }

    ///
    /// HeapSort methods:
    ///
    /**
     * Sorts the given array using the heap sort algorithm.
     *
     * @param arr
     */
    public void heapSort(int[] arr)
    {
        heapify(arr, arr.length);
        int end = arr.length - 1;
        while (end > 0)
        {
            swap(arr, 0, end);
            end--;
            siftDown(arr, 0, end);
        }
    }

    private void heapify(int[] arr, int count)
    {
        int parent = getParentIndex(count - 1); //Find the largest parent in the array.

        while (parent >= 0) //While we are looking at a parent in range!
        {
            siftDown(arr, parent, count - 1);
            parent--;
        }

    }

    private void siftDown(int[] arr, int start, int end)
    {
        int root = start; //We name the beginning element as the root of the subtree we are ordering.
        while (getLeftChildIndex(root) <= end) //While we are looking at children that are in range
        {
            int child = getLeftChildIndex(root);
            int swap = root; //We store the target index to swap with. We assume we should swap with the child.
            if (arr[swap] < arr[child]) //We check if the left child is a candidate to swap
            {
                swap = child;
            }
            if (child + 1 <= end && arr[swap] < arr[child + 1]) // We evaluate the right child for swapness compared to left child...
            {
                swap = child + 1; //If the right child is larger, we swap with that!
            }
            if (swap == root)
            {
                return; //If we do not need to swap, we end the sifting.
            }
            else
            {
                swap(arr, root, swap);
                root = swap; //Since we swapped, we must now examine the subarray under the swapped index.
            }
        }
    }

    private int getRightChildIndex(int i)
    {
        return 2 * i + 2;
    }

    private int getLeftChildIndex(int i)
    {
        return 2 * i + 1;
    }

    private int getParentIndex(int i)
    {
        return ((i - 1) / 2);
    }

}
