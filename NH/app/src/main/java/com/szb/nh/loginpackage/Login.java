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

public class Login extends AppCompatActivity {

    Button btnSignin;
     teamManager;
    String loginid = "jpark426";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        teamManager = TeamManager.getInstance();

        NetworkClient networkClient = NetworkClient.getInstance("http://172.30.1.60:2");

        networkClient.login(loginid,new Callback<TeamDTO>() {
            @Override
            public void onResponse(Call<TeamDTO> call, Response<TeamDTO> response) {
                switch (response.code()){
                    case 200:
                        //json 데이터를 파싱하는 것을 수월하게 해준다.

                        TeamDTO teamDTO = response.body();

                        Log.e("TAG", "team dto : " + teamDTO.toString());
                        // teamDTO를 이용하여 realm에 team 데이터를 생성한다.
                        teamManager.create(teamDTO);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<TeamDTO> call, Throwable t) {
                Log.e("ACC","s?? " + t.getMessage());

            }
        });

        Log.e("TAG", "login???? : " + teamManager.toString());

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
