/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.model;

import funwithsearchingandsorting.bll.arrayGen.ArrayFactory;
import funwithsearchingandsorting.bll.input.InputConverter;
import funwithsearchingandsorting.bll.sorting.integers.BubbleSort;
import funwithsearchingandsorting.bll.sorting.integers.InsertionSort;
import funwithsearchingandsorting.bll.sorting.integers.IntSortStrategy;
import funwithsearchingandsorting.bll.sorting.integers.SelectionSort;
import funwithsearchingandsorting.bll.timer.MyTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

/**
 *
 * @author Stegger
 */
public class IntSortModel
{

    private final ObservableList<XYChart.Series<Integer, Double>> chartData;

    public IntSortModel()
    {
        chartData = FXCollections.emptyObservableList();
    }

    public ObservableList<XYChart.Series<Integer, Double>> getChartData()
    {
        return chartData;
    }

    public void performTest(String txtArrSizes, int minVal, int maxVal)
    {
        int[] lengths = InputConverter.getArrayLengthsFromInput(txtArrSizes);
        MyTimer timer = new MyTimer();
        chartData.clear();
        IntSortStrategy[] sortingAlgorithms =
        {
            new BubbleSort(), new InsertionSort(), new SelectionSort()
        };
        for (IntSortStrategy sortingAlgorithm : sortingAlgorithms)
        {
            Series<Integer, Double> serie = new Series<>();
            serie.setName(sortingAlgorithm.toString());
            ObservableList<Data<Integer, Double>> data = FXCollections.emptyObservableList();
            for (int n : lengths)
            {
                int[] target = ArrayFactory.fillArray(n, minVal, maxVal);
                timer.reset();
                timer.start();
                sortingAlgorithm.sort(target);
                timer.stop();
                data.add(new Data<>(n, timer.getSeconds()));
            }
            serie.setData(data);
            chartData.add(serie);
        }
    }

}
