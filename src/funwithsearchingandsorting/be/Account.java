/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.be;

/**
 *
 * @author Stegger
 */
public class Account implements Comparable<Account>
{

    private int accNr;
    private double balance;
    private String name;

    public Account(int accNr, double balance, String name)
    {
        this.accNr = accNr;
        this.balance = balance;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public int getAccNr()
    {
        return accNr;
    }

    @Override
    public int compareTo(Account o)
    {                    
        return (int) (this.accNr - o.getAccNr());
    }

}
