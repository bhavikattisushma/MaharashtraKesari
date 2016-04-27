package com.sushma.mahakesari.maharashtrakesari;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aphidmobile.flip.FlipViewController;

import adapter.CalendarAdapter;

public class MainActivityFlip extends AppCompatActivity {

    private FlipViewController flipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipView = new FlipViewController(this);

        //Use RGB_565 can reduce peak memory usage on large screen device, but it's up to you to choose the best bitmap format
        flipView.setAnimationBitmapFormat(Bitmap.Config.RGB_565);

        flipView.setAdapter(new CalendarAdapter(this));

        setContentView(flipView);


//        loadCalendar();


    }

    @Override
    protected void onResume() {
        super.onResume();
        flipView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        flipView.onPause();
    }

}
