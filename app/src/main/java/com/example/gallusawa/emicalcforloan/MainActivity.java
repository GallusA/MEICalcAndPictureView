package com.example.gallusawa.emicalcforloan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tView1,tView2,tView3,tView4,tView5;

    SeekBar sBar, sBar2, sBar3;
    double amount;//car cost
    double rate;//interest rate of the loan
    double year;//year of the loan
    double emi;//total payment of the loan


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tView1 = (TextView) findViewById(R.id.tv1);
        tView2 = (TextView) findViewById(R.id.tv2);
        tView3 = (TextView) findViewById(R.id.tv3);
        tView4 = (TextView) findViewById(R.id.tv4);
        tView5 = (TextView) findViewById(R.id.tv5);

        sBar = (SeekBar) findViewById(R.id.seekBar);
        sBar2 = (SeekBar) findViewById(R.id.seekBar2);
        sBar3 = (SeekBar) findViewById(R.id.seekBar3);


        //Loan Interest Rate
        sBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tView2.setText(String.valueOf(progress + " %"));
                rate = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Laon life Years
        sBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tView3.setText(String.valueOf(progress +" Years"));
                year = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //Loan Amount
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tView1.setText(String.valueOf("$ " + progress));
                amount = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    //result onClick
    public void result(View view) {
        rate = rate / (12*100);
        year = year * 12;
        emi = (amount * rate * Math.pow(1 + rate, year)) / (Math.pow(1 + rate, year) - 1);

        tView5.setText("$ " +emi + "");

    }


    public void onReset(View view) {

      tView2.setText(""); tView3.setText("");  tView1.setText(""); tView5.setText("");

        sBar.setProgress(0); sBar2.setProgress(0); sBar3.setProgress(0);


    }

    public void next(View view) {
        Intent i = new Intent(this, Main2Activity.class);

        startActivity(i);
    }
}
