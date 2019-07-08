/*
 *
 *  * Created by Deepak Kaushik
 *  * Copyright (c) 2019. All right reserved.
 *  * Last Modified 7/7/19 1:32 PM
 *
 */

package com.mr0kaushik.goworkshop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;
import com.mr0kaushik.goworkshop.Adapters.SliderAdapter;

public class WalkThroughActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout bottomLayout;
    private SliderAdapter sliderAdapter;
    private MaterialButton btnBack, btnNext;
    private int currentPage;

    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (restorePrefData()){
            openMainActivity();
        }

        setContentView(R.layout.activity_walk_through);

        viewPager = findViewById(R.id.slideViewPager);
        bottomLayout = findViewById(R.id.bottomLayout);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(currentPage-1);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnNext.getText().equals("Next"))
                    viewPager.setCurrentItem(currentPage+1);
                else {
                    savePreference();
                    openMainActivity();
                }
            }
        });

        sliderAdapter = new SliderAdapter(this);


        viewPager.setAdapter(sliderAdapter);
        addDotIndicator(0);
        viewPager.addOnPageChangeListener(pageChangeListener);

    }

    private boolean restorePrefData() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("excess_rewards", MODE_PRIVATE);
        return preferences.getBoolean("isVisitedWalkThrough", false);
    }

    private void savePreference() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("excess_rewards", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isVisitedWalkThrough", true);
        editor.apply();
    }

    public void addDotIndicator(int position){
        dots = new TextView[sliderAdapter.getCount()];
        bottomLayout.removeAllViews();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(4,4,4,4);

        for (int i = 0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorGreyLightDark));
            dots[i].setLayoutParams(params);

            bottomLayout.addView(dots[i]);
        }

        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotIndicator(position);
            currentPage = position;
            if (currentPage == 0){

                btnNext.setEnabled(true);
                btnBack.setEnabled(false);
                btnBack.setVisibility(View.INVISIBLE);
                btnNext.setText(getResources().getString(R.string.next));
                btnBack.setText(getResources().getString(R.string.back));

            } else if (currentPage == dots.length-1){

                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setText(getResources().getString(R.string.finish));
                btnBack.setText(getResources().getString(R.string.back));

            } else {

                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setText(getResources().getString(R.string.next));
                btnBack.setText(getResources().getString(R.string.back));
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void openMainActivity(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}
