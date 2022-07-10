package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.EditText;

public class add_grade_activity extends AppCompatActivity {
    TextView tv,tv1;
    EditText edit1, edit2, edit3, edit4, edit5, edit6, edit7 , edit8;
    Spinner spinn1, spinn2, spinn3, spinn4, spinn5, spinn6, spinn7, spinn8;
    double edd1, edd2, edd3, edd4, edd5, edd6, edd7,edd8;
    EditText su1, su2, su3, su4, su5, su6, su7, su8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);


        tv = (TextView)findViewById(R.id.write2) ;
        tv1 = (TextView)findViewById(R.id.goal2);

        edit1 = (EditText) findViewById(R.id.count1);
        edit2 = (EditText) findViewById(R.id.count2);
        edit3 = (EditText) findViewById(R.id.count3);
        edit4 = (EditText) findViewById(R.id.count4);
        edit5 = (EditText) findViewById(R.id.count5);
        edit6 = (EditText) findViewById(R.id.count6);
        edit7 = (EditText) findViewById(R.id.count7);
        edit8 = (EditText) findViewById(R.id.count8);

        spinn1 = (Spinner)findViewById(R.id.spin1);
        spinn2 = (Spinner)findViewById(R.id.spin2);
        spinn3 = (Spinner)findViewById(R.id.spin3);
        spinn4 = (Spinner)findViewById(R.id.spin4);
        spinn5 = (Spinner)findViewById(R.id.spin5);
        spinn6 = (Spinner)findViewById(R.id.spin6);
        spinn7 = (Spinner)findViewById(R.id.spin7);
        spinn8 = (Spinner)findViewById(R.id.spin8);

        su1 =(EditText) findViewById(R.id.subject1);
        su2 =(EditText) findViewById(R.id.subject2);
        su3 =(EditText) findViewById(R.id.subject3);
        su4 =(EditText) findViewById(R.id.subject4);
        su5 =(EditText) findViewById(R.id.subject5);
        su6 =(EditText) findViewById(R.id.subject6);
        su7 =(EditText) findViewById(R.id.subject7);
        su8 =(EditText) findViewById(R.id.subject8);



    }



    public void onClickCaleBtn(View v){
        if(edit1.getText().toString().equals(""))edit1.setText("0");
        if(edit2.getText().toString().equals(""))edit2.setText("0");
        if(edit3.getText().toString().equals(""))edit3.setText("0");
        if(edit4.getText().toString().equals(""))edit4.setText("0");
        if(edit5.getText().toString().equals(""))edit5.setText("0");
        if(edit6.getText().toString().equals(""))edit6.setText("0");
        if(edit7.getText().toString().equals(""))edit7.setText("0");
        if(edit8.getText().toString().equals(""))edit8.setText("0");

        double ed1 =Double.parseDouble(edit1.getText().toString());
        double ed2 =Double.parseDouble(edit2.getText().toString());
        double ed3 =Double.parseDouble(edit3.getText().toString());
        double  ed4 =Double.parseDouble(edit4.getText().toString());
        double  ed5 =Double.parseDouble(edit5.getText().toString());
        double  ed6 =Double.parseDouble(edit6.getText().toString());
        double  ed7 =Double.parseDouble(edit7.getText().toString());
        double  ed8 =Double.parseDouble(edit8.getText().toString());


        String sp1 = spinn1.getSelectedItem().toString();
        String sp2 = spinn2.getSelectedItem().toString();
        String sp3 = spinn3.getSelectedItem().toString();
        String sp4 = spinn4.getSelectedItem().toString();
        String sp5 = spinn5.getSelectedItem().toString();
        String sp6 = spinn6.getSelectedItem().toString();
        String sp7 = spinn7.getSelectedItem().toString();
        String sp8 = spinn8.getSelectedItem().toString();




        if (sp1.equals("A+")){
            edd1 = ed1 * 4.5;
        }
        if (sp1.equals("A")){
            edd1 = ed1 * 4;
        }
        if (sp1.equals("B+")){
            edd1 = ed1 * 3.5;
        }
        if (sp1.equals("B")){
            edd1 = ed1 * 3;
        }

        if (sp1.equals("C+")){
            edd1 = ed1 * 2.5;
        }
        if (sp1.equals("C")){
            edd1 = ed1 * 2;
        }
        if (sp1.equals("D+")){
            edd1 = ed1 * 1.5;
        }
        if (sp1.equals("D")){
            edd1 = ed1 * 1;
        }
        if (sp1.equals("F")){
            edd1 = ed1 * 0;
        }


        if (sp2.equals("A+")){
            edd2 = ed2 * 4.5;
        }
        if (sp2.equals("A")){
            edd2 = ed2 * 4;
        }
        if (sp2.equals("B+")){
            edd2 = ed2 * 3.5;
        }
        if (sp2.equals("B")){
            edd2 = ed2 * 3;
        }

        if (sp2.equals("C+")){
            edd2 = ed2 * 2.5;
        }
        if (sp2.equals("C")){
            edd2 = ed2 * 2;
        }
        if (sp2.equals("D+")){
            edd2 = ed2 * 1.5;
        }
        if (sp2.equals("D")){
            edd2 = ed2 * 1;
        }
        if (sp2.equals("F")){
            edd2 = ed2 * 0;
        }


        if (sp3.equals("A+")){
            edd3 = ed3 * 4.5;
        }
        if (sp3.equals("A")){
            edd3 = ed3 * 4;
        }
        if (sp3.equals("B+")){
            edd3 = ed3 * 3.5;
        }
        if (sp3.equals("B")){
            edd3 = ed3 * 3;
        }

        if (sp3.equals("C+")){
            edd3 = ed3 * 2.5;
        }
        if (sp3.equals("C")){
            edd3 = ed3 * 2;
        }
        if (sp3.equals("D+")){
            edd3 = ed3 * 1.5;
        }
        if (sp3.equals("D")){
            edd3 = ed3 * 1;
        }
        if (sp3.equals("F")){
            edd3 = ed3 * 0;
        }

        if (sp4.equals("A+")){
            edd4 = ed4 * 4.5;
        }
        if (sp4.equals("A")){
            edd4 = ed4 * 4;
        }
        if (sp4.equals("B+")){
            edd4 = ed4 * 3.5;
        }
        if (sp4.equals("B")){
            edd4 = ed4 * 3;
        }

        if (sp4.equals("C+")){
            edd4 = ed4 * 2.5;
        }
        if (sp4.equals("C")){
            edd4 = ed4 * 2;
        }
        if (sp4.equals("D+")){
            edd4 = ed4 * 1.5;
        }
        if (sp4.equals("D")){
            edd4 = ed4 * 1;
        }
        if (sp4.equals("F")){
            edd4 = ed4 * 0;
        }


        if (sp5.equals("A+")){
            edd5 = ed5 * 4.5;
        }
        if (sp5.equals("A")){
            edd5 = ed5 * 4;
        }
        if (sp5.equals("B+")){
            edd5 = ed5 * 3.5;
        }
        if (sp5.equals("B")){
            edd5 = ed5 * 3;
        }

        if (sp5.equals("C+")){
            edd5 = ed5 * 2.5;
        }
        if (sp5.equals("C")){
            edd5 = ed5 * 2;
        }
        if (sp5.equals("D+")){
            edd4 = ed4 * 1.5;
        }
        if (sp5.equals("D")){
            edd5 = ed5 * 1;
        }
        if (sp5.equals("F")){
            edd5 = ed5 * 0;
        }


        if (sp6.equals("A+")){
            edd6 = ed6 * 4.5;
        }
        if (sp6.equals("A")){
            edd6 = ed6 * 4;
        }
        if (sp6.equals("B+")){
            edd6 = ed6 * 3.5;
        }
        if (sp6.equals("B")){
            edd6 = ed6 * 3;
        }

        if (sp6.equals("C+")){
            edd6 = ed6 * 2.5;
        }
        if (sp6.equals("C")){
            edd6 = ed6 * 2;
        }
        if (sp6.equals("D+")){
            edd6 = ed6 * 1.5;
        }
        if (sp6.equals("D")){
            edd6 = ed6 * 1;
        }
        if (sp6.equals("F")){
            edd6 = ed6 * 0;
        }


        if (sp7.equals("A+")){
            edd7 = ed7 * 4.5;
        }
        if (sp7.equals("A")){
            edd7 = ed7 * 4;
        }
        if (sp7.equals("B+")){
            edd7 = ed7 * 3.5;
        }
        if (sp7.equals("B")){
            edd7 = ed7 * 3;
        }

        if (sp7.equals("C+")){
            edd7 = ed7 * 2.5;
        }
        if (sp7.equals("C")){
            edd7 = ed7 * 2;
        }
        if (sp7.equals("D+")){
            edd7 = ed7 * 1.5;
        }
        if (sp7.equals("D")){
            edd7 = ed7 * 1;
        }
        if (sp7.equals("F")){
            edd7 = ed7 * 0;
        }

        if (sp8.equals("A+")){
            edd8 = ed8 * 4.5;
        }
        if (sp8.equals("A")){
            edd8 = ed8 * 4;
        }
        if (sp8.equals("B+")){
            edd8 = ed8 * 3.5;
        }
        if (sp8.equals("B")){
            edd8 = ed8 * 3;
        }

        if (sp8.equals("C+")){
            edd8 = ed8 * 2.5;
        }
        if (sp8.equals("C")){
            edd8 = ed8 * 2;
        }
        if (sp8.equals("D+")){
            edd8 = ed8 * 1.5;
        }
        if (sp8.equals("D")){
            edd8 = ed8 * 1;
        }
        if (sp8.equals("F")){
            edd8 = ed8 * 0;
        }


        double finish = edd1+ edd2+ edd3+ edd4 + edd5 + edd6 + edd7 + edd8  ;
        double ggoal = ed1+ ed2 + ed3 + ed4+ ed5 + ed6 + ed7 + ed8 ;
        double avg = finish / ggoal;



        tv1.setText(String.format("%.0f",ggoal)+ "학점");
        tv.setText(String.valueOf(avg)+ "점");


    }

    public void onClickResetBtn(View v){
        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
        edit4.setText("");
        edit5.setText("");
        edit6.setText("");
        edit7.setText("");
        edit8.setText("");
        su1.setText("");
        su2.setText("");
        su3.setText("");
        su4.setText("");
        su5.setText("");
        su6.setText("");
        su7.setText("");
        su8.setText("");

        tv.setText("0.0점");
        su1.requestFocus();

        spinn1.setSelection(0);
        spinn2.setSelection(0);
        spinn3.setSelection(0);
        spinn4.setSelection(0);
        spinn5.setSelection(0);
        spinn6.setSelection(0);
        spinn7.setSelection(0);
        spinn8.setSelection(0);



        Toast.makeText(this, "초기화되었습니다.",Toast.LENGTH_SHORT).show();
    }




}


