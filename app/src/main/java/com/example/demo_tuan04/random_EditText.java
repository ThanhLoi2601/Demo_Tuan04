package com.example.demo_tuan04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class random_EditText extends AppCompatActivity {
    EditText edSoN1;
    EditText edSoN2;
    Button btnRnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_edit_text);
        //ánh xạ
        edSoN1 = (EditText) findViewById(R.id.editTextNumber1);
        edSoN2 = (EditText) findViewById(R.id.editTextNumber2);
        btnRnd = (Button) findViewById(R.id.buttonRnd2);
        //viết code sinh ngẫu nhiên
        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tạo số ngẫu nhiên
                Random random = new Random();
                int number1 = random.nextInt(10);
                int number2 = random.nextInt(10);
                edSoN1.setText(number1 + ""); //number + ""ép kiểu
                edSoN2.setText(number2 + ""); //number + ""ép kiểu
            }
        });
    }
}