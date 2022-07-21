package com.example.sd;



import static com.example.sd.MemoFragment.ADD_NODE_REQUEST;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class StatisticsFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public StatisticsFragment() {

    }


    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    ImageView add_course, empty_imageview;
    TextView no_data;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    MyDatabaseHelper myDB;
    ArrayList<String> grade_id,grade_subject, grade_grade, grade_school;
    CustomAdapter customAdapter;



    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        add_course = (ImageView) getView().findViewById(R.id.add_course);


        recyclerView = (RecyclerView)getView().findViewById(R.id.recyclerView);
        add_button = (FloatingActionButton) getView().findViewById(R.id.add_button);
        empty_imageview = (ImageView) getView().findViewById(R.id.empty_imageview);
        no_data = (TextView) getView().findViewById(R.id.no_data);


        add_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), add_grade_activity.class);
                startActivityForResult(intent,ADD_NODE_REQUEST);
            }
        });


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Add_activity.class);
                startActivityForResult(intent,ADD_NODE_REQUEST);
            }
        });

        myDB = new MyDatabaseHelper(getActivity());
        grade_id = new ArrayList<>();
        grade_subject = new ArrayList<>();
        grade_grade = new ArrayList<>();
        grade_school = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(getActivity(),getActivity(), grade_id, grade_subject, grade_grade,grade_school);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readALLData();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                grade_id.add(cursor.getString(0));
                grade_subject.add(cursor.getString(1));
                grade_grade.add(cursor.getString(2));
                grade_school.add(cursor.getString(3));

            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menuInflater.inflate(R.menu.grade_menu, menu);
    }*/


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            setRetainInstance(true);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_statistics, container, false);

        return rootView;
    }


}