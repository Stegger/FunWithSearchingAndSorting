/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.console;

import funwithsearchingandsorting.bll.arrayGen.ArrayFactory;
import funwithsearchingandsorting.bll.sorting.ArraySorting;
import funwithsearchingandsorting.bll.timer.MyTimer;
import funwithsearchingandsorting.bll.searching.SearchLogic;
import java.util.ArrayList;

/**
 *
 * @author stegg_000
 */
public class Console
{

    public static void main(String[] args) throws InterruptedException
    {
        Console c = new Console();
        c.run5();
    }

    public void run5()
    {
        String form = "%-13s for length: %6d time: %10f";
        ArraySorting asort = new ArraySorting();
        MyTimer myTimer = new MyTimer();
        
        int[] dataLength =
        {
            10, 10, 50,75, 100, 1000, 10000, 20000, 30000, 40000, 50000, 100000, 250000
        };

        for (int length : dataLength)
        {
            int[] data = ArrayFactory.fillArray(length, 0, 1000000, 666);
            
            
            
            int[] copy1 = data.clone();
            myTimer.reset();
            myTimer.start();
            asort.insertionSort(copy1);
            myTimer.stop();
            System.out.println(String.format(form, "Insertion", length, myTimer.getSeconds()));
            
            int[] copy2 = data.clone();
            myTimer.reset();
            myTimer.start();
            asort.binaryInsertionSort(copy2);
            myTimer.stop();
            System.out.println(String.format(form, "BinInsertion", length, myTimer.getSeconds()));
        }
    }

    public void run4()
    {
        ArraySorting ass = new ArraySorting();

        int[] data = ArrayFactory.fillArray(8, -10, 10);

        ass.binaryInsertionSort(data);

        for (int e : data)
        {
            System.out.println("" + e);
        }
        System.out.println("Did it work: " + ass.isSorted(data));

    }

    public void run3()
    {
        int[] data =
        {
            0, 1, 2, 4, 5, 6, 7
        };
        SearchLogic sl = new SearchLogic();
        int i = sl.rangeBinarySearch(data, 0, data.length, 3);
        System.out.println("i is: " + i);
        System.out.println("Length + i is: " + (i + data.length));
    }

    public void run()
    {
        int[] sizes =
        {
            2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 10, 10, 10, 10, 10
        };

        ArrayList<Result> results = new ArrayList<>();
        ArraySorting sorter = new ArraySorting();
        MyTimer timer = new MyTimer();
        for (int size : sizes)
        {
            int[] numbers = ArrayFactory.fillArray(size, 0, 1000000, 666);

            timer.reset();
            timer.start();
            sorter.selectionSort(numbers);
            timer.stop();

            Result r = new Result(size, timer.getSeconds(), SortType.JAVA_PARALLEL);
            results.add(r);
        }
        for (Result result : results)
        {
            System.out.println(
                    String.format("Size: %-3s Sort: %9s Time: %.9f", result.getSize(), result.getType().toString(), result.getTime())
            );
        }
    }

    public void run2()
    {
        int[] sizes =
        {
            2, 500000, 1000000, 5000000, 10000000, 100000000
        };

        MyTimer timer = new MyTimer();
        ArraySorting sorter = new ArraySorting();
        ArrayList<Result> results = new ArrayList<>();

        for (int size : sizes)
        {

            for (SortType type : SortType.values())
            {
                timer.reset();
                int[] copy = ArrayFactory.fillArray(size, 0, 1000000, 666);
                timer.start();
                switch (type)
                {
                    case MERGE:
                        sorter.mergeSort(copy);
                    case QUICK:
                        sorter.quicksort(copy);
                        break;
                    case JAVA_PARALLEL:
                        sorter.parallelJavaSort(copy);
                        break;
                }
                timer.stop();
                Result r = new Result(size, timer.getSeconds(), type);
                results.add(r);
                System.out.println(String.format("Size: %-3s Sort: %9s Time: %.9f", r.getSize(), r.getType().toString(), r.getTime()));
            }
        }

        int l = 0;
        int i = 0;
        for (Result result : results)
        {
            System.out.println(String.format("Size: %-3s Sort: %9s Time: %.9f", result.getSize(), result.getType().toString(), result.getTime()));
        }
    }

    private class Result
    {

        private int size;
        private double time;
        private SortType type;

        @Override
        public String toString()
        {
            return type + ": " + size + " took " + time + " sec. ";
        }

        public Result(int size, SortType type)
        {
            this(size, 0, type);
        }

        public void setTime(double time)
        {
            this.time = time;
        }

        public Result(int size, double time, SortType type)
        {
            this.size = size;

            this.time = time;
            this.type = type;
        }

        public int getSize()
        {
            return size;
        }

        public double getTime()
        {
            return time;
        }

        public SortType getType()
        {
            return type;
        }

    }

    private enum SortType
    {

        JAVA_PARALLEL, QUICK, MERGE;

        @Override
        public String toString()
        {
            switch (this)
            {
//                case BUBBLE:
//                    return "Bubble";
//                case INSERTION:
//                    return "Insertion";
                case QUICK:
                    return "Quick";
//                case SELECTION:
//                    return "Selection";
                case MERGE:
                    return "Merge";
                case JAVA_PARALLEL:
                    return "Java parallel";
//                case HEAP:
//                    return "Heap";
            }
            return "";
        }

    }

}
