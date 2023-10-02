package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etA , etB , etC;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectComponents();
    }

    private void connectComponents() {
        etA = findViewById(R.id.etAMain);
        etB = findViewById(R.id.etBMain);
        etC = findViewById(R.id.etCMain);
        btnCalculate = findViewById(R.id.btnCalculateMain);

    }

    public void calculate(View view) {
        String aDo = etA.getText().toString();
        String bDo = etB.getText().toString();
        String cDo = etC.getText().toString();
        if (!TextUtils.isDigitsOnly(aDo) || !TextUtils.isDigitsOnly(bDo) || !TextUtils.isDigitsOnly(cDo) || aDo.isEmpty() || bDo.isEmpty() || cDo.isEmpty())
        {
            Toast.makeText(this, "something went wrong!", Toast.LENGTH_LONG).show();
            return;
        }
        double a , b , c , delta;
        a = Double.parseDouble(aDo);
        b = Double.parseDouble(bDo);
        c = Double.parseDouble(cDo);
        delta = ((b*b)-(4*a*c));
        if (delta == 0)
        {
            double x = ((-1*b)/(2*a));
            Toast.makeText(this, "x = "+x, Toast.LENGTH_LONG).show();
        }
        if (delta<0)
        {
            Toast.makeText(this, "erorr!", Toast.LENGTH_LONG).show();
        }
        if (delta>0)
        {
            double x1 = ((-1*b) + Math.sqrt(delta));
            double x2 = ((-1*b) - Math.sqrt(delta));
            Toast.makeText(this, "x1 = "+x1+" x2 = "+x2, Toast.LENGTH_SHORT).show();
        }
    }
}