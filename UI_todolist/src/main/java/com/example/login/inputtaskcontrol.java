package com.example.login; 

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class inputtaskcontrol {

    @FXML
    private TextField taskInputField;

    @FXML
    private Label dueDateLabel;

    @FXML
    private Label setTimeLabel;

    private LocalDate selectedDate;
    private LocalTime selectedTime;

    // Metode untuk menginisialisasi controller (dipanggil setelah FXML dimuat)
    @FXML
    public void initialize() {
        // Inisialisasi tanggal dan waktu default atau kosong
        dueDateLabel.setText("Due Date");
        setTimeLabel.setText("Set time");
    }

    @FXML
    private void handleDueDateClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DatePickerUI.fxml"));
            Parent root = loader.load();
            datepickcontrol datePickerController = loader.getController();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Membuat jendela modal
            stage.initStyle(StageStyle.UNDECORATED); // Menghilangkan border jendela
            stage.setScene(new Scene(root));
            stage.setTitle("Pilih Tanggal");
            stage.showAndWait(); // Menunggu jendela ditutup

            // Ambil tanggal yang dipilih dari DatePickerController
            selectedDate = datePickerController.getSelectedDate();
            if (selectedDate != null) {
                dueDateLabel.setText(selectedDate.format(DateTimeFormatter.ofPattern("dd MMMM")));
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Tidak dapat memuat halaman pemilihan tanggal.");
        }
    }

    @FXML
    private void handleSetTimeClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TimePickerUI.fxml"));
            Parent root = loader.load();
            TimePickerController timePickerController = loader.getController();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Membuat jendela modal
            stage.initStyle(StageStyle.UNDECORATED); // Menghilangkan border jendela
            stage.setScene(new Scene(root));
            stage.setTitle("Pilih Waktu");
            stage.showAndWait(); // Menunggu jendela ditutup

            // Ambil waktu yang dipilih dari TimePickerController
            selectedTime = timePickerController.getSelectedTime();
            if (selectedTime != null) {
                setTimeLabel.setText(selectedTime.format(DateTimeFormatter.ofPattern("HH:mm")));
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Tidak dapat memuat halaman pemilihan waktu.");
        }
    }

    @FXML
    private void handleOkButton(ActionEvent event) {
        String taskDescription = taskInputField.getText().trim();

        if (taskDescription.isEmpty()) {
            showAlert(AlertType.WARNING, "Input Kosong", "Deskripsi tugas tidak boleh kosong.");
            return;
        }

        // Format tanggal dan waktu jika sudah dipilih
        String dueDateFormatted = (selectedDate != null) ? selectedDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) : "Tidak Ada Tanggal";
        String setTimeFormatted = (selectedTime != null) ? selectedTime.format(DateTimeFormatter.ofPattern("HH:mm")) : "Tidak Ada Waktu";

        String taskDetails = dueDateFormatted + " " + setTimeFormatted; // Gabungkan tanggal dan waktu untuk detail

        // Kembali ke halaman Home dan kirim data tugas
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeUI.fxml"));
            Parent homeRoot = loader.load();
            HomeController homeController = loader.getController();
            homeController.addTask(taskDescription, taskDetails); // Kirim judul dan detail

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
            stage.setScene(scene);
            stage.setTitle("Halaman Utama");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Tidak dapat kembali ke halaman Home.");
        }
    }

    // Metode pembantu untuk navigasi bottom bar (opsional, bisa dihapus jika tidak diperlukan)
    @FXML
    private void handleHomeButton(ActionEvent event) {
        // Navigasi ke halaman Home
        try {
            Parent homeRoot = FXMLLoader.load(getClass().getResource("HomeUI.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(homeRoot);
            stage.setScene(scene);
            stage.setTitle("Halaman Utama");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Tidak dapat memuat halaman Home.");
        }
    }

    @FXML
    private void handleProfileButton(ActionEvent event) {
        showAlert(AlertType.INFORMATION, "Navigasi", "Navigasi ke halaman Profil.");
        // Di sini Anda bisa menambahkan logika navigasi ke halaman profil
    }

    // Metode pembantu untuk menampilkan peringatan
    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
