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
public abstract class DataObject extends DataFactory {

    protected final String dataTable = "";
    protected int id;
    protected String uuid;
    protected boolean active = true;

    public DataObject() {
        this.setUuid(DataObject.generateUuid());
    }
    public void makeActive() {
        this.active = true;
    }

    public void makeInactive() {
        this.active = false;
    }

    protected static String generateUuid() {
        return UUID.randomUUID().toString();
    }

// ================================ GETTERS ====================================
  
    public String getUuid() {
        return this.uuid;
    }

    public int getId() {
        return this.id;
    }

// ================================ SETTERS ====================================

    public void setUuid(String _uuid) {
        this.uuid = _uuid;
    }

    public void setId(int _id) {
        this.id = _id;
    }

}