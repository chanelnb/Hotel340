/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases;

/**
 * This implementation of the DBConnectorInterface interface is for MySQL databases.
 * @author iquigley
 */

import Main.Main;
import controller.LoginController;
import controller.SearchController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import javafx.stage.Stage;



public class MYSQLConnector implements DBConnectorInterface{

    Connection connection = null;
    Statement statement = null;
    PreparedStatement pst;
    ResultSet rs;
    private Stage stage;
    Main main;

    // For standard MySQL Ports.
    //static String host = "jdbc:mysql://localhost:8081/hotelmanagementsystem";
    // For mac users of MAMP using the default MySQL port
    static String host = "jdbc:mysql://127.0.0.1/hotelmanagementsystem";
    static String user = "root";
    static String password = "root";

    public MYSQLConnector() {
        // Initialize the connection at start-up.
        this.connect();
    }
    
    /**
     * Generates a MySQL specific string for saving objects to the database.
     * @param _keyValuePairs
     * @param _table
     * @return int
     */
    
    
    
    @Override
    public int createObject(Map<String, String> _keyValuePairs, String _table) {
        String query =  "INSERT INTO " + _table;
        String names = "(";
        String values = "VALUES (";
        for (Map.Entry<String, String> entry : _keyValuePairs.entrySet()){
            names+=  " `" + entry.getKey() + "`, ";
            values+= " '" + entry.getValue() + "', ";
        }
        // Trim off the last comma.
        names = names.substring(0, names.length() - 2);
        values = values.substring(0, values.length() - 2);
        names+= ") ";
        values+= ")";
        query+= names + values;
        // Execute the query.
        
        int newKey = this.executeInsert(query);
        if (newKey == -1) {
            System.out.println("Database Error: Could not create new record");
            return 0;
        }
        return newKey;
    }


    /**
     * This helper function runs the query given by the above method.
     * @TODO - See if we can consolidate this method with the other helper methods
     * below.
     * @param query
     * @return
     */
    private int executeInsert(String query){
        int key = -1;
        try {
            this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()){
                key = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
            Logger.getLogger(DataStoreAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }


    /**
     * Generates a MySQL query for updating an object to the database.
     * @param _keyValuePairs
     * @param _uuid
     * @param _table
     * @return Boolean
     */
    @Override
    public Boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table) {
        String query =  "UPDATE " + _table + " SET ";
        //iterate over map
        String updates = "";
        for (Map.Entry<String, String> entry : _keyValuePairs.entrySet()){
            updates+= " `" + entry.getKey() + "` = \"" + entry.getValue() + "\",";
        }
        //shed off the last comma
        updates = updates.substring(0, updates.length()-1);
        query = query + updates + " WHERE `uuid` = '" + _uuid + "'";
        return this.executeUpdate(query);
    }


    /**
     * This helper method runs the query generated by the updateObject method.
     * @param query
     */
    private Boolean executeUpdate(String query){
        int result = 0;
        try {
            result = statement.executeUpdate(query, Statement.NO_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
            Logger.getLogger(DataStoreAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Result returns the number of rows affected. If no rows were affected,
        // the return false.
        return (result > 0);
    }


    /**
     * Reads an object from the database given a set of conditionals in name-value
     * pair format. This is an overloaded readObject method that, by default, doesn't load deleted objects.
     * @TODO - Implement this method.
     * @param _keyValuePairs
     * @return
     */
    @Override
    public HashMap<String, Object> readObject(Map<String,String> _keyValuePairs, String _table) {
        // By default we do not load deleted object.
        return this.readObject(_keyValuePairs, _table, false);
    }

    /**
     * Same as above except allows the option of reading deleted objects from the database.
     * @param _keyValuePairs
     * @param _table
     * @param _deleted whether to load deleted objects.
     * @return
     */
    public void checkUser(String username,String password) {
            
        //select query to check if the username and password exist in the database
        String query = "SELECT * FROM `user` WHERE username = ? AND password = ?";
        try {
            
            pst.setString(1,username);
            pst.setString(2,password);
        
            rs = pst.executeQuery(query);

            if(rs.next()){
                //if login successful show a new form
                System.out.println(username);
                System.out.println(password);
            } else{
                // if login unsuccessful show error message
               JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Login Error", 2);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MYSQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }      
         
    
    
    public HashMap<String, Object> readObject(Map<String,String> _keyValuePairs, String _table, boolean _deleted) {
        // Start the query.
        String query =  "SELECT * FROM " + _table + " WHERE ";
        // Initialize the condition string.
        String condition = "";
        // Iterate over map.
        for (Map.Entry<String, String> entry : _keyValuePairs.entrySet()){
            condition+= " `" + entry.getKey() + "` = \"" + entry.getValue() + "\" AND";
        }
        if (_deleted) {
            // Then we'll ignore the active=1 condition and just shed off the last AND
            condition = condition.substring(0, condition.length()-3);
        } else {
            // We'll add the condition that the object must be active.
            condition+= " `active` = 1";
        }
        // Combine the query with the condition.
        query = query + condition;
        // Initialize a object to store the results.
        HashMap<String, Object> returnData = new HashMap();
        ResultSet results = this.runQuery(query);
        // Create a flag for judging if the result set is empty.
        boolean isEmpty = true;
        try {
            while (results.next()) {
                isEmpty = false;
                ResultSetMetaData data = results.getMetaData();
                int count = data.getColumnCount();
                for (int i = 1; i <= count; i++) {
                   String columnName = data.getColumnName(i);
                   returnData.put(columnName, results.getObject(i));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MYSQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Close the statement connection.
        if (isEmpty) {
            // No results were loaded, return null.
            return null;
        }
        return returnData;
    }


    /**
     * This method deletes an object from the database.
     * @TODO - Implement this method. We want to just make an update to the database
     * to set an active flag to false instead of actually deleting records.
     * @param uuid
     * @return Boolean
     */
    @Override
    public Boolean deleteObject(String uuid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /**
     * Generic helper method for running queries.
     * @param query
     * @return ResultSet
     */
    protected ResultSet runQuery(String query){
        ResultSet result = null;
        try {
            result = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
        }
        return result;
    }

    /**
     * This helper method establishes a connection to the database.
     */
    private void connect() {
        try {
            this.connection = DriverManager.getConnection(MYSQLConnector.host, MYSQLConnector.user, MYSQLConnector.password);
            this.statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("No Connection to DB: " + ex.getMessage());
        }
    }

}