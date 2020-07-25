package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

@SuppressLint("Registered")
public class Controller extends Activity implements View.OnClickListener {

    public Controller(TextView textFirst, TextView textSecond, TextView textSign, TextView textResult){
        this.textFirst = textFirst;
        this.textSecond = textSecond;
        this.textSign = textSign;
        this.textResult = textResult;
    }

    @Override
    public void onClick(View view) {
        if (textFirst.getText() != "" && textSign.getText() != "") {
            text = textSecond;
        } else text = textFirst;

        if(isPer) {
            clearView();
            isPer = false;
        }

        switch (view.getId()) {
            case R.id.btn_0:
                if (text.getText() != "")
                    text.setText(text.getText() + "0");
                break;
            case R.id.btn_1:
                text.setText(text.getText() + "1");
                break;
            case R.id.btn_2:
                text.setText(text.getText() + "2");
                break;
            case R.id.btn_3:
                text.setText(text.getText() + "3");
                break;
            case R.id.btn_4:
                text.setText(text.getText() + "4");
                break;
            case R.id.btn_5:
                text.setText(text.getText() + "5");
                break;
            case R.id.btn_6:
                text.setText(text.getText() + "6");
                break;
            case R.id.btn_7:
                text.setText(text.getText() + "7");
                break;
            case R.id.btn_8:
                text.setText(text.getText() + "8");
                break;
            case R.id.btn_9:
                text.setText(text.getText() + "9");
                break;

            case R.id.btn_div:
                if(textFirst.getText() != "" && textSecond.getText() == "")
                    textSign.setText("/");
                isAfterSign = true;
                break;

            case R.id.btn_sum:
                if(textFirst.getText() != "" && textSecond.getText() == "")
                    textSign.setText("+");
                isAfterSign = true;
                break;

            case R.id.btn_sub:
                if(textFirst.getText() == "")
                    textFirst.setText("-");
                else if(textSign.getText() != "")
                    textSecond.setText("-" + textSecond.getText());
                else if(textSecond.getText() == "")
                    textSign.setText("-");

                break;
            case R.id.btn_mul:
                if(textFirst.getText() != "" && textSecond.getText() == "")
                    textSign.setText("*");
                isAfterSign = true;
                break;
            case R.id.btn_del:
                if(text.getText().length() != 0)
                    text.setText(text.getText().subSequence(0, text.getText().length()-1));
                else
                    text.setText("");
                break;
            case R.id.btn_clear:
                clearView();
                break;

            case R.id.btn_dot:
                if(text.getText() == "" || text.getText() == "-")
                    text.setText(text.getText() + "0.");
                else if(text.getText().toString().indexOf('.') == -1)
                    text.setText(text.getText() + ".");
                break;

        }

    }

    public void clearView(){
        textFirst.setText("");
        textSecond.setText("");
        textSign.setText("");
        textResult.setText("");
    }

    public boolean isPer = false;

    private TextView text;
    public boolean isAfterSign = false;
    private final TextView textFirst;
    private final TextView textSecond;
    private final TextView textSign;
    private final TextView textResult;

}
