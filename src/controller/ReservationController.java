package controller;
/**
 *model for users 
 * 
 * last update 12/01/20
 * 
 * @author amad
 * @author chanel
 */
import Main.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import Databases.MySqlConnector;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * FXML ReservationController class
 *
 * @author amad
 * @author chanel
 * 
 */
public class ReservationController implements Initializable {
  
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
    private Button searchButton;
    
    @FXML
    private ComboBox roomTypeComboBox;
    
    @FXML
    private ComboBox roomNumberComboBox;
    
    private Main main;
    
    ObservableList type;
    ObservableList roomno;
    
    private MySqlConnector mysqlconnector = new MySqlConnector();
    
    
    public void setMain(Main main) throws IOException {
        this.main = main;
        FillForm();
    }

    public boolean checkFields() {
        if (nameField.getText().isEmpty() || addressField.getText().isEmpty() || phoneNumberField.getText().isEmpty() || checkInDatePicker.getValue() == null || checkOutDatePicker.getValue() == null) {
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
    void searchButton(ActionEvent event) {
        if (checkFields()) {
            String checkin = checkInDatePicker.getValue().toString();
            String checkout = checkOutDatePicker.getValue().toString();
            
            roomTypeComboBox.setMaxHeight(10);
            roomNumberComboBox.setMaxHeight(10);

            mysqlconnector.searchBookings(checkout,roomTypeComboBox,roomNumberComboBox);
                  
        }

    }
    
    @FXML
    void reserveButton(ActionEvent event) throws IOException {
        if (checkFields()) {   
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneNumberField.getText();
            String checkin = checkInDatePicker.getValue().toString();
            String checkout = checkOutDatePicker.getValue().toString();
            
            mysqlconnector.reserve(checkin, checkout, roomNumberComboBox);
          
        }   
    }
    
    void FillForm() throws IOException {
    
    String username = LoginController.username;
    mysqlconnector.fillFields(username, nameField, addressField, phoneNumberField);
    
    
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FillForm();
        } catch (IOException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
