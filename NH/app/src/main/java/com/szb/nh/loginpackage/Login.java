package com.szb.nh.loginpackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.szb.nh.Home_Main;
import com.szb.nh.R;
import com.szb.nh.model.database.Player;
import com.szb.nh.model.retrofit.PlayerDTO;

public class Login extends AppCompatActivity {

    Button btnSignin;
    LoginManager loginmanager;
    String loginid = "jpark426";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginmanager = LoginManager.getInstance();

        NetworkClient networkClient = NetworkClient.getInstance("http://172.30.1.60:2");

        networkClient.login(loginid,new Callback<PlayerDTO>() {
            @Override
            public void onResponse(Call<PlayerDTO> call, Response<PlayerDTO> response) {
                switch (response.code()){
                    case 200:
                        //json 데이터를 파싱하는 것을 수월하게 해준다.

                        PlayerDTO teamDTO = response.body();

                        Log.e("TAG", "team dto : " + teamDTO.toString());
                        // teamDTO를 이용하여 realm에 team 데이터를 생성한다.
                        loginmanager.create(teamDTO);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<PlayerDTO> call, Throwable t) {
                Log.e("ACC","s?? " + t.getMessage());

            }
        });

        Log.e("TAG", "login???? : " + loginmanager.toString());

  btnSignin = (Button)findViewById(R.id.LoginSignin);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Home_Main.class);
                startActivity(i);
                finish();
            }
        });
    }
}
