/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Databases.User;

/**
 *
 * @author cah
 */
public class UserTest {
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

        User users = new User();
        users.setName("Nel");
        users.save();
    
    }
    
}
