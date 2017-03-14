package com.szb.nh.model.database;

/**
 * Created by cwh62 on 2017-03-14.
 */
import io.realm.RealmObject;

public class Player extends RealmObject {
    private String id;
    private String password;
    private String gender;

    private float achivementrate;
    private String birth;

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
