package com.group4.kidomtoystore.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.group4.kidomtoystore.Activities.OnboardingFragment3;
import com.group4.kidomtoystore.Activities.OnboardingFragment4;
import com.group4.kidomtoystore.Activities.OnboardingFragment5;
import com.group4.kidomtoystore.Activities.OnboardingFragment6;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new OnboardingFragment3();
            case 1:
                return new OnboardingFragment4();
            case 2:
                return new OnboardingFragment5();
            case 3:
                return new OnboardingFragment6();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
