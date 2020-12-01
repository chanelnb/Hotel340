/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases;

import Main.Main;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author chanel 
 * @author amad
 * @author sogol
 * 
 */
public class MySqlConnector {

    PreparedStatement pst;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst4;

    ResultSet rs;
    Stage stage;

    Main main = new Main();

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hotelmanagementsystem", "root", "root");
            } catch (SQLException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return con;

    }

    public void checkUser(String username, String password) throws IOException {
        String query = "SELECT * FROM `user` WHERE username = ? AND password = ?";
        try {
            pst = getConnection().prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            rs = pst.executeQuery();
            if (rs.next()) {
                //if login successful show a new form

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Views/HomeScreen.fxml"));

                    Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // if login unsuccessful show error message
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("Invalid username or password");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isExist(String email) throws IOException {
        String query = "SELECT * FROM `user` WHERE email = ?";
        boolean user_exist = false;
        try {
            pst = getConnection().prepareStatement(query);
            pst.setString(1, email);

            rs = pst.executeQuery();
            if (rs.next()) {
                user_exist = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);

        }
        return user_exist;
    }

    public void userExist(String fname, String lname, String address, String phone, String email, String username, String password) throws IOException {

        String query2 = "INSERT into user (uuid, fname, lname, address, phone, email, username, password) values (?,?,?,?,?,?,?,?)";

        try {
            pst2 = getConnection().prepareStatement(query2);
            pst2.setString(1, DataObject.generateUuid());
            pst2.setString(2, fname);
            pst2.setString(3, lname);
            pst2.setString(4, address);
            pst2.setString(5, phone);
            pst2.setString(6, email);
            pst2.setString(7, username);
            pst2.setString(8, password);

            if (isExist(email)) {
                //if user already exists
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("User already exists!");
                alert.showAndWait();
            } else {
                if (pst2.executeUpdate() != 0) {
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation");
                    alert.setContentText("User Created Successsfully, Please signin!");
                    alert.showAndWait();

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Views/login.fxml"));

                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillFields(String username,TextField nameField, TextField addressField, TextField phoneNumberField) throws IOException { 
        String query3 = "SELECT * FROM user WHERE username = ?";
        try {
            pst3 = getConnection().prepareStatement(query3);
            pst3.setString(1, username);
            rs = pst3.executeQuery();
            while (rs.next()) {
                nameField.setText(rs.getString("fname"));
                addressField.setText(rs.getString("address"));
                phoneNumberField.setText(rs.getString("phone"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void reserve(String checkIn, String checkOut, ComboBox roomNum) throws IOException  {
        
        String query = "INSERT into reservation (checkin, checkout, roomno) values (?,?,?)";
        try {

            pst = getConnection().prepareStatement(query);
            pst.setString(1, checkIn);
            pst.setString(2, checkOut);
            pst.setString(3, (String)roomNum.getSelectionModel().getSelectedItem());

            
            if (pst.executeUpdate() != 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("Reservation successfully booked, check your email!");
                alert.showAndWait();

            }
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchBookings(String checkout, ComboBox roomType, ComboBox roomNum) {
        String query = "SELECT rooms.roomno, type FROM rooms, reservation WHERE rooms.roomno = reservation.roomno and checkout < ?";
        try {
            pst = getConnection().prepareStatement(query);
            pst.setString(1,checkout);

            rs = pst.executeQuery();
                
            if (rs.next() == false) {
                // if there are no rooms available show error message
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("SORRY");
                alert.setContentText("There are no rooms available at this time");
                alert.showAndWait();
            } else {
                do {
                     // if rooms are available display in combobox
                    roomType.getItems().addAll(rs.getString("type"));
                    roomNum.getItems().addAll(rs.getString("roomno"));
                    
                } while (rs.next());
                    
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
         
                
    }

}
