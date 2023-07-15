package com.example.sd;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sd.Question;
import com.example.sd.R;

public class pplus_activity__ extends AppCompatActivity implements View.OnClickListener{
    TextView total, question;
    Button answer1, answer2, answer3, answer4 ;
    Button submitbt;

    int score = 0;
    int totalquestion = Question.question.length;
    int curquestion = 0;
    String select = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pplus);

        total = findViewById(R.id.total);
        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        submitbt = findViewById(R.id.submitbt);

        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);
        submitbt.setOnClickListener(this);

        total.setText("남은 문제 수 : "+ totalquestion);


        new_change();

    }

    @Override
    public void onClick(View view){
        answer1.setBackgroundColor(Color.WHITE);
        answer2.setBackgroundColor(Color.WHITE);
        answer3.setBackgroundColor(Color.WHITE);
        answer4.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId() == R.id.submitbt){
            if(select.equals(Question.correct[curquestion])){
                score = score + 1;
            }
            curquestion++;
            new_change();
        }else{
            select = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.LTGRAY);
        }

    }
    void new_change(){

        if(curquestion == totalquestion){
            finishfi();
            return;
        }
        question.setText(Question.question[curquestion]);
        answer1.setText(Question.answers[curquestion][0]);
        answer2.setText(Question.answers[curquestion][1]);
        answer3.setText(Question.answers[curquestion][2]);
        answer4.setText(Question.answers[curquestion][3]);
    }
    void finishfi(){
        String stst = "";
        if(score > totalquestion * 0.60){
            stst = "통과";
        }else{
            stst = "다시 공부하세요.";
        }
        new AlertDialog.Builder(this).setTitle(stst).setMessage("점수 : " +score)
                .setPositiveButton("한번 더",(dialogInterface, i) -> one_more() )
                .setNegativeButton("취소",((dialogInterface, i) -> blank()))
                .show();
    }

    void one_more(){
        score = 0;
        curquestion =0;
        new_change();
    }
    void blank(){

    }
}