package com.appspot.thefightingkor.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mc2e on 13. 6. 22..
 */
public class Participant {

    @SerializedName("emblem") String emblemURL;
    @SerializedName("name") String name;
    @SerializedName("image") String imageURL;
    @SerializedName("operator") String operator;
    @SerializedName("date") String date;
    @SerializedName("association") String association;

    public String getEmblemURL() {
        return emblemURL;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getOperator() {
        return operator;
    }

    public String getDate() {
        return date;
    }

    public String getAssociation() {
        return association;
    }

    public void setEmblemURL(String emblemURL) {
        this.emblemURL = emblemURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAssociation(String association) {
        this.association = association;
    }
}
