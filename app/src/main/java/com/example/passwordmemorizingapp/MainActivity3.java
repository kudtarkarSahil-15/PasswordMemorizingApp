package com.example.passwordmemorizingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    //fields
    ViewPager myViewPager;
    TabLayout tabLayout;

    //array- tabs
//    private String[] tabs = {"NEW", "VIEW"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        myViewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

//      tabLayout.setupWithViewPager(myViewPager);

        //adapter
        AdapterPager adapterPager =  new AdapterPager(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapterPager.addFragment(new FragmentNew(), "NEW");
        adapterPager.addFragment(new FragmentV(), "VIEW");
        myViewPager.setAdapter(adapterPager);


//        myViewPager.setAdapter(new AdapterPager(this));
    }

}

    /* To Feed the data inside a view pager we need a Adapter class */


