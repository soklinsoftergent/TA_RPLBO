package com.example.login; // Sesuaikan dengan nama package Anda

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Memuat file FXML untuk halaman login sebagai tampilan awal
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        // Membuat scene dan menampilkannya
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Aplikasi"); // Judul jendela
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
