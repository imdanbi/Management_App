package com.example.sd;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;


import com.example.sd.Adapter.CultureAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CultureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CultureFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    LinearLayout info;


    public CultureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CultureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CultureFragment newInstance(String param1, String param2) {
        CultureFragment fragment = new CultureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        protected void onPreExecute(){
            try {
                target = "http://mymg.dothome.co.kr/CultureList.php?studentYear=" + URLEncoder.encode(yearSpinner.getSelectedItem().toString().substring(0, 4), "UTF-8");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(temp+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate(values);
        }


        @Override
        public void onPostExecute(String result){
            try{
                cultureList.clear();
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count =0;
                int studentYear;
                String courseArea;
                String courseTitle;
                String courseGrade;
                while (count< jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    studentYear = object.getInt("studentYear");
                    courseArea = object.getString("courseArea");
                    courseTitle = object.getString("courseTitle");
                    courseGrade = object.getString("courseGrade");

                    Culture culture = new Culture(studentYear, courseArea, courseTitle, courseGrade);
                    cultureList.add(culture);
                    count++;
                    info = (LinearLayout) getView().findViewById(R.id.info);
                    if(studentYear == 2018){
                        info.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog dialog;
                                AlertDialog.Builder builder = new AlertDialog.Builder(CultureFragment.this.getActivity());
                                dialog = builder.setMessage(R.string.c2018)
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                            }
                        });
                    }
                    else if(studentYear == 2019){
                        info.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog dialog;
                                AlertDialog.Builder builder = new AlertDialog.Builder(CultureFragment.this.getActivity());
                                dialog = builder.setMessage(R.string.c2019)
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                            }
                        });
                    }
                    else if(studentYear == 2020){
                        info.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog dialog;
                                AlertDialog.Builder builder = new AlertDialog.Builder(CultureFragment.this.getActivity());
                                dialog = builder.setMessage(R.string.cc2020)
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                            }
                        });
                    }
                    else if(studentYear == 2021){
                        info.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog dialog;
                                AlertDialog.Builder builder = new AlertDialog.Builder(CultureFragment.this.getActivity());
                                dialog = builder.setMessage(R.string.cc2021)
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                            }
                        });
                    }
                }
                if (count ==0){
                    AlertDialog dialog;
                    AlertDialog.Builder builder = new AlertDialog.Builder(CultureFragment.this.getActivity());
                    dialog = builder.setMessage("조회된 정보가 없습니다.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    info.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog dialog;
                            AlertDialog.Builder builder = new AlertDialog.Builder(CultureFragment.this.getActivity());
                            dialog = builder.setMessage(R.string.cc2022)
                                    .setPositiveButton("확인", null)
                                    .create();
                            dialog.show();
                        }
                    });

                }
                adapter.notifyDataSetChanged();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ArrayAdapter yearAdapter;
    private Spinner yearSpinner;

    private ListView ListView;
    private CultureAdapter adapter;
    private List<Culture> cultureList;
    @Override
    public void onActivityCreated(Bundle b){
        super.onActivityCreated(b);
        yearSpinner =(Spinner) getView().findViewById(R.id.yearSpinner);
        yearAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.year, android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);


        ListView =(ListView) getView().findViewById(R.id.ListView);
        cultureList = new ArrayList<Culture>();
        adapter = new CultureAdapter(getContext().getApplicationContext(), cultureList,this);
        ListView.setAdapter(adapter);

        Button searchButton = (Button) getView().findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BackgroundTask().execute();
            }
        });


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_culture, container, false);
        return rootView;
    }
}