package com.nolhang.nolhang_android;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Created by HwiRiRic on 2017. 2. 8..
 */
public class HomeActivity extends Activity {

    ActionBar actionBar;  //ActionBar 참조변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}