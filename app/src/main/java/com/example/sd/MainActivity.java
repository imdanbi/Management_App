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
    Button mbtn_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        noticeListView =(ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("공지사항입니다","follow me","2022-07-22"));
        noticeList.add(new Notice("공지사항입니다","follow me","2022-07-22"));
        noticeList.add(new Notice("공지사항입니다","follow me","2022-07-22"));
        noticeList.add(new Notice("공지사항입니다","follow me","2022-07-22"));
        noticeList.add(new Notice("공지사항입니다","follow me","2022-07-22"));
        noticeList.add(new Notice("공지사항입니다","follow me","2022-07-22"));
        adapter = new NoticeListAdapter(getApplicationContext(),noticeList);
        noticeListView.setAdapter(adapter);

        mbtn_url = findViewById(R.id.btn_url);

        mbtn_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www4.chosun.ac.kr/acguide/9326/subview.do"));
                startActivity(urlintent);
            }
        });

        final Button CourseButton = (Button) findViewById(R.id.CourseButton);
        final Button statisticsButton = (Button) findViewById(R.id.statisticsButton);
        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);

        CourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                CourseButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary_dark));
                statisticsButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
                scheduleButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
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
                CourseButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
                statisticsButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary_dark));
                scheduleButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
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
                CourseButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
                statisticsButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
                scheduleButton.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary_dark));
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();



            }
        });




    }
}