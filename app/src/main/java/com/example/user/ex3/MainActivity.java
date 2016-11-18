package com.example.user.ex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher{

    int op1 = 0;
    int op2 = 0;
    Button plusBt,minusBt,multipleBt,dividBt,equalsBt;
    EditText etOperand1,etOperand2;
    TextView resultText;
    final String RESULT = "result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusBt = (Button)findViewById(R.id.plusButton);
        minusBt = (Button)findViewById(R.id.minusButton);
        multipleBt = (Button)findViewById(R.id.multipleButton);
        dividBt = (Button)findViewById(R.id.dividButton);
        equalsBt = (Button)findViewById(R.id.equalsButton);

        etOperand1 = (EditText)findViewById(R.id.etOperand1);
        etOperand2 = (EditText)findViewById(R.id.etOperand2);

        etOperand1.addTextChangedListener(this);
        etOperand2.addTextChangedListener(this);
        resultText = (TextView)findViewById(R.id.resultText);

    }
    /*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(RESULT, this.op1);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null)
        {
            this.op1 = savedInstanceState.getInt(RESULT, 0);
            resultText.setText(Integer.toString(op1));
        }
    }
    */
    public void calc(View view){


        String strop1 = "";
        String strOp2 = "";

        strop1 = etOperand1.getText().toString();
        strOp2 = etOperand2.getText().toString();
        if(strop1.isEmpty() || strOp2.isEmpty())
        {
            Toast.makeText(this, "You dont enter any number, Try again!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            this.op1 = Integer.valueOf(strop1);
            this.op2 = Integer.valueOf(strOp2);

            switch(view.getId())
            {
                case R.id.plusButton:
                    this.op1 = op1+op2;
                    resultText.setText(Integer.toString(op1));
                    break;

                case R.id.minusButton:
                    op1 = op1-op2;
                    resultText.setText(Integer.toString(op1));
                    break;

                case R.id.multipleButton:
                    op1 = op1*op2;
                    resultText.setText(Integer.toString(op1));
                    break;

                case R.id.dividButton:
                    op1 = op1/op2;
                    resultText.setText(Integer.toString(op1));
                    break;


            }
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        changeButtonState((!etOperand1.getText().toString().isEmpty() && !etOperand2.getText().toString().isEmpty()));
    }
    private void changeButtonState(Boolean newState){
        plusBt.setEnabled(newState);
        minusBt.setEnabled(newState);
        multipleBt.setEnabled(newState);
        dividBt.setEnabled(newState);
        equalsBt.setEnabled(newState);
    }

}
