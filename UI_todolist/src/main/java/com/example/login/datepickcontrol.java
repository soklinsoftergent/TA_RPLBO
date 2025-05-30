package com.example.login; // Sesuaikan dengan nama package Anda

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import java.time.LocalDate;

public class datepickcontrol {

    @FXML
    private DatePicker datePicker;

    private LocalDate selectedDate;

    // Metode untuk mendapatkan tanggal yang dipilih
    public LocalDate getSelectedDate() {
        return selectedDate;
    }

    @FXML
    private void handleOk(ActionEvent event) {
        selectedDate = datePicker.getValue();
        closeWindow(event);
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        selectedDate = null; // Set null jika dibatalkan
        closeWindow(event);
    }

    // Metode pembantu untuk menutup jendela
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
