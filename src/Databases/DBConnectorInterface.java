/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases;

/**
 *The DBConnectorInterface interface describes the methods that must be implemented for
 * any database class that is expected to work with this system.
 * The basic CRUD operations are detailed below, but more advanced features,
 * including loading by name, uuid, id or type can be added.
 * @author chanel
 * @author ike
 */

import java.util.HashMap;
import java.util.Map;


public interface DBConnectorInterface {

    public abstract int createObject(Map<String,String> _keyValuePairs, String _table);

    public abstract HashMap<String, Object> readObject(Map<String,String> _keyValuePairs, String _table);

    public abstract Boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table);

    public abstract Boolean deleteObject(String uuid);

}