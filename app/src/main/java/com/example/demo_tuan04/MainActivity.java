package com.example.demo_tuan04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtSoN;
    Button btnRnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        txtSoN = (TextView) findViewById(R.id.textViewSo);
        btnRnd = (Button) findViewById(R.id.buttonRnd);
        //viết code sinh ngẫu nhiên
        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tạo số ngẫu nhiên
                Random random = new Random();
                int number = random.nextInt(10);
                txtSoN.setText(number + ""); //number + ""ép kiểu
            }
        });
    }
}