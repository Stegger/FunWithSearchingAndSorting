/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.controller;

import funwithsearchingandsorting.bll.sorting.SortingTypes;
import funwithsearchingandsorting.gui.javafx.model.IntSortModel;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
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
    private ListView<SortingTypes> listSortMethods;

    private IntSortModel intModel;

    public SortViewController()
    {
        intModel = new IntSortModel();
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
    }

    @FXML
    private void onCheckSeed(ActionEvent event)
    {
        txtSeed.setEditable(checkSeed.isSelected());
    }

    @FXML
    private void onBtnTestInt(ActionEvent event)
    {
        try
        {
            lblValidationErr.setText("");
            String arrsizes = txtArrSizes.getText();
            int minVal = Integer.parseInt(spinMinVal.getEditor().getText());
            int maxVal = Integer.parseInt(spinMaxVal.getEditor().getText());
            List<SortingTypes> sortTypes = listSortMethods.getSelectionModel().getSelectedItems();
            if (checkSeed.isSelected())
            {
                int seed = Integer.parseInt(txtSeed.getText().trim());
                intModel.performTest(sortTypes, arrsizes, minVal, maxVal, seed);
            } else
            {
                intModel.performTest(sortTypes, arrsizes, minVal, maxVal);
            }
        } catch (Exception ex)
        {
            lblValidationErr.setText(ex.getMessage());
        }
    }

}
