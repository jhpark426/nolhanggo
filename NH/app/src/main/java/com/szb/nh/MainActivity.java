package com.szb.nh;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.szb.nh.loginpackage.Login;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    Button btnLogin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.Login);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Intent i = new Intent();
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                i.setComponent(new ComponentName("com.szb.nh.loginpackage", "com.szb.nh.loginpackage.Login"));
//                startActivity(i);
//                finish();
                intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
