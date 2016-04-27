package com.sushma.mahakesari.maharashtrakesari;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.aphidmobile.flip.FlipViewController;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;

import adapter.CalendarAdapter;
import adapter.CalendarPagerAdapter;
import custome.view.ZoomableImageView;

public class MainActivity extends AppCompatActivity {

    ViewPager calendarPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        calendarPager=(ViewPager) findViewById(R.id.vpPager);
//
//
//        ArrayList<Integer> calendarPages=new ArrayList<>();
//        calendarPages.add(R.drawable.january);
//        calendarPages.add(R.drawable.january);
//        calendarPages.add(R.drawable.january);
//        calendarPages.add(R.drawable.january);
//        calendarPages.add(R.drawable.january);
//
//        CalendarPagerAdapter calendarAdapter=new CalendarPagerAdapter(this);
//        calendarAdapter.setCalendarData(calendarPages);
//
//        calendarPager.setAdapter(calendarAdapter);

        Intent i=new Intent(this,SampleTitlesStyledTheme.class);
        startActivity(i);
        finish();

    }



}
