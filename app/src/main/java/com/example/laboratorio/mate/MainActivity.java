package com.example.laboratorio.mate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    String[] lista=new String[] {"Materia 1","","","",""};
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.materias);
        ArrayAdapter<String> adapte = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adapte);
        final Intent i = new Intent(this,nota.class);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivityForResult(i,1);
            }
        });
    }

    public void add(View view) {
        lista[i]="Materia "+(i+1);
        ArrayAdapter<String> adapte = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adapte);
        i++;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if (resultCode==RESULT_OK){
                double nota=data.getDoubleExtra("Nota: ",0);
                Toast.makeText(this,"Nota: "+nota,Toast.LENGTH_LONG).show();
            }
        }
    }
}
