package com.example.login;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Hyperlink createAccountLink;

    @FXML
    private void initialize() {
        signInButton.setOnAction(event -> handleLogin());
        createAccountLink.setOnAction(event -> SceneManager.setRoot("Register.fxml"));
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("admin".equals(username) && "password".equals(password)) {
            System.out.println("Login sukses!");
        } else {
            System.out.println("Username atau password salah.");
        }
    }
}
