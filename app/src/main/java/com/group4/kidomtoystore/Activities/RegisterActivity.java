package com.group4.kidomtoystore.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.group4.kidomtoystore.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumb = binding.txtInputPhoneNumb.getText().toString().trim();
                String password = binding.txtInputPassword.getText().toString().trim();

                if(phoneNumb.length() < 10 || phoneNumb.substring(0, 1) == "0") {
                    Toast.makeText(RegisterActivity.this, "Số điện thoại không đúng định dạng!", Toast.LENGTH_SHORT).show();
                }else if(password.length() < 6 ) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu có ít nhất 6 ký tự!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(RegisterActivity.this, SignUpActivity.class);

                    intent.putExtra("phone", phoneNumb);
                    intent.putExtra("pass", password);

                    startActivity(intent);
                }


            }
        });

        binding.txtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}