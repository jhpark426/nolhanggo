package com.szb.ARMODULE;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Home_Main extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
    }
    public void onClick(View view){
        intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }
}
