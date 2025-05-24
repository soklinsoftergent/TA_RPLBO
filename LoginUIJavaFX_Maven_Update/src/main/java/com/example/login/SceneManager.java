package com.example.login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static Stage stage;

    public static void setStage(Stage s) {
        stage = s;
    }

    public static void setRoot(String fxml) {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource("/" + fxml));
            stage.setScene(new Scene(root, 300, 500));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
