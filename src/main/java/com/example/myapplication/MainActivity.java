package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFirst = findViewById(R.id.textFirst);
        textSecond = findViewById(R.id.textSecond);
        textSign = findViewById(R.id.textSign);
        textResult = findViewById(R.id.textResult);

        controller = new Controller(textFirst, textSecond, textSign, textResult);

        btn_div = findViewById(R.id.btn_div);
        btn_sub = findViewById(R.id.btn_sub);
        btn_sum = findViewById(R.id.btn_sum);
        btn_mul = findViewById(R.id.btn_mul);

        btn_per = findViewById(R.id.btn_per);
        btn_dot = findViewById(R.id.btn_dot);
        btn_del = findViewById(R.id.btn_del);
        btn_clear = findViewById(R.id.btn_clear);
        btn_result = findViewById(R.id.btn_result);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_0.setOnClickListener(controller);
        btn_1.setOnClickListener(controller);
        btn_2.setOnClickListener(controller);
        btn_3.setOnClickListener(controller);
        btn_4.setOnClickListener(controller);
        btn_5.setOnClickListener(controller);
        btn_6.setOnClickListener(controller);
        btn_7.setOnClickListener(controller);
        btn_8.setOnClickListener(controller);
        btn_9.setOnClickListener(controller);

        btn_div.setOnClickListener(controller);
        btn_sub.setOnClickListener(controller);
        btn_sum.setOnClickListener(controller);
        btn_mul.setOnClickListener(controller);

        btn_dot.setOnClickListener(controller);
        btn_del.setOnClickListener(controller);
        btn_clear.setOnClickListener(controller);


        btn_per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textFirst.getText() != "" && textSecond.getText() == "") {
                    textFirst.setText(Double.toString(Double.parseDouble(textFirst.getText().toString()) / 100));
                    controller.isPer = true;
                }
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textFirst.getText() != "" && textSecond.getText() != "" && textSign.getText() != "")
                    textResult.setText(Double.toString(calculate()));
                else if(textFirst.getText() != "")
                    textResult.setText(textFirst.getText());
            }
        });

    }

    private double calculate(){

        double numFirst = Double.parseDouble(textFirst.getText().toString());
        double numSecond = Double.parseDouble(textSecond.getText().toString());

        switch (textSign.getText().charAt(0)) {
            case '/':
                return numFirst / numSecond;
            case '*':
                return numFirst * numSecond;
            case '+':
                return numFirst + numSecond;
            case '-':
                return numFirst - numSecond;

        }
        return 0;
    }


    Controller controller;

    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_div;
    Button btn_sub;
    Button btn_mul;
    Button btn_sum;

    Button btn_dot;
    Button btn_per;
    Button btn_del;
    Button btn_clear;
    Button btn_result;

    TextView textFirst;
    TextView textSecond;
    TextView textSign;
    TextView textResult;
}
