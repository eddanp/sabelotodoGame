package com.eddanp.sabelotodogame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SabelotodoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sabelotodoView.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNIFIED);
        stage.setTitle("***** Sabelotodo *****");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}