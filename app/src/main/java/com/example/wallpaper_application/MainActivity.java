package com.example.wallpaper_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.graphics.*;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.GridView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    DisplayMetrics dm;
    int ht, wt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = findViewById(R.id.gv);
        gv.setAdapter(new MyAdapter(this));
        gv.setOnItemClickListener((parent, view, position, id) -> {
            AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
            adb.setTitle("Set Wallpaper");
            adb.setIcon(Constants.img[position]);
            adb.setCancelable(false);
            adb.setMessage("Are you sure you want to set wallpaper");

            adb.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dimensions();
                    Bitmap mybitmap = BitmapFactory.decodeResource(getResources(), (int) Constants.img[position]);
                    Bitmap mainbitmap = NewBitmap(mybitmap);
                    WallpaperManager wm = WallpaperManager.getInstance(getApplicationContext());

                    try {
                        wm.setBitmap(mainbitmap);
                        wm.suggestDesiredDimensions(wt, ht);
                        Toast.makeText(MainActivity.this, "Your Walpaper is set", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        Toast.makeText(MainActivity.this, "Error setting wallpaper", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            adb.setNegativeButton("Cancel", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "Wallpaper not set", Toast.LENGTH_SHORT).show();
            });
            adb.show();
        });
    }
    private void dimensions() {
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        wt = dm.widthPixels;
        ht = dm.heightPixels;

    }
    public Bitmap NewBitmap(Bitmap xbitmap) {
       return Bitmap.createScaledBitmap(xbitmap,wt,ht,false);

    }

}
