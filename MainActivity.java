package com.subham99.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void generate(int value) {
        ArrayList<String> tables = new ArrayList<String>();
        for (int j = 2; j <= 12; j++) {
            int product = value * j;
            String ans = ""+value+" * "+j+" = "+product;
            tables.add(ans);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.row, tables);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Value", Integer.toString(value));
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar timeseekBar = findViewById(R.id.timeseekBar);
         listView = findViewById(R.id.listView);

        timeseekBar.setMax(100);
        timeseekBar.setProgress(10);

        timeseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int min = 1;
            int value ;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                if (i<min)
                {
                    value = min;
                }else{
                    value = i;
                }
                generate(value);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}