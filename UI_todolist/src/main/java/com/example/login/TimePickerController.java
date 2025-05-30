package com.example.login; 

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import java.time.LocalTime;

public class TimePickerController {

    @FXML
    private Spinner<Integer> hourSpinner;

    @FXML
    private Spinner<Integer> minuteSpinner;

    private LocalTime selectedTime;

    // Metode untuk mendapatkan waktu yang dipilih
    public LocalTime getSelectedTime() {
        return selectedTime;
    }

    @FXML
    public void initialize() {
        // Inisialisasi spinner dengan nilai default
        hourSpinner.getValueFactory().setValue(LocalTime.now().getHour());
        minuteSpinner.getValueFactory().setValue(LocalTime.now().getMinute());
    }

    @FXML
    private void handleOk(ActionEvent event) {
        selectedTime = LocalTime.of(hourSpinner.getValue(), minuteSpinner.getValue());
        closeWindow(event);
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        selectedTime = null; // Set null jika dibatalkan
        closeWindow(event);
    }

    // Metode pembantu untuk menutup jendela
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
