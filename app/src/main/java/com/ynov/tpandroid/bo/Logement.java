package com.ynov.tpandroid.bo;

import android.media.Image;

import org.json.JSONArray;
import org.json.JSONObject;

public class Logement {
    private String title;
    private Ville place;
    private Number price;
    private Image pic;
    private String owner;
    private String description;
    private Number lat;
    private Number lng;
    private JSONObject listDateAvailable;

    public Logement(String title, Ville ville, Number price, Image pic, String owner, String description, Number lat, Number lng, JSONObject listDateAvailable) {
        this.title = title;
        this.place = ville;
        this.price = price;
        this.pic = pic;
        this.owner = owner;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.listDateAvailable = listDateAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Ville getPlace() {
        return place;
    }

    public void setPlace(Ville ville) {
        this.place = ville;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Image getPic() {
        return pic;
    }

    public void setPic(Image pic) {
        this.pic = pic;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Number getLat() {
        return lat;
    }

    public void setLat(Number lat) {
        this.lat = lat;
    }

    public Number getLng() {
        return lng;
    }

    public void setLng(Number lng) {
        this.lng = lng;
    }

    public JSONObject getListDateAvailable() {
        return listDateAvailable;
    }

    public void setListDateAvailable(JSONObject listDateAvailable) {
        this.listDateAvailable = listDateAvailable;
    }
}
