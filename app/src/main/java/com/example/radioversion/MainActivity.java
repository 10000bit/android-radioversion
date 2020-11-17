package com.example.radioversion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.radioversion.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private final String color[] = {"RED", "YELLOW", "GREEN", "BLUE", "NAVY", "PURPLE", "BLACK"};
    private final String shape[] = {"사각형", "원", "얇은대각선", "삼각형"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder;
        switch(item.getItemId()) {
            case R.id.changeColor:  // 메뉴에서 '색 변경'을 눌렀을 때 대화상자
                builder = new AlertDialog.Builder(this);
                builder.setTitle("색 변경");


                builder.setItems(color, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        binding.myView.setPaintColor(Color.parseColor(color[which]));
                    }
                });

                builder.create().show();
                return true;

            case R.id.changeShape:  // 메뉴에서 '붓 모양 변경'을 눌렀을 때 대화상자
                builder = new AlertDialog.Builder(this);
                builder.setTitle("붓 모양 변경");


                builder.setItems(shape, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (shape[which] == "사각형")
                            binding.myView.setPaintShape("사각형");
                        else if (shape[which] == "원")
                            binding.myView.setPaintShape("원");
                        else if (shape[which] == "얇은대각선")
                            binding.myView.setPaintShape("얇은대각선");
                        else if (shape[which] == "삼각형")
                            binding.myView.setPaintShape("삼각형");
                    }
                });


                builder.create().show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}