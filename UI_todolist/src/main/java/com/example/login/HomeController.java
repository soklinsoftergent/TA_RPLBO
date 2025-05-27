package com.example.loginapp; // Sesuaikan dengan nama package Anda

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell; // Import ListCell
import java.io.IOException;
import java.util.Optional;
import java.util.UUID; // Untuk menghasilkan ID unik

public class HomeController {

    @FXML
    private ListView<Task> taskList; // ListView sekarang akan menyimpan objek Task

    private ObservableList<Task> tasks; // ObservableList untuk menyimpan objek Task

    @FXML
    public void initialize() {
        // Inisialisasi ObservableList saat controller dimuat
        tasks = FXCollections.observableArrayList();
        taskList.setItems(tasks); // Hubungkan ListView dengan ObservableList

        // Set cell factory kustom untuk ListView
        taskList.setCellFactory(param -> new ListCell<Task>() {
            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);

                if (empty || task == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskItemUI.fxml"));
                        Parent taskItemBox = loader.load(); // Menggunakan Parent karena TaskItemUI.fxml adalah HBox
                        TaskItemController controller = loader.getController();
                        // Mengirim data tugas dan referensi ke HomeController
                        controller.setTaskData(task.getId(), task.getTitle(), task.getDetails(), HomeController.this);
                        setGraphic(taskItemBox);
                    } catch (IOException e) {
                        e.printStackTrace();
                        setText("Error loading task item.");
                        setGraphic(null);
                    }
                }
            }
        });
    }

    // Metode ini dipanggil dari InputTaskController untuk menambahkan tugas
    public void addTask(String title, String details) {
        if (title != null && !title.trim().isEmpty()) {
            String id = UUID.randomUUID().toString(); // Buat ID unik untuk tugas
            tasks.add(new Task(id, title, details));
        }
    }

    // Metode untuk mengedit tugas
    public void editTask(String taskId, String currentTitle, String currentDetails) {
        // Logika untuk membuka dialog edit
        TextInputDialog dialog = new TextInputDialog(currentTitle);
        dialog.setTitle("Edit Tugas");
        dialog.setHeaderText("Edit judul tugas:");
        dialog.setContentText("Judul Tugas:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(newTitle -> {
            if (!newTitle.trim().isEmpty()) {
                // Cari tugas berdasarkan ID dan perbarui
                for (Task task : tasks) {
                    if (task.getId().equals(taskId)) {
                        task.setTitle(newTitle.trim());
                        // Anda juga bisa membuka dialog terpisah untuk mengedit tanggal/waktu di sini
                        // Untuk saat ini, kita hanya memperbarui judul
                        showAlert(AlertType.INFORMATION, "Tugas Diperbarui", "Tugas berhasil diperbarui.");
                        taskList.refresh(); // Refresh ListView untuk menampilkan perubahan
                        return;
                    }
                }
            } else {
                showAlert(AlertType.WARNING, "Input Kosong", "Judul tugas tidak boleh kosong.");
            }
        });
    }

    // Metode untuk menghapus tugas
    public void deleteTask(String taskId) {
        // Tampilkan konfirmasi sebelum menghapus
        Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
        confirmAlert.setTitle("Konfirmasi Hapus");
        confirmAlert.setHeaderText("Hapus Tugas?");
        confirmAlert.setContentText("Apakah Anda yakin ingin menghapus tugas ini?");

        Optional<javafx.scene.control.ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == javafx.scene.control.ButtonType.OK) {
            tasks.removeIf(task -> task.getId().equals(taskId));
            showAlert(AlertType.INFORMATION, "Tugas Dihapus", "Tugas berhasil dihapus.");
        }
    }


    @FXML
    private void handleAddTask(ActionEvent event) {
        // Navigasi ke halaman Input Task
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InputTaskUI.fxml"));
            Parent inputTaskRoot = loader.load();
            // InputTaskController inputTaskController = loader.getController(); // Tidak perlu mendapatkan controller di sini
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(inputTaskRoot);
            stage.setScene(scene);
            stage.setTitle("Input Tugas Baru");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Tidak dapat memuat halaman Input Tugas.");
        }
    }

    @FXML
    private void handleHomeButton(ActionEvent event) {
        showAlert(AlertType.INFORMATION, "Navigasi", "Anda berada di halaman Home.");
        // Di sini Anda bisa menambahkan logika navigasi atau refresh halaman Home
    }

    @FXML
    private void handleProfileButton(ActionEvent event) {
        showAlert(AlertType.INFORMATION, "Navigasi", "Navigasi ke halaman Profil.");
        // Di sini Anda bisa menambahkan logika navigasi ke halaman profil
    }

    @FXML
    private void handleMenuButton(ActionEvent event) {
        showAlert(AlertType.INFORMATION, "Menu", "Fungsi menu akan diimplementasikan di sini.");
        // Di sini Anda bisa menambahkan logika untuk menampilkan menu
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
