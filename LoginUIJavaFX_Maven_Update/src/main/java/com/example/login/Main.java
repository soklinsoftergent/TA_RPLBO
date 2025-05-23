package com.example.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager.setStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
        primaryStage.setTitle("Login UI");
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
