package controller;

import Main.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchController implements Initializable{

    @FXML
    private Label checkInLabel;

    @FXML
    private Label checkOutLabel;

    @FXML
    private Label numberOfGuestsLabel;

    @FXML
    private DatePicker checkInDatePicker;

    @FXML
    private DatePicker checkOutDatePicker;

    @FXML
    private TextField numberOfGuestsField;

    @FXML
    private Button searchButton;
    
    private Main main;
    
    public void setMain(Main main) {
        this.main = main;
    }
    
    public boolean checkFields(){
        if(checkInDatePicker.getValue() != null || numberOfGuestsField.getText().isEmpty() || checkOutDatePicker.getValue() != null ){
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("One or more fields are empty!");
            alert.showAndWait();

            return false;
        }
        else
            return true;
    }
    
    @FXML
    void search(ActionEvent event) {
        if (checkFields()) {
            
        }
    }

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
