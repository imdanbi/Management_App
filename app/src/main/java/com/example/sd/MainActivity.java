package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;
    Button abtn_url;
    Button bbtn_url;
    Button cbtn_url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        abtn_url = findViewById(R.id.btn_url);

        abtn_url.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www4.chosun.ac.kr/acguide/9326/subview.do"));
                startActivity(urlintent);
            }
        });



            bbtn_url = findViewById(R.id.sw_url);

            bbtn_url.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent swintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sw.chosun.ac.kr/home/kor/board.do?menuPos=62"));
                    startActivity(swintent);
                }
            });

        cbtn_url = findViewById(R.id.cu_url);

        cbtn_url.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent swintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sw.chosun.ac.kr/home/kor/board.do?menuPos=62"));
                startActivity(swintent);
            }
        });






        final Button CourseButton = (Button) findViewById(R.id.CourseButton);
        final Button statisticsButton = (Button) findViewById(R.id.statisticsButton);
        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final Button MemoButton = (Button) findViewById(R.id.MemoButton);
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);

        CourseButton.setOnClickListener(new View.OnClickListener() {       //강의 클릭시
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                CourseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                MemoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new CourseFragment());
                fragmentTransaction.commit();



            }
        });
        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                CourseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                MemoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new StatisticsFragment());
                fragmentTransaction.commit();



            }
        });
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                CourseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                MemoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();



            }
        });
        MemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                CourseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                MemoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new MemoFragment());
                fragmentTransaction.commit();



            }
        });




    }
}