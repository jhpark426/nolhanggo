package com.szb.ARMODULE.Home;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.szb.ARMODULE.GameActivity;
import com.szb.ARMODULE.R;


public class Home_Main extends AppCompatActivity {

    ViewPager viewpager;
    ConstraintLayout top;

    Toolbar toolbar;
    DrawerLayout dlDrawer;
    ActionBarDrawerToggle dtToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        dtToggle = new ActionBarDrawerToggle(this, dlDrawer,R.string.open_drawer,R.string.close_drawer);
        dlDrawer.addDrawerListener(dtToggle);

        viewpager = (ViewPager)findViewById(R.id.viewpager);
        top = (ConstraintLayout) findViewById(R.id.tap_bar);

        ImageView bt_home = (ImageView)findViewById(R.id.bt_home);
        ImageView bt_quiz = (ImageView)findViewById(R.id.bt_quiz);
        ImageView bt_info = (ImageView)findViewById(R.id.bt_info);
        ImageView bt_rank = (ImageView)findViewById(R.id.bt_rank);

        viewpager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        viewpager.setCurrentItem(0);

        bt_home.setOnClickListener(movePageListener);
        bt_home.setTag(0);
        bt_quiz.setOnClickListener(movePageListener);
        bt_quiz.setTag(1);
        bt_rank.setOnClickListener(movePageListener);
        bt_rank.setTag(2);
        bt_info.setOnClickListener(movePageListener);
        bt_info.setTag(3);

        bt_home.setSelected(true);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
            }
            @Override
            public void onPageSelected(int position)
            {
                int i = 0;
                while(i<4)
                {
                    if(position==i)
                    {
                        top.findViewWithTag(i).setSelected(true);
                    }
                    else
                    {
                        top.findViewWithTag(i).setSelected(false);
                    }
                    i++;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

    }



    View.OnClickListener movePageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();
            int i = 0;
            while(i<4)
            {
                if(tag==i)
                {
                    top.findViewWithTag(i).setSelected(true);
                }
                else
                {
                    top.findViewWithTag(i).setSelected(false);
                }
                i++;
            }

            viewpager.setCurrentItem(tag);
        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter {
        private pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Frag_Home();
                case 1:
                    return new Frag_Quiz();
                case 2:
                    return new Frag_Rank();
                case 3:
                    return new Frag_Info();
                default:
                    return null;
            }
        }

        @Override
        public int getCount()
        {
            return 4;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        dtToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dtToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.camera_button) {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            return true;
        }
        else if(dtToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

