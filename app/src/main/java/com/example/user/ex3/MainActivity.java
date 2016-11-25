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
    Button plusBt,minusBt,multipleBt,dividBt,equalsBt,clearBt,answerBt;
    EditText etOperand1,etOperand2;
    TextView resultText;
    int calc = 0;
    int result = 0;
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
        answerBt = (Button)findViewById(R.id.answerButton);

        etOperand1 = (EditText)findViewById(R.id.etOperand1);
        etOperand2 = (EditText)findViewById(R.id.etOperand2);

        clearBt = (Button)findViewById(R.id.clearButton);

        clearBt.setOnClickListener(new myListener());
        etOperand1.addTextChangedListener(this);
        etOperand2.addTextChangedListener(this);
        resultText = (TextView)findViewById(R.id.resultText);

        answerBt.setOnClickListener(new View.OnClickListener() {
            String result;
            @Override
            public void onClick(View v) {
                etOperand1.setText(resultText.getText().toString());
            }
        });

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

            switch(view.getId()) {
                case R.id.plusButton:
                    this.result = op1 + op2;
                    this.calc = 1;
                    break;

                case R.id.minusButton:
                    this.result = op1 - op2;
                    this.calc = 1;
                    break;

                case R.id.multipleButton:
                    this.result = op1 * op2;
                    this.calc = 1;
                    break;

                case R.id.dividButton:
                    this.result = op1 / op2;
                    this.calc = 1;
                    break;
                case R.id.equalsButton:
                    if(resultText.getText().toString().equals(Integer.toString(this.result)))
                    {
                        Toast.makeText(this, "You must enter paremter to calc, Try again!",Toast.LENGTH_SHORT).show();
                    }
                    if(this.calc!=0)
                    {
                        resultText.setText(Integer.toString(this.result));
                        answerBt.setEnabled(true);
                    }
                    else
                    {
                        Toast.makeText(this, "You must enter paremter to calc, Try again!",Toast.LENGTH_SHORT).show();
                    }
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
        clearBt.setEnabled(newState);
    }
    private class myListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            etOperand1.setText("");
            etOperand2.setText("");
            resultText.setText(R.string.result);
            answerBt.setEnabled(false);
        }
    }
}
