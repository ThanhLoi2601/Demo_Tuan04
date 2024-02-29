package com.example.demo_tuan04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.view.Menu;


public class Switch_checkbox_bar extends AppCompatActivity {

    Toolbar toolbar;
    Button btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_checkbox_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnMenu = (Button) findViewById(R.id.btn_menu);
        setSupportActionBar(toolbar);
        TextView textView = (TextView) findViewById(R.id.textView);
        registerForContextMenu(textView);
        //switch
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ //isChecked = true
                    Toast.makeText(Switch_checkbox_bar.this,"Wifi đang bật",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Switch_checkbox_bar.this,"Wifi đang tắt",Toast.LENGTH_LONG).show();
                }
            }
        });

        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.constraintLayout3);
        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox);
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
           {
               if(isChecked){
                   bg.setBackgroundResource(R.drawable.bg3);
               }else{
                   bg.setBackgroundResource(R.drawable.bg4);
               }
           }
        });
        //RadioGroup
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //checkID trả về ID radio
                if(checkedId == R.id.radioButton) {
                  bg.setBackgroundResource(R.drawable.bg3);
                }
                else if (checkedId == R.id.radioButton2) {
                  bg.setBackgroundResource(R.drawable.bg4);
                }
            }
        });

        ImageButton img2 = (ImageButton) findViewById(R.id.imageButton1);
        //progrebar
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tự đếm progress
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();
                        //chạy đều đều >100 quay về 0
                        if (current>= progressBar.getMax()){
                            current=0;
                        }
                        progressBar.setProgress(current + 10); //thiết lập progress
                    }
                    @Override
                    public void onFinish() {
                        Toast.makeText(Switch_checkbox_bar.this,"Hết giờ",Toast.LENGTH_LONG).show();
                    }
                };
                countDownTimer.start();
            }
        });

        //Seekbar
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //progress: giá trị của seekbar
                Log.d("AAA","Giá trị:" + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Start");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Stop");
            }});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuSetting){
            Toast.makeText(Switch_checkbox_bar.this,"chọn Setting",Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menuShare){
            Toast.makeText(Switch_checkbox_bar.this,"chọn Share",Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menuLogout){
            Toast.makeText(Switch_checkbox_bar.this,"chọn Logout",Toast.LENGTH_LONG).show();
            XacNhanDX();
        }
        return super.onOptionsItemSelected(item);
    }
//    private void ShowPopupMenu(){
//        PopupMenu popupMenu = new PopupMenu(Switch_checkbox_bar.this,btnMenu);
//        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
//        popupMenu.show();
//    }
    //popup menu
    public void ShowPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this,btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_setting,popupMenu.getMenu());
        //bắt sự kiện
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.menuSetting){
                    Toast.makeText(Switch_checkbox_bar.this,"chọn Setting",Toast.LENGTH_LONG).show();
                }
                if (item.getItemId() == R.id.menuShare){
                    Toast.makeText(Switch_checkbox_bar.this,"chọn Share",Toast.LENGTH_LONG).show();
                }
                if (item.getItemId() == R.id.menuLogout){
                    Toast.makeText(Switch_checkbox_bar.this,"chọn Logout",Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
        popupMenu.show();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_setting,menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //bắt sự kiện Context Menu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuSetting){
            Toast.makeText(Switch_checkbox_bar.this,"chọn Setting",Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menuShare){
            Toast.makeText(Switch_checkbox_bar.this,"chọn Share",Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menuLogout){
            Toast.makeText(Switch_checkbox_bar.this,"chọn Logout",Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    private void XacNhanDX(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông báo");
        alert.setMessage("Bạn có muốn đăng xuất không");
        alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Switch_checkbox_bar.this,"Đã đăng xuất",Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Switch_checkbox_bar.this,"Đã hủy yêu cầu",Toast.LENGTH_LONG).show();
            }
        });
        alert.show();
    }
}