package com.group4.kidomtoystore.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadGenderData();
        getData();
        addEvents();
    }
    private void getData() {
        Intent intent = getIntent();

        String phone = intent.getStringExtra("phone");
        String pass = intent.getStringExtra("pass");

        binding.edtPhone.setText(phone);
    }
    private boolean validateName(String name) {
        if (name.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Họ và tên không đúng định dạng", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

    private boolean validatePhone(String phone) {
        if(phone.isEmpty() || phone.length() < 10 || phone.substring(0,1) == "0") {
            Toast.makeText(SignUpActivity.this, "Số điện thoại không đúng định dạng", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

    private boolean validateEmail(String email) {
        String checkMail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        if(email.isEmpty() || email.matches(checkMail)) {
            Toast.makeText(SignUpActivity.this, "Email không đúng định dạng", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

    private void loadGenderData() {
        String [] genders ={"Nữ", "Nam", "Khác"};
        genderData = new ArrayList<>(Arrays.asList(genders));
        genderAdapter = new ArrayAdapter<String>(SignUpActivity.this, android.R.layout.simple_spinner_dropdown_item, genderData);
//        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spGender.setAdapter(genderAdapter);
    }

    private void addEvents() {
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

        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

                String name = binding.edtFullName.getText().toString().trim();
                String phone = binding.edtPhone.getText().toString().trim();
                String email = binding.edtEmail.getText().toString().trim();
                String gender = binding.spGender.getSelectedItem().toString();

                try {
                    Date dob = sdf.parse(binding.edtDOB.getText().toString().trim());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                if(validateName(name) || validateEmail(phone) || validatePhone(email)) {
                    Intent intent = new Intent(SignUpActivity.this, VerifyNewUserActivity.class);




                    startActivity(intent);
                }
            }
        });
    }


}