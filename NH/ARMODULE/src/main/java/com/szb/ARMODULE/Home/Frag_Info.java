package com.szb.ARMODULE.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.szb.ARMODULE.R;

/**
 * Created by cwh62 on 2017-04-11.
 */

public class Frag_Info extends Fragment
{
    public Frag_Info()
    {
    }

    /*
    //로그인화면 사용시 주석 풀어줄것.
    String str_info_myid;
    TextView txv_info_myid;
    LoginManager loginmanager;
    Player player;
    */

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.frag_info,container, false);

        /*
        //사용자 정보 표시하기

        txv_info_myid = (TextView)layout.findViewById(R.id.textView80);
        //텍스트뷰표시하기 위해 xml에서 아이디 받아오기, 프래그먼트때문에 layout사용.

        loginmanager = LoginManager.getInstance();
        //Realm을 사용해서 저장된 player객체를 불러오기위해 loginmanager 불러오기

        player = loginmanager.getPlayer();
        //player객체 불러오기

        str_info_myid = player.getId().toString();
        //객체에서 id를 받아와서 string으로 변환

        txv_info_myid.setText(str_info_myid);
        //변환한 string id 출력
        */

        return layout;
    }


}