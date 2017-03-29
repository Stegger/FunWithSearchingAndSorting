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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
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

    private SortFacade sortFacade;

    public IntSortModel()
    {
        sortFacade = new SortFacade();
        chartData = FXCollections.observableArrayList();
        sortTypes = FXCollections.observableArrayList(sortFacade.getAllSortingTypes());
    }

    public ObservableList<XYChart.Series<Integer, Double>> getChartData()
    {
        return chartData;
    }

    public void performTest(List<SortingAlgorithm> sortingTypes, String arrsizes, int minVal, int maxVal, DataType dataType)
    {
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
    }

    public ObservableList<SortingAlgorithm> getSortingTypes()
    {
        return sortTypes;
    }

    public void performTestsInParallel(List<SortingAlgorithm> sortTypes, String arrsizes, int minVal, int maxVal, DataType dataType, int seed)
    {
        Executor exec = Executors.newCachedThreadPool();
        BlockingQueue<Task> q = new LinkedBlockingQueue<>();
        ExecutorCompletionService execCompSer = new ExecutorCompletionService(exec, q);

        int[] lengths = sortFacade.getArrayLengthsFromInput(arrsizes);
        chartData.clear();
        for (SortingAlgorithm sortType : sortTypes)
        {
            XYChart.Series<Integer, Double> serie = new Series<>();
            serie.setName(sortType.toString());
            for (int n : lengths)
            {
                //TODO DO THIS
                double time = sortFacade.getTimeToSort(sortType, n, minVal, maxVal, dataType, seed);
                serie.getData().add(new XYChart.Data<>(n, time));
            }
            chartData.add(serie);
        }
    }

    public void performTest(List<SortingAlgorithm> sortTypes, String arrsizes, int minVal, int maxVal, DataType dataType, int seed)
    {
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
    }

}
