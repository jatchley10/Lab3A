package com.example.lab3a_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.*;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int count = 0;
    public int decCount = 0;
    public String expression = "";
    public void numKeyPressed(View v){
        String buttonText = ((Button) v).getText().toString();
        TextView window = (TextView) findViewById(R.id.outputView);
        //Removing the leading zero pre-poopulated in the window
        if(count == 0){
            window.setText(buttonText);
            expression = buttonText;
            count += 1 ;
        }
        else{
            window.append(buttonText);
            expression += buttonText;
        }
    }

    public void clearBtnPressed(View v){
        TextView window = (TextView) findViewById(R.id.outputView);
        window.setText("0");
        expression = "";
        count = 0;
        decCount = 0;
    }

    public void sqRtButtonPressed(View v){

    }


    public void decPressed(View v){
        TextView window = (TextView) findViewById(R.id.outputView);

        if(decCount < 1){
            window.append(".");
            expression += ".";
            decCount += 1;
        }
    }
    //Change later to evaluate expression
    public void equalPressed(View v){
        TextView window = (TextView) findViewById(R.id.outputView);

        window.setText(expression);
    }


    public void operatorBtnPressed(View v){
        TextView window = (TextView) findViewById(R.id.outputView);
        String buttonText = ((Button) v).getText().toString();
        expression += buttonText;
        window.setText("");
    }

    public void flipSign(View v){
        TextView window = (TextView) findViewById(R.id.outputView);

        int numToCon = Integer.parseInt(window.getText().toString());

        if(numToCon > 0){
            numToCon = -numToCon;
            window.setText(Integer.toString(numToCon));
        }
        else{
            window.setText(Integer.toString(Math.abs(numToCon)));
        }
    }

    public void sqrtPressed(View v){
        TextView window = (TextView) findViewById(R.id.outputView);
        double numToSquare = Double.parseDouble(window.getText().toString());

        window.setText(Double.toString(Math.sqrt(numToSquare)));
    }
}
