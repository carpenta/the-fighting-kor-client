package com.appspot.thefightingkor.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mc2e on 13. 7. 14..
 */
public class Player {

    @SerializedName("id") private String id;
    @SerializedName("name") private String name;
    @SerializedName("association") private String assoc;
    @SerializedName("weight") private String weight;
    @SerializedName("grade") private String grade;
    @SerializedName("group") private String group;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAssoc() {
        return assoc;
    }

    public String getWeight() {
        return weight;
    }

    public String getGrade() {
        return grade;
    }

    public String getGroup() {
        return group;
    }
}
