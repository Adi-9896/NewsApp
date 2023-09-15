package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    String api = "c4f842a959054b0fb92b4aca90db2c0d";
    TabLayout mtabLayout;
    Toolbar mtoolbar;
    TabItem mhome,msports,mscience,mentertainment,mhealth,mtechnology,mbusiness;

    ViewPager viewPager;

    Pageradapter pageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtabLayout = findViewById(R.id.tab);
        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mhome = findViewById(R.id.home);
        msports = findViewById(R.id.sports);
        mbusiness = findViewById(R.id.business);
        mscience = findViewById(R.id.science);
        mentertainment = findViewById(R.id.entertainment);
        mhealth = findViewById(R.id.health);
        mtechnology = findViewById(R.id.technology);
        viewPager = findViewById(R.id.fragmentcontainer);

        pageradapter = new Pageradapter(getSupportFragmentManager(), 7);

        viewPager.setAdapter(pageradapter);
        mtabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override

            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();//getting the positin of selected tab
                viewPager.setCurrentItem(pos); //setting the tab
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5||tab.getPosition()==6){

                    pageradapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtabLayout));

    }
}