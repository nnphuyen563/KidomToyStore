package com.group4.kidomtoystore.Adapters;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.group4.kidomtoystore.ContactFragment;
import com.group4.kidomtoystore.FaqFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int i) {
        if (i == 1){
            return new FaqFragment();
        }
        return new ContactFragment();

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
