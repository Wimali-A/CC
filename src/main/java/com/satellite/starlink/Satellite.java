package com.satellite.starlink;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Satellites")
public class Satellite {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private boolean connected;
    @Field
    private int X_axis;
    @Field
    private int  Y_axis;
    @Field
    private int Z_axis;
    @Field
    private boolean health;

    public Satellite(){

    }

    public Satellite(String name, boolean connected, int xaxis, int yaxis, int zaxis, boolean health) {
        this.name = name;
        this.connected = connected;
        X_axis = xaxis;
        Y_axis = yaxis;
        Z_axis = zaxis;
        this.health = health;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isConnected() {
        return connected;
    }

    public int getXaxis() {
        return X_axis;
    }

    public int getYaxis() {
        return Y_axis;
    }

    public int getZaxis() {
        return Z_axis;
    }

    public boolean isHealth() {
        return health;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void setXaxis(int xaxis) {
        X_axis = xaxis;
    }

    public void setYaxis(int yaxis) {
        Y_axis = yaxis;
    }

    public void setZaxis(int zaxis) {
        Z_axis = zaxis;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }
}

