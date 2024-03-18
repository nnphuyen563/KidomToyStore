package com.group4.kidomtoystore.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.group4.kidomtoystore.Fragments.DeliveringOrderFragment;
import com.group4.kidomtoystore.Fragments.PreparingOrderFragment;
import com.group4.kidomtoystore.Fragments.ReviewOrderFragment;
import com.group4.kidomtoystore.Fragments.ShipOrderFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PreparingOrderFragment();
            case 1:
                return new ShipOrderFragment();
            case 2:
                return new DeliveringOrderFragment();
            case 3:
                return new ReviewOrderFragment();

            default:
                return new PreparingOrderFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Chờ xác nhận";
                break;
            case 1:
                title = "Chờ giao";
                break;
            case 2:
                title = "Đang giao";
                break;
            case 3:
                title = "Đánh giá";
                break;
        }
        return title;
    }
}
