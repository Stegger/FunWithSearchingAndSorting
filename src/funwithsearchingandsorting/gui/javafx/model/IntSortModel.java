/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.model;

import funwithsearchingandsorting.bll.facade.SortFacade;
import funwithsearchingandsorting.bll.sorting.DataType;
import funwithsearchingandsorting.bll.sorting.SortingAlgorithm;
import funwithsearchingandsorting.gui.javafx.controller.SortTask;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

/**
 *
 * @author Stegger
 */
public class IntSortModel
{

    private final ObservableList<XYChart.Series<Integer, Double>> chartData;
    private final ObservableList<SortingAlgorithm> sortTypes;
    private final BooleanProperty isProcessing;

    private SortFacade sortFacade;

    public IntSortModel()
    {
        sortFacade = new SortFacade();
        chartData = FXCollections.observableArrayList();
        sortTypes = FXCollections.observableArrayList(sortFacade.getAllSortingTypes());
        isProcessing = new SimpleBooleanProperty(false);
    }

    public ObservableList<XYChart.Series<Integer, Double>> getChartData()
    {
        return chartData;
    }

    public void performTest(List<SortingAlgorithm> sortingTypes, String arrsizes, int minVal, int maxVal, DataType dataType)
    {
        isProcessing.set(true);
        int[] lengths = sortFacade.getArrayLengthsFromInput(arrsizes);
        chartData.clear();
        for (SortingAlgorithm sortType : sortingTypes)
        {
            XYChart.Series<Integer, Double> serie = new Series<>();
            serie.setName(sortType.toString());
            for (int n : lengths)
            {
                double time = sortFacade.getTimeToSort(sortType, n, minVal, maxVal, dataType);
                serie.getData().add(new XYChart.Data<>(n, time));
            }
            chartData.add(serie);
        }
        isProcessing.set(false);
    }

    public ObservableList<SortingAlgorithm> getSortingTypes()
    {
        return sortTypes;
    }

    public void test()
    {
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new SortTask(sortFacade, SortingAlgorithm.BUBBLE, 10, 0, 100, DataType.INT));
        es.submit(new SortTask(sortFacade, SortingAlgorithm.BUBBLE, 100, 0, 100, DataType.INT));
        es.submit(new SortTask(sortFacade, SortingAlgorithm.BUBBLE, 1000, 0, 100, DataType.INT));
        es.submit(new SortTask(sortFacade, SortingAlgorithm.BUBBLE, 10000, 0, 100, DataType.INT));
        es.submit(new SortTask(sortFacade, SortingAlgorithm.BUBBLE, 20000, 0, 100, DataType.INT));
        es.submit(new SortTask(sortFacade, SortingAlgorithm.BUBBLE, 30000, 0, 100, DataType.INT));

    }

    public void performTest(List<SortingAlgorithm> sortTypes, String arrsizes, int minVal, int maxVal, DataType dataType, int seed)
    {
        isProcessing.set(true);
        int[] lengths = sortFacade.getArrayLengthsFromInput(arrsizes);
        chartData.clear();
        for (SortingAlgorithm sortType : sortTypes)
        {
            XYChart.Series<Integer, Double> serie = new Series<>();
            serie.setName(sortType.toString());
            for (int n : lengths)
            {
                double time = sortFacade.getTimeToSort(sortType, n, minVal, maxVal, dataType, seed);
                serie.getData().add(new XYChart.Data<>(n, time));
            }
            chartData.add(serie);
        }
        isProcessing.set(false);
    }

    /**
     * @return the isProcessing
     */
    public BooleanProperty getIsProcessing()
    {
        return isProcessing;
    }

}
