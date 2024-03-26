package com.group4.kidomtoystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.group4.kidomtoystore.R;
import com.group4.kidomtoystore.databinding.ActivitySearchTypeBinding;

public class SearchTypeActivity extends AppCompatActivity {

    ActivitySearchTypeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}