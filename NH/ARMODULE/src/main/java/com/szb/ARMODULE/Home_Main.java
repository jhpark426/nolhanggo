package com.szb.ARMODULE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Home_Main extends FragmentActivity {

    final String[] data ={"information","quest","setting"};
    final String[] fragments ={
            "com.szb.ARMODULE.information.Information",
            "com.szb.ARMODULE.quest.Quest",
            "com.szb.ARMODULE.setting.Setting"};


    private DrawerLayout dlDrawer;
    private ActionBarDrawerToggle dtToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Log.d("debug", "action bar " + getActionBar());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data);

        final DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        final ListView navList = (ListView) findViewById(R.id.drawer);

//        final TextView toolbar_textview = (TextView) findViewById(R.id.toolbar_textview);
//        final ImageView toolbar_image = (ImageView) findViewById(R.id.toobar_image);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        navList.setAdapter(adapter);
        navList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int pos, long id) {
                drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                        Log.d("debug", "action bar " + getActionBar());
//                        Log.d("debug", "tool bar " + toolbar);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                        Log.v("debug", "position : " + pos);
                        Log.v("debug", "fragment : " + fragments[pos]);
                        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
                        toolbar.setTitle(data[pos]);
//                        toolbar_textview.setText(data[pos]);
//                        toolbar_image.setImageResource(R.drawable.ic_drawer);

                        tx.replace(R.id.main, Fragment.instantiate(Home_Main.this, fragments[pos]));
//                        tx.replace(R.id.main, Fragment.instantiate(MainActivity.this, fragments[pos]));
                        tx.commit();
                    }

                });
                drawer.closeDrawer(navList);
            }
        });
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.main, Fragment.instantiate(Home_Main.this, fragments[0]));
        tx.commit();
        toolbar.setTitle(data[0]);

    }

    public void onClick(View v){
        startActivity(new Intent(Home_Main.this,GameActivity.class));

    }
}
