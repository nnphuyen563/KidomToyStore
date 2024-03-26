package com.group4.kidomtoystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.group4.kidomtoystore.R;
import com.group4.kidomtoystore.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {

    ActivityNotificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}