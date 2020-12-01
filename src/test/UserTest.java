/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Databases.UserModel;
import Databases.MYSQLConnector;
/**
 *
 * @author cah
 */
public class UserTest {
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

        MYSQLConnector mysqlconnector = new MYSQLConnector();
        UserModel users = new UserModel();
        users.setUsername("Nel");
        users.setPassword("Brown");
        users.save();
        
        mysqlconnector.checkUser(users.getUsername(), users.getPassword());
    
    }
    
}
