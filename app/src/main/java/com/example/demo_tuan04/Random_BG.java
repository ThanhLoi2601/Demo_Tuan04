package com.example.demo_tuan04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Random_BG extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_bg);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg1);
        arrayList.add(R.drawable.bg2);
        arrayList.add(R.drawable.bg3);
        arrayList.add(R.drawable.bg4);
        random_bg(arrayList);
        ImageButton img2 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton img1 = (ImageButton) findViewById(R.id.imageButton2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.dart);
                img1.getLayoutParams().width=550;
                img1.getLayoutParams().height=550;
            }
        });
        Switch_rand_bg(arrayList);
    }

    private void random_bg(ArrayList<Integer> arrayList){
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.constraintLayout2);
        bg.setBackgroundResource(arrayList.get(vitri));
    }

    private void Switch_rand_bg(ArrayList<Integer> arrayList){
        Random random = new Random();
        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.constraintLayout2);
        Switch sw = (Switch) findViewById(R.id.switch_bg);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int vitri = random.nextInt(arrayList.size());
                bg.setBackgroundResource(arrayList.get(vitri));
            }
        });
    }

}