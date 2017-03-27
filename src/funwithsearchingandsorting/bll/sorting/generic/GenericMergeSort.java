///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package funwithsearchingandsorting.bll.sorting.generic;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
///**
// *
// * @author pgn
// */
//public class GenericMergeSort<T> extends GenericSort<T>
//{
//
//    @Override
//    public <T extends Comparable<? super T>> void sort(T[] data)
//    {
//        if (data.length > 1)
//        {
//            int q = data.length / 2;
//            T[] leftArray = Arrays.copyOfRange(data, 0, q);
//            T[] rightArray = Arrays.copyOfRange(data, q, data.length);
//            sort(leftArray);
//            sort(rightArray);
//            merge(data, leftArray, rightArray);
//        }
//    }
//
//    @Override
//    public void sort(T[] data, Comparator<? super T> c)
//    {
//        if (data.length > 1)
//        {
//            int q = data.length / 2;
//            T[] leftArray = Arrays.copyOfRange(data, 0, q);
//            T[] rightArray = Arrays.copyOfRange(data, q, data.length);
//            sort(leftArray, c);
//            sort(rightArray, c);
//            merge(data, leftArray, rightArray, c);
//        }
//    }
//
//    private void merge(T[] data, T[] left, T[] right, Comparator<? super T> c)
//    {
//        int totElem = left.length + right.length;
//        //int[] data = new int[totElem];
//        int i, li, ri;
//        i = li = ri = 0;
//        while (i < totElem)
//        {
//            // We add the smallest element, from the two subarrays, to the main array, one at a time:
//            if ((li < left.length) && (ri < right.length))
//            {
//                if (left[li] < right[ri])
//                {
//                    data[i] = left[li];
//                    i++;
//                    li++;
//                } else
//                {
//                    data[i] = right[ri];
//                    i++;
//                    ri++;
//                }
//            } else // We add any leftovers from the subarrays to the main array:
//            {
//                if (li >= left.length)
//                {
//                    while (ri < right.length)
//                    {
//                        data[i] = right[ri];
//                        i++;
//                        ri++;
//                    }
//                } else if (ri >= right.length)
//                {
//                    while (li < left.length)
//                    {
//                        data[i] = left[li];
//                        li++;
//                        i++;
//                    }
//                }
//            }
//        }
//    }
//
//}
