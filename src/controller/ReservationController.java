package controller;

import Main.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private ChoiceBox<?> roomTypeComboBox;

    @FXML
    private ChoiceBox<?> roomNumberComboBox;
    
    private Main main;
    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void checkInDate(ActionEvent event) {

    }

    @FXML
    void checkOutDate(ActionEvent event) {

    }

    @FXML
    void reserveButton(ActionEvent event) {
        
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
