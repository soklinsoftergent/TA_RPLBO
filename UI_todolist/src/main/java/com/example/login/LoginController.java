package com.example.loginapp; // Sesuaikan dengan nama package Anda

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleSignIn(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Contoh validasi sederhana
        if (username.equals("user") && password.equals("pass")) {
            showAlert(AlertType.INFORMATION, "Login Berhasil", "Selamat datang, " + username + "!");
            // Navigasi ke halaman Home setelah login berhasil
            navigateToPage(event, "HomeUI.fxml", "Halaman Utama");
        } else {
            showAlert(AlertType.ERROR, "Login Gagal", "Username atau password salah.");
        }
    }

    @FXML
    private void handleForgotPassword(ActionEvent event) {
        showAlert(AlertType.INFORMATION, "Lupa Kata Sandi", "Fungsi lupa kata sandi akan diimplementasikan di sini.");
        // Di sini Anda bisa menambahkan logika untuk navigasi ke halaman lupa kata sandi
    }

    @FXML
    private void handleCreateAccount(ActionEvent event) {
        // Navigasi ke halaman pembuatan akun
        navigateToPage(event, "CreateAccountUI.fxml", "Buat Akun Baru");
    }

    // Metode pembantu untuk menampilkan peringatan
    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Metode pembantu untuk navigasi antar halaman
    private void navigateToPage(ActionEvent event, String fxmlFileName, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Tidak dapat memuat halaman " + title + ".");
        }
    }
}
