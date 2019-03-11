package com.example.brucenigelpvilo.semifinal;

import android.app.Activity;

public class location {
    String location_id,db_latitude,db_longtitude,db_places;
public location(){

}
    public location(String location_id, String db_latitude, String db_longtitude, String db_places) {
        this.location_id = location_id;
        this.db_latitude = db_latitude;
        this.db_longtitude = db_longtitude;
        this.db_places = db_places;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getDb_latitude() {
        return db_latitude;
    }

    public void setDb_latitude(String db_latitude) {
        this.db_latitude = db_latitude;
    }

    public String getDb_longtitude() {
        return db_longtitude;
    }

    public void setDb_longtitude(String db_longtitude) {
        this.db_longtitude = db_longtitude;
    }

    public String getDb_places() {
        return db_places;
    }

    public void setDb_places(String db_places) {
        this.db_places = db_places;
    }
}
