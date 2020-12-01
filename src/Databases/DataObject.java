/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases;

import java.util.UUID;

/**
 * @author Chanel Brown
 */
public abstract class DataObject{

    public static String uuid;


    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }

// ================================ GETTERS ====================================

    public static String getUuid() {
        return DataObject.uuid;
    }


// ================================ SETTERS ====================================

    public void setUuid(String _uuid) {
        this.uuid = _uuid;
    }

}