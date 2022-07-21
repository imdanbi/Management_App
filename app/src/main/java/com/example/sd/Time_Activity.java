package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class Time_Activity extends AppCompatActivity {
    TextView timer_text;
    EditText set_text;
    TextView set_time;
    Button set_button, start_button, reset_button;

    private CountDownTimer countdowntimer;

    private boolean run_time;

    private long start_time, left_time, end_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);


        timer_text= findViewById(R.id.timer_text);
        set_text = findViewById(R.id.set_text);
        set_time = findViewById(R.id.set_time);
        set_button = findViewById(R.id.set_button);
        start_button = findViewById(R.id.start_button);
        reset_button = findViewById(R.id.reset_button);


        set_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = set_text.getText().toString();
                if (input.length() == 0) {
                    Toast.makeText(Time_Activity.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                long millisInput = Long.parseLong(input) * 60000;
                if (millisInput == 0) {
                    Toast.makeText(Time_Activity.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                    return;
                }

                setTime(millisInput);
                set_text.setText("");
            }
        });

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (run_time) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void setTime(long milliseconds) {
        start_time = milliseconds;
        resetTimer();
        closeKeyboard();
    }

    private void startTimer() {
        end_time = System.currentTimeMillis() +left_time;

        countdowntimer = new CountDownTimer(left_time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                left_time = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                run_time = false;
                updateWatchInterface();
            }
        }.start();

        run_time = true;
        updateWatchInterface();
    }

    private void pauseTimer() {
        countdowntimer.cancel();
        run_time = false;
        updateWatchInterface();
    }

    private void resetTimer() {
        left_time = start_time;
        updateCountDownText();
        updateWatchInterface();
    }

    private void updateCountDownText() {
        int hours = (int) (left_time / 1000) / 3600;
        int minutes = (int) ((left_time / 1000) % 3600) / 60;
        int seconds = (int) (left_time / 1000) % 60;

        String timeLeftFormatted;
        if (hours > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }

        set_time.setText(timeLeftFormatted);
    }

    private void updateWatchInterface() {
        if (run_time) {
            timer_text.setVisibility(View.VISIBLE);
            set_text.setVisibility(View.INVISIBLE);
            set_button.setVisibility(View.INVISIBLE);
            reset_button.setVisibility(View.INVISIBLE);
            start_button.setText("정지");
        } else {
            timer_text.setVisibility(View.INVISIBLE);
            set_text.setVisibility(View.VISIBLE);
            set_button.setVisibility(View.VISIBLE);
            start_button.setText("시작");

            if (left_time < 1000) {
                start_button.setVisibility(View.INVISIBLE);
            } else {
                start_button.setVisibility(View.VISIBLE);
            }

            if (left_time < start_time) {
                reset_button.setVisibility(View.VISIBLE);
            } else {
                reset_button.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("startTimeInMillis", start_time);
        editor.putLong("millisLeft", left_time);
        editor.putBoolean("timerRunning", run_time);
        editor.putLong("endTime", end_time);

        editor.apply();

        if (countdowntimer != null) {
            countdowntimer.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        start_time = prefs.getLong("startTimeInMillis", 600000);
        left_time = prefs.getLong("millisLeft", start_time);
        run_time = prefs.getBoolean("timerRunning", false);

        updateCountDownText();
        updateWatchInterface();

        if (run_time) {
            end_time = prefs.getLong("endTime", 0);
            left_time = end_time - System.currentTimeMillis();

            if (left_time < 0) {
                left_time = 0;
                run_time = false;
                updateCountDownText();
                updateWatchInterface();
            } else {
                startTimer();
            }
        }
    }
}