package com.example.loginapp; // Sesuaikan dengan nama package Anda

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class TaskItemController {

    @FXML
    private HBox taskItemContainer; // Container utama untuk item tugas

    @FXML
    private Button checkButton;

    @FXML
    private Label taskTitleLabel;

    @FXML
    private Label taskDetailsLabel;

    private String taskId; // Untuk identifikasi tugas jika perlu (misal: untuk hapus dari daftar global)
    private HomeController homeController; // Referensi ke HomeController

    private boolean isCompleted = false;

    // Metode untuk mengatur data tugas
    public void setTaskData(String id, String title, String details, HomeController controller) {
        this.taskId = id;
        this.taskTitleLabel.setText(title);
        this.taskDetailsLabel.setText(details);
        this.homeController = controller; // Simpan referensi ke HomeController
    }

    @FXML
    private void handleCheckTask(ActionEvent event) {
        isCompleted = !isCompleted;
        if (isCompleted) {
            checkButton.setText("☑"); // Ganti ikon menjadi checklist
            taskTitleLabel.setTextFill(Color.GRAY); // Ubah warna teks menjadi abu-abu
            taskDetailsLabel.setTextFill(Color.GRAY);
            taskItemContainer.setStyle("-fx-background-color: #E0E0E0; -fx-background-radius: 10;"); // Ubah warna latar belakang
        } else {
            checkButton.setText("☐"); // Ganti ikon kembali
            taskTitleLabel.setTextFill(Color.BLACK); // Kembalikan warna teks
            taskDetailsLabel.setTextFill(Color.BLACK);
            taskItemContainer.setStyle("-fx-background-color: white; -fx-background-radius: 10;"); // Kembalikan warna latar belakang
        }
        // Anda bisa menambahkan logika untuk memperbarui status tugas di model data di sini
        System.out.println("Task '" + taskTitleLabel.getText() + "' completion status: " + isCompleted);
    }

    @FXML
    private void handleEditTask(ActionEvent event) {
        // Panggil metode di HomeController untuk membuka dialog edit
        if (homeController != null) {
            homeController.editTask(taskId, taskTitleLabel.getText(), taskDetailsLabel.getText());
        }
        System.out.println("Edit task: " + taskTitleLabel.getText());
    }

    @FXML
    private void handleDeleteTask(ActionEvent event) {
        // Panggil metode di HomeController untuk menghapus tugas
        if (homeController != null) {
            homeController.deleteTask(taskId);
        }
        System.out.println("Delete task: " + taskTitleLabel.getText());
    }
}
