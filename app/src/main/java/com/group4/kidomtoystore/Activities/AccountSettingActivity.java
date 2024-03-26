package com.group4.kidomtoystore.Activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.group4.kidomtoystore.R;
import com.group4.kidomtoystore.databinding.ActivityAccountSettingBinding;

public class AccountSettingActivity extends AppCompatActivity {
    ActivityAccountSettingBinding binding;


    ActivityResultLauncher<Intent> activityResultLauncher;

    boolean openCam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountSettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                if (openCam) {
                    Bitmap photo = (Bitmap) result.getData().getExtras().get("data");
                    binding.imvPhoto.setImageBitmap(photo);
                }else{
                    Uri selectPhotoUri = result.getData().getData();
                    binding.imvPhoto.setImageURI(selectPhotoUri);
                }
            }
        });
    }

    private void addEvents() {

        binding.flUpdatePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet();
            }
        });
    }

    private void showBottomSheet() {
        Dialog dialog = new Dialog(AccountSettingActivity.this);
        dialog.setContentView(R.layout.bottom_sheet_profile_photo);;

        LinearLayout bsCam = dialog.findViewById(R.id.bsCamera);
        bsCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCam = true;
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultLauncher.launch(intent);
                dialog.dismiss();
            }
        });

        LinearLayout bsGal = dialog.findViewById(R.id.bsGallery);
        bsGal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCam = false;
//          Open Gallery
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intent);
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}