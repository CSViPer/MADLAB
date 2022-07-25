package com.example.wallpaperchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.time.Period;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int images[] = new int[]{
            R.drawable.kakashi,
            R.drawable.madara,
            R.drawable.naruto,
            R.drawable.sasuke
    };

    Button btn;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);


        btn.setOnClickListener(v -> new Timer().schedule(new ChangeWallaper(),  0, 30000));
    }
    class ChangeWallaper extends TimerTask{
        @Override
        public void run() {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());


            try {
                wallpaperManager.setBitmap( BitmapFactory.decodeResource(getResources(),images[i]));
                i++;

                if(i==4){
                    i=0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}