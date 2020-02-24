package com.example.lab3a_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.*;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView window = (TextView) findViewById(R.id.outputView);
        window.setText("0");
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
        String operator = "";
        String[] splitExpression = new String[3];

        String result = "";

        if(expression.contains("+")){
            splitExpression = expression.split("\\+");

            BigDecimal left = new BigDecimal(splitExpression[0]);
            BigDecimal right = new BigDecimal(splitExpression[1]);

            result = left.add(right).toString();
            expression = result;
        }

        else if(expression.contains("\u2212")){
            splitExpression = expression.split("\u2212");

            BigDecimal left = new BigDecimal(splitExpression[0]);
            BigDecimal right = new BigDecimal(splitExpression[1]);
            result = left.subtract(right).toString();
            expression = result;
        }

        else if(expression.contains("\u00d7")){
            splitExpression = expression.split("\u00d7");

            BigDecimal left = new BigDecimal(splitExpression[0]);
            BigDecimal right = new BigDecimal(splitExpression[1]);
            result = left.multiply(right).toString();
            expression = result;
        }

        else{
            splitExpression = expression.split("\u00f7");

            BigDecimal left = new BigDecimal(splitExpression[0]);
            BigDecimal right = new BigDecimal(splitExpression[1]);
            result = left.divide(right).toString();
            expression = result;
        }



        window.setText(result);

    }


    public void operatorBtnPressed(View v){
        TextView window = (TextView) findViewById(R.id.outputView);
        String buttonText = ((Button) v).getText().toString();
        expression += buttonText;
        window.setText("");
    }

    public void flipSign(View v){
        TextView window = (TextView) findViewById(R.id.outputView);
        String originalNum = window.getText().toString();


        int numToCon = Integer.parseInt(window.getText().toString());

        if(numToCon > 0){
            numToCon = -numToCon;
            expression.replace(originalNum, Integer.toString(numToCon));
            window.setText(Integer.toString(numToCon));
        }
        else{
            expression.replace(originalNum, Integer.toString(Math.abs(numToCon)));
            window.setText(Integer.toString(Math.abs(numToCon)));
        }
    }

    public void sqrtPressed(View v){
        TextView window = (TextView) findViewById(R.id.outputView);
        double numToSquare = Double.parseDouble(window.getText().toString());

        window.setText(Double.toString(Math.sqrt(numToSquare)));
    }

    public void testExpression(View v){
        TextView window = (TextView) findViewById(R.id.outputView);
        window.setText(expression);
    }

    public void pctPressed(View v){
        TextView window = (TextView) findViewById(R.id.outputView);

        BigDecimal x = new BigDecimal(window.getText().toString());

        x = x.divide(new BigDecimal(100));

        window.setText(x.toString());

    }
}
