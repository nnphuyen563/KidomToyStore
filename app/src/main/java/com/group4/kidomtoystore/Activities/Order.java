package com.group4.kidomtoystore.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.group4.kidomtoystore.Adapters.ViewPagerAdapter;
import com.group4.kidomtoystore.R;

public class Order extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tablayout = findViewById(R.id.tlOrder);
        viewpager = findViewById(R.id.vpOrder);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewpager.setAdapter(viewPagerAdapter);

        tablayout.setupWithViewPager(viewpager);
    }
}