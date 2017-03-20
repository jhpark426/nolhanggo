package com.szb.ARMODULE.model.retrofit;

/**
 * Created by cwh62 on 2017-03-14.
 */

import com.google.gson.annotations.SerializedName;

public class PlayerDTO {
    private String id;
    private String password;
    private String gender;

    @SerializedName("achivement_rate")
    private float achivementrate;
    private String birth;

    @SerializedName("create_time")
    private int createtime;


    public String getId() { return id; }
    public String getPassword() { return password; }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPass() {
        return password;
    }

    @Override
    public String toString(){
        return "GameDTO - id:" + this.id + "/pass:"+this.password;
    }
}
