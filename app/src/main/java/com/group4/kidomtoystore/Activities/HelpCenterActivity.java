package com.group4.kidomtoystore.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.group4.kidomtoystore.Adapters.FragmentAdapter;
import com.group4.kidomtoystore.FaqFragment;
import com.group4.kidomtoystore.R;
import com.group4.kidomtoystore.databinding.ActivityHelpCenterBinding;

public class HelpCenterActivity extends AppCompatActivity {

    ActivityHelpCenterBinding binding;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private FragmentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHelpCenterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tabLayout = findViewById(R.id.tlHelpCenter);
        viewPager2 = findViewById(R.id.vp2HelpCenter);

        tabLayout.addTab(tabLayout.newTab().setText("FAQ"));
        tabLayout.addTab(tabLayout.newTab().setText("Contact"));


        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new FragmentAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int i) {
                tabLayout.selectTab(tabLayout.getTabAt(i));
            }
        });

    }
}