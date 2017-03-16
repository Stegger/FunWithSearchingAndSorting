/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.gui.javafx;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pgn
 */
public class SortingSearchingFX extends Application
{

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        URL url = getClass().getResource("view/SortView.fxml");
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Fun with searching and sorting!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
