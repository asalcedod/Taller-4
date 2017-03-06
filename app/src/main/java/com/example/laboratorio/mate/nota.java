package com.example.laboratorio.mate;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class nota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
    }

    public void nota(View view) {
        EditText t1 = (EditText)findViewById(R.id.p1Text1);
        EditText t2 = (EditText)findViewById(R.id.p1Text2);
        EditText t3 = (EditText)findViewById(R.id.p1Text3);
        EditText t4 = (EditText)findViewById(R.id.p1Text4);
        if (t1.getText().toString().equals("")){
            t1.setText("0");
        }
        if (t2.getText().toString().equals("")){
            t2.setText("0");
        }
        if (t3.getText().toString().equals("")){
            t3.setText("0");
        }
        if (t4.getText().toString().equals("")){
            t4.setText("0");
        }
        double valor1=Integer.valueOf(t1.getText().toString());
        double valor2=Integer.valueOf(t2.getText().toString());
        double valor3=Integer.valueOf(t3.getText().toString());
        double valor4=Integer.valueOf(t4.getText().toString());
        double valor=valor1*0.25+valor2*0.25+valor3*0.25+valor4*0.25;
        TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setText("Nota Definitiva: "+valor);
        //Toast.makeText(this,"Nota: "+valor,Toast.LENGTH_LONG).show();
        Intent returnvalor = new Intent();
        returnvalor.putExtra("Nota: ",valor);
        setResult(Activity.RESULT_OK,returnvalor);
        //finish();
    }
}
