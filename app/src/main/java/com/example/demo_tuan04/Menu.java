package com.example.demo_tuan04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuSetting) {
            Toast.makeText(Menu.this, "chọn Setting", Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menuShare) {
            Toast.makeText(Menu.this, "chọn Share", Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menuLogout) {
            Toast.makeText(Menu.this, "chọn Logout", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_setting,menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuSetting){
            Toast.makeText(Menu.this,"chọn Setting",Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menuShare){
            Toast.makeText(Menu.this,"chọn Share",Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menuLogout){
            Toast.makeText(Menu.this,"chọn Logout",Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }
}