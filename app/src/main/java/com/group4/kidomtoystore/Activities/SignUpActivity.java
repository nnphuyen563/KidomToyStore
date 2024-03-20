package com.group4.kidomtoystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.group4.kidomtoystore.R;
import com.group4.kidomtoystore.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumb = binding.txtInputPhoneNumb.getText().toString();
                String password = binding.txtInputPassword.getText().toString();

                if (password.length() < 6 ) {
                    Toast.makeText(SignUpActivity.this, "Mật khẩu có ít nhất 6 ký tự", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}