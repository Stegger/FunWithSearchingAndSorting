/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting;

/**
 *
 * @author Stegger
 */
public enum SortingAlgorithm
{

    BUBBLE, INSERTION, SELECTION, MERGE, QUICK, BINARY_INSERTION, JAVA, JAVA_PARALLEL;

    public static SortingAlgorithm[] GetAll()
    {
        return new SortingAlgorithm[]
        {
            SortingAlgorithm.BUBBLE, SortingAlgorithm.INSERTION, SortingAlgorithm.SELECTION, SortingAlgorithm.BINARY_INSERTION, SortingAlgorithm.QUICK, SortingAlgorithm.MERGE, SortingAlgorithm.JAVA, SortingAlgorithm.JAVA_PARALLEL
        };
    }

    @Override
    public String toString()
    {
        switch (this)
        {
            case BUBBLE:
                return "Bubble Sort";
            case INSERTION:
                return "Insertion Sort";
            case MERGE:
                return "Merge Sort";
            case QUICK:
                return "Quick Sort";
            case SELECTION:
                return "Selection Sort";
            case BINARY_INSERTION:
                return "Binary Insertion Sort";
            case JAVA:
                return "Java Sort";
            case JAVA_PARALLEL:
                return "Java Parallel Sort";
            default:
                return "Unknown Sort";
        }
    }
}
