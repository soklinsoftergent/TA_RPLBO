package com.example.login; // Sesuaikan dengan nama package Anda

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

public class CreateAccountController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private void handleSignUp(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(AlertType.ERROR, "Pendaftaran Gagal", "Semua bidang harus diisi.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert(AlertType.ERROR, "Pendaftaran Gagal", "Kata sandi tidak cocok.");
            return;
        }

        // Di sini Anda bisa menambahkan logika pendaftaran akun ke database atau sistem otentikasi
        showAlert(AlertType.INFORMATION, "Pendaftaran Berhasil", "Akun " + username + " berhasil dibuat!");

        // Navigasi ke halaman Home setelah pendaftaran berhasil
        navigateToPage(event, "HomeUI.fxml", "Halaman Utama");
    }

    @FXML
    private void handleAlreadyHaveAccount(ActionEvent event) {
        // Navigasi kembali ke halaman Login
        navigateToPage(event, "LoginUI.fxml", "Login Aplikasi");
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
