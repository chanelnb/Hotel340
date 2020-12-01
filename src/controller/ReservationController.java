package controller;

import Main.Main;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Database.MySqlConnector;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservationController implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label checkInLabel;

    @FXML
    private Label checkOutLabel;

    @FXML
    private Label roomTypeLabel;

    @FXML
    private Label roomNumberLabel;

    @FXML
    private Button reserveButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private DatePicker checkInDatePicker;

    @FXML
    private DatePicker checkOutDatePicker;

    @FXML
    private ChoiceBox<?> roomTypeChoiceBox;

    @FXML
    private ChoiceBox<?> roomNumberChoiceBox;

    private Main main;
    private MySqlConnector mysqlconnector = new MySqlConnector();

    public void setMain(Main main) {
        this.main = main;
    }

    public boolean checkFields() {
        if (nameField.getText().isEmpty() || addressField.getText().isEmpty() || phoneNumberField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("One or more fields are empty!");
            alert.showAndWait();

            return false;
        } else {
            return true;
        }
    }

    @FXML
    void checkInDate(ActionEvent event) {
        

    }

    @FXML
    void checkOutDate(ActionEvent event) {

    }

    @FXML
    void reserveButton(ActionEvent event) {
        if (checkFields()) {
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneNumberField.getText();
          
            SimpleDateFormat checkin = new SimpleDateFormat("YYYY-MM-DD");
            String StartDate = checkin.format(checkInDatePicker.getValue());
            SimpleDateFormat checkout = new SimpleDateFormat("YYYY-MM-DD");

            String EndDate = checkout.format(checkOutDatePicker.getValue());
            String roomtype = roomTypeChoiceBox.getValue().toString();
            String roomno = roomNumberChoiceBox.getValue().toString();

            try {
                mysqlconnector.reserve(name, address, phone, StartDate, EndDate, roomtype, roomno);
            } catch (IOException ex) {
                Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
