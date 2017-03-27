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
public enum SortingTypes
{

    BUBBLE, INSERTION, SELECTION, MERGE, QUICK, BINARY_INSERTION, JAVA_ARRAY, JAVA_ARRAY_PARALLEL;

    public static SortingTypes[] GetAll()
    {
        return new SortingTypes[]
        {
            SortingTypes.BUBBLE, SortingTypes.INSERTION, SortingTypes.SELECTION, SortingTypes.BINARY_INSERTION, SortingTypes.QUICK, SortingTypes.MERGE, SortingTypes.JAVA_ARRAY, SortingTypes.JAVA_ARRAY_PARALLEL
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
            case JAVA_ARRAY:
                return "Java Arrays Sort";
            case JAVA_ARRAY_PARALLEL:
                return "Java Arrays Parallel Sort";
            default:
                return "Unknown Sort";
        }
    }
}
