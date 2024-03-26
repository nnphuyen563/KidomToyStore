package com.group4.kidomtoystore.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.group4.kidomtoystore.Adapters.ViewPagerAdapter;
import com.group4.kidomtoystore.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class OnboardingActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private RelativeLayout layoutBottom;
    private TabLayout tabLayout;
    private Button buttonNext;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        initUI();

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (right != oldRight || bottom != oldBottom) {
                    // Trang thay đổi, cập nhật trạng thái của TabLayout
                    updateTabLayout();
                }
            }
        });

        // Kết nối TabLayout với ViewPager2 và thiết lập nội dung cho mỗi tab từ Fragment tương ứng
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setIcon(R.drawable.button_available);
                            break;
                        case 1:
                            tab.setIcon(R.drawable.button_available);
                            break;
                        case 2:
                            tab.setIcon(R.drawable.button_available);
                            break;
                        case 3:
                            tab.setIcon(R.drawable.button_available);
                            break;
                        default:
                            break;
                    }
                }).attach();
    }

    private void initUI(){
        viewPager = findViewById(R.id.view_pager);
        layoutBottom = findViewById(R.id.layout_bottom);
        tabLayout = findViewById(R.id.tab_layout);
        buttonNext = findViewById(R.id.btn_next);
    }
    private void updateTabLayout() {
        int currentItem = viewPager.getCurrentItem();
        tabLayout.getTabAt(currentItem).select();
    }
}