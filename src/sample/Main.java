package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
        primaryStage.setTitle("Invoice Tracker");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


   // store the items that are hard coded
    @Override
    public void stop() throws Exception {
        try {
            DataFile.getInstance().storeData(); // store items after closing the app
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    // load data from file
    @Override
    public void init() throws Exception {
        try {
            DataFile.getInstance().loadData(); // store items after closing the app
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
