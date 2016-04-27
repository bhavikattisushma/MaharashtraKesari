package com.sushma.mahakesari.maharashtrakesari;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TitlePageIndicator;

import adapter.TestFragmentAdapter;

public class SampleTitlesStyledTheme extends FragmentActivity {
    private TestFragmentAdapter mAdapter;
    private ViewPager mPager;
    private TitlePageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //The look of this sample is set via a style in the manifest
        setContentView(R.layout.simple_titles);






        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mPager.setCurrentItem(4);

        mIndicator = (TitlePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
}