
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Databases.DataObject;
import Main.Main;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

/**
 *
 * @author cah
 */
public class MySqlConnector {
    
    
    PreparedStatement pst;
    PreparedStatement pst2;
     PreparedStatement pst3;
    ResultSet rs;
    Stage stage;
    
    Main main = new Main();
    
    
    public static Connection getConnection(){
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
    
    public void checkUser (String username, String password) throws IOException {
        String query = "SELECT * FROM `user` WHERE username = ? AND password = ?";
            try {
                pst = getConnection().prepareStatement(query);
                pst.setString(1,username);
                pst.setString(2,password);

                rs = pst.executeQuery();
                if(rs.next()){
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
                }else{
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
            try{
                pst = getConnection().prepareStatement(query);
                pst.setString(1,email);
                
                rs = pst.executeQuery();
                if(rs.next()){
                   user_exist = true;
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            return user_exist;
    }
    
    public void userExist (String fname, String lname, String address, String phone, String email,String username, String password) throws IOException{
        
        String query2 = "INSERT into user (uuid, fname, lname, address, phone, email, username, password) values (?,?,?,?,?,?,?,?)";
                    
        try{ 
            pst2 = getConnection().prepareStatement(query2);
            pst2.setString(1,DataObject.generateUuid());
            pst2.setString(2,fname);
            pst2.setString(3,lname);
            pst2.setString(4,address);
            pst2.setString(5,phone);
            pst2.setString(6,email);
            pst2.setString(7,username);
            pst2.setString(8,password);
         
                    
            if(isExist(email)){
                 //if user already exists
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setContentText("User already exists!");
                alert.showAndWait();
            } else {
                if(pst2.executeUpdate() != 0){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Views/login.fxml"));
                    
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();  
                  
                } 
            } 
        }
        catch (SQLException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void reserve(String name, String address, String phone, String StartDate,String EndDate, String rootype, String roomno) throws IOException{
        
        String query3 = "INSERT into reservation (name, address, phone, checkin, checkout, roomtype, roomno) values (?,?,?,?,?,?,?)";
                    
        try{ 
            pst3 = getConnection().prepareStatement(query3);
         
            pst3.setString(1,name);
            pst3.setString(2,address);
            pst3.setString(3,phone);
            pst3.setString(4,StartDate);
            pst3.setString(5,EndDate);
            pst3.setString(6,rootype);
            pst3.setString(7,roomno);
         
                    
            
                if(pst3.executeUpdate() != 0){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/Views/login.fxml"));
                    
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();  
                  
                } 
            } 
        
        catch (SQLException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public ObservableList[] searchBookings(String checkout) {
        String query = "SELECT rooms.roomno, type FROM rooms, reservation WHERE rooms.roomno = reservation.roomno and checkout < ?";
        final ObservableList type = FXCollections.observableArrayList();
        final ObservableList roomno = FXCollections.observableArrayList();
            try {
                pst = getConnection().prepareStatement(query);
                pst.setString(1,checkout);

                rs = pst.executeQuery();
                if(rs.next()){
                    //adds available rooms to combobox for reservation
                    type.add(rs.getString("type"));
                    roomno.add(rs.getString("roomno"));
                    
                } else{
                    // if login unsuccessful show error message
                   Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("SORRY");
                   alert.setContentText("There are no rooms available at this time");
                   alert.showAndWait();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
         return new ObservableList[] {type, roomno};
    }
  
}