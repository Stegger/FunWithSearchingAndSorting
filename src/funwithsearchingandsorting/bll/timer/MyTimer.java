/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.timer;

/**
 *
 * @author stegg_000
 */
public class MyTimer
{

    private long start;
    private long end;

    public MyTimer()
    {
        reset();
    }

    public void start()
    {
        start = System.nanoTime();
    }

    public void stop()
    {
        end = System.nanoTime();
    }

    public long getNanoseconds()
    {
        return end - start;
    }

    public double getSeconds()
    {
        return getNanoseconds() / 1E+9;
    }

    public long getSplitNanosecond()
    {
        return System.nanoTime() - start;
    }

    public double getSplitSeconds()
    {
        return getSplitNanosecond() / 1E+9;
    }

    public void reset()
    {
        start = 0;
        end = 0;
    }

}
