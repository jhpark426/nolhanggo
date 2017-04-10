package com.szb.ARMODULE.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.szb.ARMODULE.GameActivity;
import com.szb.ARMODULE.R;


public class Home_Main extends AppCompatActivity {

    ViewPager viewpager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        viewpager = (ViewPager)findViewById(R.id.viewpager);


        Button bt_menu_open = (Button)findViewById(R.id.bt_menu_open);
        viewpager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        viewpager.setCurrentItem(1);

        bt_menu_open.setOnClickListener(movePageListener);
        bt_menu_open.setTag(0);
    }

    View.OnClickListener movePageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();
            viewpager.setCurrentItem(tag);
        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MenuFragment2();
                case 1:
                    return new MenuFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

    }
    public void onARClick(View view) {
        onPause();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

    }



}

