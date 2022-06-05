package com.example.passwordmemorizingapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

class AdapterPager extends FragmentPagerAdapter {

    /* Require two array list one for number of fragments and other
     for defining a number of titles of a each each fragment in String  */
    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    public AdapterPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }


    /* methods */
    public void addFragment(Fragment fragment, String title) {

        fragmentArrayList.add(fragment);
        fragmentTitle.add(title);
    }

    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
