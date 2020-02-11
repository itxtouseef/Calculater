package com.example.calculater;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText no1, no2;
    float a , b, c;
    Button btn1,btn2,btn3,btn4;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        no1=(EditText)findViewById(R.id.no1);
        no2=(EditText)findViewById(R.id.no2);
        res=(TextView)findViewById(R.id.res);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


           no1.addTextChangedListener(loginTextWatcher);
           no2.addTextChangedListener(loginTextWatcher);

    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String nu1 = no1.getText().toString().trim();
            String nu2 = no2.getText().toString().trim();
            btn1.setEnabled(!nu1.isEmpty() && !nu2.isEmpty());
            btn2.setEnabled(!nu1.isEmpty() && !nu2.isEmpty());
            btn3.setEnabled(!nu1.isEmpty() && !nu2.isEmpty());
            btn4.setEnabled(!nu1.isEmpty() && !nu2.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn1:
                a = Float.valueOf(no1.getText().toString());
                b = Float.valueOf(no2.getText().toString());
                c=a/b;
                res.setText("Division is: "+c);
                break;

            case R.id.btn2:
                a = Float.valueOf(no1.getText().toString());
                b = Float.valueOf(no2.getText().toString());
                c=a+b;
                res.setText("Addition is: "+c);
                break;

            case R.id.btn3:
                a = Float.valueOf(no1.getText().toString());
                b = Float.valueOf(no2.getText().toString());
                c=a-b;
                res.setText("Subtraction is: "+c);
                break;

            case R.id.btn4:
                a = Float.valueOf(no1.getText().toString());
                b = Float.valueOf(no2.getText().toString());
                c=a*b;
                res.setText("Multiplication is: "+c);
                break;
        }
    }
}
