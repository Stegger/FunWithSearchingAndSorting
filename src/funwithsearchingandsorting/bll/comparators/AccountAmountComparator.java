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
public class AccountAmountComparator implements Comparator<Account>
{

    @Override
    public int compare(Account o1, Account o2)
    {
        //TODO Will this follow 0.5 rounding rules?
        return (int) (o1.getBalance() - o2.getBalance());
    }

}
