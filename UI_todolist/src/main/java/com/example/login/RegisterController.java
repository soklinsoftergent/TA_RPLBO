package com.example.login;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button signUpButton;

    @FXML
    private Hyperlink backToLoginLink;

    @FXML
    private void initialize() {
        signUpButton.setOnAction(event -> handleRegister());
        backToLoginLink.setOnAction(event -> SceneManager.setRoot("Login.fxml"));
    }

    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            System.out.println("Password tidak cocok!");
            return;
        }

        System.out.println("Registrasi berhasil untuk: " + username);
    }
}
