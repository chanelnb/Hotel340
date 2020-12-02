/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.lang.reflect.InvocationTargetException;
import Databases.UserModel;

/**
 *
 * @author chanel Brown
 */
public class UserTest {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        runUserTest();
    }
    
    public static void runUserTest() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        UserModel newUser = new UserModel();
        newUser.setFirstName("Hannah");
        newUser.setLastName("Montana");
        newUser.setAddress("Best of both worlds way");
        newUser.setPhoneNumber(413);
        newUser.setEmail("Montana@disney.com");
        newUser.setUsername("Miley Cyrus");
        System.out.println("Miley Cyrus UUID: " + newUser.getUuid());
        System.out.println(newUser.getUsername() + " Also known as " + newUser.getFirstName() + " " + newUser.getLastName());
  
    }
    
    
}
