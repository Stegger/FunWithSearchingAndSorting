/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.sorting.generic;

import funwithsearchingandsorting.be.Account;
import funwithsearchingandsorting.bll.sorting.SortingTypes;
import java.util.HashMap;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author pgn
 */
public class GenericSortFactory
{

    public static <T> GenericSort<T> getGenericSort(SortingTypes type) throws InstantiationException, IllegalAccessException
    {
        switch (type)
        {
            case BUBBLE:
                return new GenericBubbleSort<T>();
            default:
                throw new IllegalArgumentException("Sort type \"" + type.name() + "\" not implemented yet.");
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException
    {
        System.out.println("test101");

        GenericSort<Account> sorter = GenericSortFactory.getGenericSort(SortingTypes.BUBBLE);
        
        Account[] accs = new Account[]
        {
            new Account(2, 100, "Savings"), new Account(1, -10000, "Checkings")
        };

        sorter.sort(accs);

        for (Account acc : accs)
        {
            System.out.println("Nr: " + acc.getAccNr() + ", Balance: " + acc.getBalance() + ", name: " + acc.getName());
        }

    }

}
