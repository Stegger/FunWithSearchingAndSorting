/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll;

import funwithsearchingandsorting.be.Account;
import funwithsearchingandsorting.bll.timer.MyTimer;
import funwithsearchingandsorting.bll.arrayGen.ArrayFactory;
import funwithsearchingandsorting.bll.comparators.AccountAmountComparator;
import funwithsearchingandsorting.bll.sorting.ArraySorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author stegg_000
 */
public class SortingAlgoTester
{

    public static void FunWithJavasSort()
    {
        Account[] accounts_one = new Account[]
        {
            new Account(2, 5000, "Personal"), new Account(1, -100, "Checking"), new Account(3, 0, "Savings")
        };

        Arrays.sort(accounts_one);
        Arrays.sort(accounts_one, new AccountAmountComparator());

//        for (Account account : accounts_one)
//        {
//            System.out.println(account.getAccNr() + ": " + account.getName() + " - " + account.getBalance() + "$");
//        }


        ArrayList<Account> accounts_two = new ArrayList<>();
        accounts_two.add(new Account(4, 100000, "Savings"));
        accounts_two.add(new Account(5, -1500, "Checking"));
        accounts_two.add(new Account(9, -15900, "Checking"));
        accounts_two.add(new Account(6, -159, "Checking"));
        accounts_two.add(new Account(7, 500, "Savings"));

        Collections.sort(accounts_two, Account.NameAndAmountComparator);

        for (Account account : accounts_two)
        {
            System.out.println(account.getAccNr() + ": " + account.getName() + " - " + account.getBalance() + "$");
        }

    }

    public static void findOptimalThresholdQuickSortInsertionSort()
    {
        ArraySorting as = new ArraySorting();
        MyTimer timer = new MyTimer();
        HashMap<Integer, Long> sizeBestThreshTime = new HashMap<>();
        HashMap<Integer, Integer> sizeBestThreshVal = new HashMap<>();

        for (int i = 10000; i <= 1280000; i = i * 2)
        {
            for (int thresh = 0; thresh <= 100; thresh++)
            {
                long avg = 0;
                for (int j = 1; j <= 10; j++)
                {
                    int[] arr = ArrayFactory.fillArray(i, 1, 100000);
                    timer.reset();
                    timer.start();
                    as.quickSortInsertionThresh(arr, 0, arr.length - 1, thresh);
                    timer.stop();
                    avg = (avg * (j - 1) + timer.getNanoseconds()) / j;
                }
                long currentBest = sizeBestThreshTime.getOrDefault(i, new Long(Long.MAX_VALUE));
                if (avg < currentBest)
                {
                    sizeBestThreshTime.put(i, avg);
                    sizeBestThreshVal.put(i, thresh);
                }
            }
            System.out.println("For size = " + i + " best thresh was " + sizeBestThreshVal.get(i));
        }

        int avgThresh = 0;
        int c = 0;
        for (int size : sizeBestThreshVal.keySet())
        {

            avgThresh = (avgThresh * c + sizeBestThreshVal.get(size)) / (c + 1);
            c++;
        }
        System.out.println("Best thresh = " + avgThresh);
    }

    public static void main(String[] args)
    {
        SortingAlgoTester.FunWithJavasSort();
    }

}
