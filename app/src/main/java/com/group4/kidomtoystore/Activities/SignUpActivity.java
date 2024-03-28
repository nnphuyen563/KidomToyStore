package com.group4.kidomtoystore.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.group4.kidomtoystore.Models.User;
import com.group4.kidomtoystore.R;
import com.group4.kidomtoystore.databinding.ActivitySignUpBinding;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    DatePickerDialog datePickerDialog;
    //Set gender
    ArrayAdapter<String> genderAdapter;
    ArrayList<String> genderData;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth auth;
    Intent intent;
    public static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        loadGenderData();
        uploadProfileImage();
        getData();
        addEvents();
    }

    private void getData() {
        intent = getIntent();

        String email = intent.getStringExtra("email");
        binding.edtEmail.setText(email);
    }

    private void uploadProfileImage() {
    }

    private void loadGenderData() {
        String [] genders ={"Nữ", "Nam", "Khác"};
        genderData = new ArrayList<>(Arrays.asList(genders));
        genderAdapter = new ArrayAdapter<String>(SignUpActivity.this, R.layout.spinner_item, genderData);
//        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spGender.setAdapter(genderAdapter);
    }

    private void addEvents() {

        //set Calendar
        binding.edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(SignUpActivity.this,R.style.MyDatePickerStyle,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                binding.edtDOB.setText(i2 + "/" + (i1 + 1) + "/" + i);
                            }
                        }, mYear, mMonth, mDay);

                datePickerDialog.show();
                datePickerDialog.getButton(datePickerDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(SignUpActivity.this, R.color.primary_500));
                datePickerDialog.getButton(datePickerDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(SignUpActivity.this, R.color.primary_500));
            }
        });

        //set button change color
        binding.edtFullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!TextUtils.isEmpty(binding.edtFullName.getText().toString()) && !TextUtils.isEmpty(binding.edtDOB.getText().toString()) && !TextUtils.isEmpty(binding.edtPhone.getText().toString()) && !TextUtils.isEmpty(binding.edtEmail.getText().toString())) {
                    binding.btnContinue.setBackground(ContextCompat.getDrawable(SignUpActivity.this, R.drawable.button_available));
                }else{
                    binding.btnContinue.setBackgroundResource(R.drawable.button_disable);
                }
            }
        });
        binding.edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!TextUtils.isEmpty(binding.edtFullName.getText().toString()) && !TextUtils.isEmpty(binding.edtDOB.getText().toString()) && !TextUtils.isEmpty(binding.edtPhone.getText().toString()) && !TextUtils.isEmpty(binding.edtEmail.getText().toString())) {
                    binding.btnContinue.setBackground(ContextCompat.getDrawable(SignUpActivity.this, R.drawable.button_available));
                }else{
                    binding.btnContinue.setBackgroundResource(R.drawable.button_disable);
                }
            }
        });
        binding.edtDOB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!TextUtils.isEmpty(binding.edtFullName.getText().toString()) && !TextUtils.isEmpty(binding.edtDOB.getText().toString()) && !TextUtils.isEmpty(binding.edtPhone.getText().toString()) && !TextUtils.isEmpty(binding.edtEmail.getText().toString())) {
                    binding.btnContinue.setBackground(ContextCompat.getDrawable(SignUpActivity.this, R.drawable.button_available));
                }else{
                    binding.btnContinue.setBackgroundResource(R.drawable.button_disable);
                }
            }
        });
        binding.edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!TextUtils.isEmpty(binding.edtFullName.getText().toString()) && !TextUtils.isEmpty(binding.edtDOB.getText().toString()) && !TextUtils.isEmpty(binding.edtPhone.getText().toString()) && !TextUtils.isEmpty(binding.edtEmail.getText().toString())) {
                    binding.btnContinue.setBackground(ContextCompat.getDrawable(SignUpActivity.this, R.drawable.button_available));
                }else{
                    binding.btnContinue.setBackgroundResource(R.drawable.button_disable);
                }
            }
        });


        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = getIntent();
                String pass = intent.getStringExtra("pass");

                Integer ava = binding.imvAvatar.getImageAlpha();
                String name = binding.edtFullName.getText().toString().trim();
                String phone = binding.edtPhone.getText().toString().trim();
                String email = binding.edtEmail.getText().toString().trim();
                String gender = binding.spGender.getSelectedItem().toString();
                String dob = binding.edtDOB.getText().toString().trim();

                //validate
                if(TextUtils.isEmpty(name)) {
                    Toast.makeText(SignUpActivity.this, "Nhập tên của ba mẹ", Toast.LENGTH_SHORT).show();
                    binding.edtFullName.setError("Không được bỏ trống");
                    binding.edtFullName.requestFocus();
                }else if(TextUtils.isEmpty(phone)){
                    Toast.makeText(SignUpActivity.this, "Nhập số điện thoại của ba mẹ", Toast.LENGTH_SHORT).show();
                    binding.edtPhone.setError("Không được bỏ trống");
                    binding.edtPhone.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(SignUpActivity.this, "Nhập địa chỉ email của ba mẹ", Toast.LENGTH_SHORT).show();
                    binding.edtEmail.setError("Không được bỏ trống");
                    binding.edtEmail.requestFocus();
                }else if(TextUtils.isEmpty(dob)) {
                    Toast.makeText(SignUpActivity.this, "Nhập sinh nhật của ba mẹ", Toast.LENGTH_SHORT).show();
                    binding.edtDOB.setError("Không được bỏ trống");
                    binding.edtDOB.requestFocus();
                }else if(phone.length() < 10 || !phone.substring(0,1).equals("0")) {
                    Toast.makeText(SignUpActivity.this, "Số điện thoại sai định dạng", Toast.LENGTH_SHORT).show();
                    binding.edtPhone.setError("Sai định dạng");
                    binding.edtPhone.requestFocus();
                }else{
                    binding.progressbar.setVisibility(View.VISIBLE);
                    registerUser(name, email, phone, dob, gender, pass);
                }
            }
        });
    }

    private void registerUser(String name, String email, String phone, String dob, String gender, String pass) {
        auth = FirebaseAuth.getInstance();

        //Create user profile
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(SignUpActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            FirebaseUser firebaseUser = auth.getCurrentUser();

                            UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                            firebaseUser.updateProfile(profileChangeRequest);

                            //Enter user data into the Firebase Realtime Database
                            User user = new User(phone, email, dob, gender);

                            //extract user reference from Database for registered user
                            reference = FirebaseDatabase.getInstance().getReference("Registered Users");
                            reference.child(firebaseUser.getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()) {
                                        firebaseUser.sendEmailVerification();
                                        Toast.makeText(SignUpActivity.this, "Để hoàn tất đăng ký, ba mẹ vui lòng xác thực lại email", Toast.LENGTH_SHORT).show();

                                        //Open Login screen after successfull registeration
                                        intent = new Intent(SignUpActivity.this, MainActivity.class);
                                        //prevent user from returning back to Register Activity on pressing back button after registration
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                                                | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        Toast.makeText(SignUpActivity.this, "Đăng ký thất bại. Ba mẹ vui lòng đăng ký lại!", Toast.LENGTH_SHORT).show();
                                        binding.progressbar.setVisibility(View.GONE);
                                    }
                                }
                            });

                        }else{
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                binding.edtEmail.setError("Email của ba mẹ không hợp lệ hoặc đã tồn tại. Vui lòng nhập email khác");
                                binding.edtEmail.requestFocus();
                            } catch (FirebaseAuthUserCollisionException e) {
                                binding.edtEmail.setError("Email của ba mẹ không hợp lệ hoặc đã tồn tại. Vui lòng nhập email khác");
                                binding.edtEmail.requestFocus();
                            } catch (Exception e) {
                                Log.e(TAG, e.getMessage());
                                Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                        binding.progressbar.setVisibility(View.GONE);

                    }
                });
    }


}