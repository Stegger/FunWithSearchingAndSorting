/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.model;

import funwithsearchingandsorting.bll.facade.SortFacade;
import funwithsearchingandsorting.bll.sorting.SortingTypes;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

/**
 *
 * @author Stegger
 */
public class IntSortModel
{

    private final ObservableList<XYChart.Series<Integer, Double>> chartData;
    private final ObservableList<SortingTypes> sortTypes;

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

    public void performTest(List<SortingTypes> sortingTypes, String arrsizes, int minVal, int maxVal)
    {
        int[] lengths = sortFacade.getArrayLengthsFromInput(arrsizes);
        chartData.clear();
        for (SortingTypes sortType : sortingTypes)
        {
            XYChart.Series<Integer, Double> serie = new Series<>();
            serie.setName(sortType.toString());
            for (int n : lengths)
            {
                double time = sortFacade.getTimeToSort(sortType, n, minVal, maxVal);
                serie.getData().add(new XYChart.Data<>(n, time));
            }
            chartData.add(serie);
        }
    }

    /*
     public void oldPerformTest(ObservableList<SortingTypes> sortingTypes, String txtArrSizes, int minVal, int maxVal)
     {
     int[] lengths = InputConverter.getArrayLengthsFromInput(txtArrSizes);
     MyTimer timer = new MyTimer();
     chartData.clear();
     IntSortStrategy sortingAlgorithm;
     for (SortingTypes sortType : sortingTypes)
     {
     sortingAlgorithm = IntSortStrategy.getSort(sortType);
     XYChart.Series<Integer, Double> serie = new Series<>();
     serie.setName(sortType.toString());
     for (int n : lengths)
     {
     int[] target = ArrayFactory.fillArray(n, minVal, maxVal);
     timer.reset();
     timer.start();
     sortingAlgorithm.sort(target);
     timer.stop();
     serie.getData().add(new XYChart.Data<>(n, timer.getSeconds()));
     }
     chartData.add(serie);
     }
     }
     */
    public ObservableList<SortingTypes> getSortingTypes()
    {
        return sortTypes;
    }

    public void performTest(List<SortingTypes> sortTypes, String arrsizes, int minVal, int maxVal, int seed)
    {
        int[] lengths = sortFacade.getArrayLengthsFromInput(arrsizes);
        chartData.clear();
        for (SortingTypes sortType : sortTypes)
        {
            XYChart.Series<Integer, Double> serie = new Series<>();
            serie.setName(sortType.toString());
            for (int n : lengths)
            {
                double time = sortFacade.getTimeToSort(sortType, n, minVal, maxVal, seed);
                serie.getData().add(new XYChart.Data<>(n, time));
            }
            chartData.add(serie);
        }
    }

}
