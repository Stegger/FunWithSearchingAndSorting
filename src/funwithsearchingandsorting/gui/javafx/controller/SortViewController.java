/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx.controller;

import funwithsearchingandsorting.bll.exceptions.MyValidationException;
import funwithsearchingandsorting.gui.javafx.model.IntSortModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
        txtSeed.setEditable(checkSeed.isSelected());
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
            if (checkSeed.isSelected())
            {
                intModel.performTest(txtArrSizes, spinMinVal.getValue().intValue(), spinMaxVal.getValue().intValue());
            }
            else
            {
                intModel.performTest(txtArrSizes, spinMinVal.getValue().intValue(), spinMaxVal.getValue().intValue());
            }

        } catch (MyValidationException e)
        {
            lblValidationErr.setText(e.getMessage());
        }
    }

}
