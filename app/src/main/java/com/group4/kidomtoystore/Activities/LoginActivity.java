package com.group4.kidomtoystore.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.group4.kidomtoystore.R;
import com.group4.kidomtoystore.databinding.ActivityLoginBinding;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        addEvents();
    }

    private void addEvents() {

        binding.txtInputEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(!TextUtils.isEmpty(binding.txtInputEmail.getText().toString()) && !TextUtils.isEmpty(binding.txtInputPassword.getText().toString())) {
                    binding.btnLogIn.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.button_available));
                }else{
                    binding.btnLogIn.setBackgroundResource(R.drawable.button_disable);
                }
            }
        });

        binding.txtInputPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(!TextUtils.isEmpty(binding.txtInputEmail.getText().toString()) && !TextUtils.isEmpty(binding.txtInputPassword.getText().toString())) {
                    binding.btnLogIn.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.button_available));
                }else{
                    binding.btnLogIn.setBackgroundResource(R.drawable.button_disable);
                }
            }
        });

        binding.btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.txtInputEmail.getText().toString().trim();
                String password = binding.txtInputPassword.getText().toString().trim();
                String checkMail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";


                if(email.isEmpty() || !email.matches(checkMail)) {
                    Toast.makeText(LoginActivity.this, "Email không đúng định dạng!", Toast.LENGTH_SHORT).show();
                }else if(password.length() < 6 ) {
                    Toast.makeText(LoginActivity.this, "Mật khẩu có ít nhất 6 ký tự!", Toast.LENGTH_SHORT).show();
                }else{
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
                    Query checkUserDatabase = reference.orderByChild("email").equalTo(email);

                    checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                binding.txtInputEmail.setError(null);
                                String passwordFromDb = snapshot.child(email).child("password").getValue(String.class);

                                if(passwordFromDb.equals(password)) {
                                    binding.txtInputEmail.setError(null);
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    binding.txtInputPassword.setError("Mật khẩu không đúng");
                                    binding.txtInputPassword.requestFocus();
                                }
                            }else{
                                binding.txtInputEmail.setError("Tài khoản không tồn tại");
                                binding.txtInputEmail.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }


                    });

                }
            }
        });

        binding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}