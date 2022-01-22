package com.example.basic_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    boolean isnewop = true;
    EditText screen;
    String oldnum, op;
    public void numberEvent(View v){
        if(isnewop){
            screen.setText("");
        }
        isnewop = false;
            String num = screen.getText().toString();
            switch (v.getId()){
                case R.id.num1: num += "1"; break;
                case R.id.num2: num += "2"; break;
                case R.id.num3: num += "3"; break;
                case R.id.num4: num += "4"; break;
                case R.id.num5: num += "5"; break;
                case R.id.num6: num += "6"; break;
                case R.id.num7: num += "7"; break;
                case R.id.num8: num += "8"; break;
                case R.id.num9: num += "9"; break;
                case R.id.num0: num += "0"; break;
                case R.id.dot: num += "."; break;
                case R.id.negative: num = "-" + num; break;
            }
            screen.setText(num);
    }
    public void operatorEvent(View v){
        isnewop = true;
        oldnum = screen.getText().toString();
        switch (v.getId()){
            case R.id.plus: op = "+"; break;
            case R.id.minus: op = "-"; break;
            case R.id.divide: op = "/"; break;
            case R.id.mul: op = "*"; break;
        }
    }
    public void equalEvent(View v){
        String newNum = screen.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldnum) + Double.parseDouble(newNum);
                break;
            case "-":
                result = Double.parseDouble(oldnum) - Double.parseDouble(newNum);
                break;
            case "/":
                result = Double.parseDouble(oldnum) / Double.parseDouble(newNum);
                break;
            case "*":
                result = Double.parseDouble(oldnum) * Double.parseDouble(newNum);
                break;
        }
        screen.setText(Double.toString(result));
    }
    public void acEvent(View v){
        screen.setText("0");
        isnewop = true;
    }
    public void percentageEvent(View v){
        String num = screen.getText().toString();
        Double ans = Double.parseDouble(num);
        ans /= 100;
        screen.setText(Double.toString(ans));
        isnewop = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.editext);
    }
}