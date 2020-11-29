/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Databases.SearchData;
import Databases.DataObject;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author cah
 */
public class SearchTest {
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        SearchData search = new SearchData();
//        search.setType("single");
        search.setRoom(103);
        search.save();
        
    }
}
