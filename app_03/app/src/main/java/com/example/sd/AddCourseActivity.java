package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class AddCourseActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private Context context;
    private Spinner daySpinner;
    private TextView startTv;
    private TextView endTv;
    int startHour = 0, startMinute = 0;
    int endHour = 0, endMinute = 0;
    Button add;
    Button no;
    TextView id;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        id = findViewById(R.id.id);
        id.setText(userID);
        final EditText  subject = (EditText) findViewById(R.id.subject);
        final EditText professor = (EditText) findViewById(R.id. professor);
        final EditText  place = (EditText) findViewById(R.id.place);

        add = findViewById(R.id.add);
        no  = findViewById(R.id.no);

        daySpinner =(Spinner) findViewById(R.id.day_spinner);//요일정하기
        adapter = ArrayAdapter.createFromResource(this, R.array.day, android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(adapter);

        startTv = findViewById(R.id.start_time);
        endTv = findViewById(R.id.end_time);
        startTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddCourseActivity.this, android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        startTv.setText(hourOfDay+":"+minute);

                    }
                },startHour, startMinute, false);
                timePickerDialog.show();
            }
        });
        endTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddCourseActivity.this, android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        endTv.setText(hourOfDay+":"+minute);

                    }
                },endHour, endMinute, false);
                timePickerDialog.show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String courseTitle = subject.getText().toString();
                String courseProfessor = professor.getText().toString();
                String courseRoom =place.getText().toString();
                String day = daySpinner.getSelectedItem().toString();
                String startTime = startTv.getText().toString();
                String endTime = endTv.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent1 = new Intent( AddCourseActivity.this, MainActivity.class);
                                AddCourseActivity.this.startActivity(intent1);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                CourseAddRequest courseAddRequest = new CourseAddRequest( userID, courseTitle, courseProfessor, courseRoom,day, startTime,endTime,responseListener);
                RequestQueue queue = Volley.newRequestQueue(AddCourseActivity.this);
                queue.add(courseAddRequest);
            }

        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent( AddCourseActivity.this, MainActivity.class);
                AddCourseActivity.this.startActivity(intent1);
            }
        });


    }


}