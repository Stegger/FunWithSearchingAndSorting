/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.model;

import funwithsearchingandsorting.bll.facade.SortFacade;
import funwithsearchingandsorting.bll.sorting.DataType;
import funwithsearchingandsorting.bll.sorting.SortingAlgorithm;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

/**
 *
 * @author Stegger
 */
public class SortModel
{

    private final ObservableList<XYChart.Series<Integer, Double>> chartData;
    private final ObservableList<SortingAlgorithm> sortTypes;

    private ExecutorService es;
    private SortFacade sortFacade;

    public SortModel()
    {
        sortFacade = new SortFacade();
        chartData = FXCollections.observableArrayList();
        sortTypes = FXCollections.observableArrayList(sortFacade.getAllSortingTypes());
        es = Executors.newFixedThreadPool(2);
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

    public void performTestInParallel(List<SortingAlgorithm> sortTypes, String arrsizes, int minVal, int maxVal, DataType dataType, int seed) throws InterruptedException, ExecutionException
    {
        //Staging the test:
//        ExecutorService es = Executors.newCachedThreadPool();
        BlockingQueue<Future<SortTask>> completionQueue = new LinkedBlockingQueue<>();
        ExecutorCompletionService execComp = new ExecutorCompletionService(es, completionQueue);
        ConcurrentHashMap<SortingAlgorithm, XYChart.Series<Integer, Double>> sortSeries = new ConcurrentHashMap<>();
        int[] lengths = sortFacade.getArrayLengthsFromInput(arrsizes);

        //Initialise sorting to run concurrently:
        for (SortingAlgorithm algorithm : sortTypes)
        {
            for (int i = 0; i < lengths.length; i++)
            {
                SortTask task = new SortTask(sortFacade, algorithm, lengths[i], minVal, maxVal, dataType, seed);
                execComp.submit(task);
            }
        }

        //Create series to be populated with results:
        for (SortingAlgorithm sortType : sortTypes)
        {
            XYChart.Series<Integer, Double> serie = new Series<>();
            serie.setName(sortType.toString());
            sortSeries.put(sortType, serie);
        }

        //I poll all expected results, waiting for them to complete, updating the chart as I go:
        for (int i = 0; i < sortTypes.size() * lengths.length; i++)
        {
            Future<SortTask> futureDoneTask = execComp.take();
            SortTask doneTask = futureDoneTask.get();
            sortSeries.get(doneTask.getSortType()).getData().add(new XYChart.Data<>(doneTask.getN(), doneTask.getTimeToSort()));
        }

        Platform.runLater(()
                -> 
                {
                    chartData.clear(); //I clear the chartData over and over.
                    sortSeries.values().stream().forEach((aSerie)
                            -> 
                            {
                                aSerie.setData(aSerie.getData().sorted((Data<Integer, Double> o1, Data<Integer, Double> o2) -> o1.getXValue() - o2.getXValue()));
                                chartData.add(aSerie);
                    });
        });
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
