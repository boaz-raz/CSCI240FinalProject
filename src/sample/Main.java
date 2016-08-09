package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Invoice Tracker");
        primaryStage.setScene(new Scene(root, 900, 500));
        Label greeting = new Label("Welcome to JavaFX!");
        greeting.setTextFill(Color.GREEN);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
