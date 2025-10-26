package com.expensetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Expense Tracker with Monthly Analytics");
        stage.setScene(scene);
        stage.setResizable(false); 
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
