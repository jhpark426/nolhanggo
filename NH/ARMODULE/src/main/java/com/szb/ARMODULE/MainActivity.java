package com.szb.ARMODULE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.szb.ARMODULE.loginpackage.Login;

public class MainActivity extends Activity {
    private Intent intent;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.Login);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }

}
