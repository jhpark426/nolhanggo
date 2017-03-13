package com.szb.nh;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__main);
    }

    public void onClick(View v){
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(new ComponentName("com.szb.ARMODULE", "com.szb.ARMODULE.UnityPlayerNativeActivity"));
        startActivity(intent);
    }
    public void Touching(){
        Toast.makeText(this, "Sc", Toast.LENGTH_SHORT).show();
    }
}
