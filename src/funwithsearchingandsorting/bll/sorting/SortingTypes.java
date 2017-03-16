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

    BUBBLE, INSERTION, SELECTION, MERGE, QUICK, BINARY_INSERTION;

    public static SortingTypes[] GetAll()
    {
        return new SortingTypes[]
        {
            SortingTypes.BUBBLE, SortingTypes.INSERTION, SortingTypes.SELECTION, SortingTypes.QUICK, SortingTypes.MERGE, SortingTypes.BINARY_INSERTION
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
            default:
                return "Unknown Sort";
        }
    }
}
