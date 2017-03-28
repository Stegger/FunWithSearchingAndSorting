/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.arrayGen;

import funwithsearchingandsorting.be.Account;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Stegger
 */
public class AccountArrayGenerator
{

    private static final String[] ACCOUNT_NAMES =
    {
        "Savings", "Checking", "Personal", "Don't tell the wiffe about it", "Depot", "Stocks", "Endless debt", "Child savings"
    };

    public static Account[] fillArray(int size, int minValue, int maxValue)
    {
        Random rnd = new Random();
        return fillArray(size, minValue, maxValue, rnd.nextInt());
    }

    public static Account[] fillArray(int size, int minValue, int maxValue, int seed)
    {
        Account[] tmp = new Account[size];
        Random random = new Random(seed);
        for (int i = 0; i < size; i++)
        {
            String name = ACCOUNT_NAMES[random.nextInt(ACCOUNT_NAMES.length)];
            double balance = random.nextDouble() * (maxValue - minValue) + minValue;
            tmp[i] = new Account(i + 1, balance, name);
        }
        List<Account> lst = Arrays.asList(tmp);
        Collections.shuffle(lst, random);
        return (Account[]) lst.toArray();
    }

    public static Account[] fillSortedArray(int size, int minValue, int maxValue, int seed)
    {
        Account[] tmp = new Account[size];
        Random random = new Random(seed);
        for (int i = 0; i < size; i++)
        {
            String name = ACCOUNT_NAMES[random.nextInt(ACCOUNT_NAMES.length)];
            double balance = random.nextDouble() * (maxValue - minValue) + minValue;
            tmp[i] = new Account(i + 1, balance, name);
        }
        return tmp;
    }

    public static Account[] fillSortedArray(int size, int minValue, int maxValue)
    {
        Random rnd = new Random();
        return fillSortedArray(size, minValue, maxValue, rnd.nextInt());
    }
}
