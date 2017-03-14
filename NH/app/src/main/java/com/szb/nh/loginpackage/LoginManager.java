package com.szb.nh.loginpackage;

/**
 * Created by cwh62 on 2017-03-14.
 */
import android.util.Log;

import com.szb.nh.model.database.Player;
import com.szb.nh.model.retrofit.PlayerDTO;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class LoginManager {
    private String id;
    private String password;
    private String gender;

    private float achivementrate;
    private String birth;

    private int createtime;

    Realm realm;

    private static LoginManager instance = null;

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return password;
    }


    public LoginManager(){

        realm = Realm.getDefaultInstance();
        Player team = getTeam();
        if(team != null){
            setTeam(team);
        }
        Log.e("ACC","TEAM MANAGER PROPERTY !!!!!             "+this.toString());
    }

    public static LoginManager getInstance(){
        if(instance == null){
            instance = new LoginManager();
        }
        return instance;
    }

    public void setTeam(Player team){
        this.id = team.getId();
        this.password = team.getPass();
    }

    public Player getTeam(){
        Player team = realm.where(Player.class).findFirst();
        Log.e("ACC","TEAM INFORMATION IS !!! "+team);
        return team;
    }


    public void create(final PlayerDTO playerDTO){
        final Player player = new Player();
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm tRealm) {
                try {
                    player.setId(playerDTO.getId());
                    player.setPassword(playerDTO.getPassword());
                    realm.copyToRealm(player);
                } catch (RealmPrimaryKeyConstraintException e){
                    Log.e("debug", e.toString());
                }
            }
        });
        setTeam(player);
    }

    public void deletePlayer(){
        id = "";
        password = "";

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(Player.class);
            }
        });
    }

    @Override
    public String toString() {
        String content = "";
        content += "team Id ??? "+ id + "\n";
        content += "pass ??? "+ password + "\n";

        return content;
    }
}