package com.szb.ARMODULE.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.szb.ARMODULE.GameActivity;
import com.szb.ARMODULE.R;


public class Home_Main extends AppCompatActivity {

    ViewPager viewpager;
    ConstraintLayout top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        viewpager = (ViewPager)findViewById(R.id.viewpager);
        top = (ConstraintLayout) findViewById(R.id.top);



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
        bt_info.setOnClickListener(movePageListener);
        bt_info.setTag(2);
        bt_rank.setOnClickListener(movePageListener);
        bt_rank.setTag(3);

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
        public pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Frag_Quiz();
                case 1:
                    return new Frag_Home();
                case 2:
                    return new Frag_Info();
                case 3:
                    return new Frag_Rank();
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
    public void onARClick(View view) {
        onPause();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

    }



}

