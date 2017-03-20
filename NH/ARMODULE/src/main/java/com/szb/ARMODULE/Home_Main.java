package com.szb.ARMODULE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class Home_Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__main);

    }
    public void onClick(View v){
        startActivity(new Intent(Home_Main.this,GameActivity.class));

    }
}
