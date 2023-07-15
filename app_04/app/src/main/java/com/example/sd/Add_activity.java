package com.example.sd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_activity extends AppCompatActivity {

    EditText input1,input2;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_activity.this);
                myDB.addGrade(input1.getText().toString().trim(),
                        input2.getText().toString().trim());
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grade_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.delete_all:
                confirmDialog();
                break;
            case R.id.Quiz:
                Intent i = new Intent(this, pplus_activity__.class);
                startActivity(i);
                break;



        /*if(item.getItemId() == R.id.delete_all){
            Toast.makeText(this,"모든 항목이 삭제됩니다.",Toast.LENGTH_SHORT).show();
            confirmDialog();

            /*Intent intent = new Intent(this, StatisticsFragment.class);
            startActivity(intent);
            finish();*/
        }
        return super.onOptionsItemSelected(item);
    }


    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete ALL ?");
        builder.setMessage("모든 항목을 삭제하시겠습니까?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_activity.this);
                myDB.deleteALLData();
                recreate();
                finish();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }



}