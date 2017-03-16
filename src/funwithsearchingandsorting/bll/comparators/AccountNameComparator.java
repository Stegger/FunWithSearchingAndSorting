/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.comparators;

import funwithsearchingandsorting.be.Account;
import java.util.Comparator;

/**
 *
 * @author Stegger
 */
public class AccountNameComparator implements Comparator<Account>
{

    @Override
    public int compare(Account o1, Account o2)
    {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }

}
