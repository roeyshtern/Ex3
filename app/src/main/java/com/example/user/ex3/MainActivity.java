package com.example.user.ex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button plusBt,minusBt,multipleBt,dividBt;
    EditText etOperand1,etOperand2;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusBt = (Button)findViewById(R.id.plusButton);
        minusBt = (Button)findViewById(R.id.minusButton);
        multipleBt = (Button)findViewById(R.id.multipleButton);
        dividBt = (Button)findViewById(R.id.dividButton);

        etOperand1 = (EditText)findViewById(R.id.etOperand1);
        etOperand2 = (EditText)findViewById(R.id.etOperand2);

        resultText = (TextView)findViewById(R.id.resultText);

    }

    public void calc(View view){
        int op1 = 0;
        int op2 = 0;

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
            op1 = Integer.valueOf(strop1);
            op2 = Integer.valueOf(strOp2);

            switch(view.getId())
            {
                case R.id.plusButton:
                    op1 = op1+op2;
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
}
