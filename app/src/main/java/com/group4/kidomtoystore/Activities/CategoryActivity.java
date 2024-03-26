package com.group4.kidomtoystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.group4.kidomtoystore.R;
import com.group4.kidomtoystore.databinding.ActivityCategoryBinding;

public class CategoryActivity extends AppCompatActivity {

    ActivityCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_category);
    }
}