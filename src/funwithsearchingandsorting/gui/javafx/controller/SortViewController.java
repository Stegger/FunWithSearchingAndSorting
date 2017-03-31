/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.controller;

import funwithsearchingandsorting.bll.sorting.DataType;
import funwithsearchingandsorting.bll.sorting.SortingAlgorithm;
import funwithsearchingandsorting.gui.javafx.model.SortModel;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Stegger
 */
public class SortViewController implements Initializable
{

    @FXML
    private Button btnTestGenerics;
    @FXML
    private Button btnTestIntegers;
    @FXML
    private LineChart<Integer, Double> lineChartSort;
    @FXML
    private Spinner<Integer> spinMinVal;
    @FXML
    private Spinner<Integer> spinMaxVal;
    @FXML
    private TextField txtArrSizes;
    @FXML
    private CheckBox checkSeed;
    @FXML
    private TextField txtSeed;
    @FXML
    private Label lblValidationErr;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private ListView<SortingAlgorithm> listSortMethods;

    private SortModel intModel;

    public SortViewController()
    {
        intModel = new SortModel();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        listSortMethods.setItems(intModel.getSortingTypes());
        listSortMethods.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        txtSeed.setEditable(checkSeed.isSelected());
        xAxis.setLabel("n");
        yAxis.setLabel("Seconds");
        ObservableList<Series<Integer, Double>> data = intModel.getChartData();
        lineChartSort.setData(data);
        //btnTestGenerics.disableProperty().bind(intModel.getIsProcessing());
        //btnTestIntegers.disableProperty().bind(intModel.getIsProcessing());
    }

    @FXML
    private void onCheckSeed(ActionEvent event)
    {
        txtSeed.setEditable(checkSeed.isSelected());
    }

    @FXML
    private void onBtnTestInt(ActionEvent event)
    {
        //stageAndRunTest(DataType.INT);
        stageAndRunTestInParallel(DataType.INT);
    }

    private void switchBtnEnable(Button... buttons)
    {
        for (Button button : buttons)
        {
            button.setDisable(!button.isDisable());
        }
    }

    private void stageAndRunTestInParallel(DataType dataType)
    {
        try
        {
            lblValidationErr.setText("");
            String arrsizes = txtArrSizes.getText();
            int minVal = Integer.parseInt(spinMinVal.getEditor().getText());
            int maxVal = Integer.parseInt(spinMaxVal.getEditor().getText());
            List<SortingAlgorithm> sortTypes = listSortMethods.getSelectionModel().getSelectedItems();
            Runnable runner = null;
            if (checkSeed.isSelected())
            {
                int seed = Integer.parseInt(txtSeed.getText().trim());
                runner = ()
                        -> 
                        {
                            try
                            {
                                intModel.performTestInParallel(sortTypes, arrsizes, minVal, maxVal, dataType, seed);
                                
                            } catch (Exception ex)
                            {
                                lblValidationErr.setText(ex.getMessage());
                                ex.printStackTrace();
                            }
                            switchBtnEnable(btnTestGenerics, btnTestIntegers);
                };
            } else
            {
                runner = ()
                        -> 
                        {
                            try
                            {
                                intModel.performTestInParallel(sortTypes, arrsizes, minVal, maxVal, dataType, 0);
                                
                            } catch (Exception ex)
                            {
                                lblValidationErr.setText(ex.getMessage());
                                ex.printStackTrace();
                            }
                            switchBtnEnable(btnTestGenerics, btnTestIntegers);
                };
            }
            Thread t = new Thread(runner);
            switchBtnEnable(btnTestGenerics, btnTestIntegers);
            t.start();
        } catch (Exception ex)
        {
            lblValidationErr.setText(ex.getMessage());
        }
    }

    private void stageAndRunTest(DataType dataType)
    {
        try
        {
            lblValidationErr.setText("");
            String arrsizes = txtArrSizes.getText();
            int minVal = Integer.parseInt(spinMinVal.getEditor().getText());
            int maxVal = Integer.parseInt(spinMaxVal.getEditor().getText());
            List<SortingAlgorithm> sortTypes = listSortMethods.getSelectionModel().getSelectedItems();
            if (checkSeed.isSelected())
            {
                int seed = Integer.parseInt(txtSeed.getText().trim());
                intModel.performTest(sortTypes, arrsizes, minVal, maxVal, dataType, seed);
            } else
            {
                intModel.performTest(sortTypes, arrsizes, minVal, maxVal, dataType);
            }
        } catch (Exception ex)
        {
            lblValidationErr.setText(ex.getMessage());
        }
    }

    @FXML
    private void OnButtonTestGenerics(ActionEvent event)
    {
        //stageAndRunTest(DataType.GENERIC_OBJECT);
        stageAndRunTestInParallel(DataType.GENERIC_OBJECT);
    }

}
