package com.group4.kidomtoystore.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.group4.kidomtoystore.Adapters.BannerHomeAdapter;
import com.group4.kidomtoystore.Adapters.CategoryAdapterRecycle;
import com.group4.kidomtoystore.Models.BannerHome;
import com.group4.kidomtoystore.Models.Category;
import com.group4.kidomtoystore.R;
import com.group4.kidomtoystore.databinding.ActivityHomePageFullBinding;

import java.util.ArrayList;

public class HomePageFull extends AppCompatActivity {

    ActivityHomePageFullBinding binding;

    CategoryAdapterRecycle adapter;

    ArrayList<Category> categoryList;

    ArrayList<BannerHome> bannerLists;

    BannerHomeAdapter adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageFullBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadLayoutRecycleView();
        initData();
        loadData();
    }

    private void loadLayoutRecycleView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.rvCategory.setLayoutManager(layoutManager);
//        binding.rvCategory.setHasFixedSize(true);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.rvBanner.setLayoutManager(layoutManager2);
//        binding.rvBanner.setHasFixedSize(true);
    }

    private void initData() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category(R.drawable.img_category_bupbe,"Búp bê"));
        categoryList.add(new Category(R.drawable.img_category_hoatrang,"Hoá trang"));
        categoryList.add(new Category(R.drawable.img_category_mythuat,"Mỹ thuật"));
        categoryList.add(new Category(R.drawable.img_category_ngoaitroi,"Ngoài trời"));
        categoryList.add(new Category(R.drawable.img_category_thethao,"Thể thao"));
        categoryList.add(new Category(R.drawable.img_category_tritue,"Trí tuệ"));


        bannerLists = new ArrayList<>();
        bannerLists.add(new BannerHome(R.drawable.img_bannerhome4));
        bannerLists.add(new BannerHome(R.drawable.img_banner));
        bannerLists.add(new BannerHome(R.drawable.img_banner_goc));


    }

    private void loadData() {
        adapter = new CategoryAdapterRecycle(getApplicationContext(), categoryList);
        binding.rvCategory.setAdapter(adapter);

        adapter2 = new BannerHomeAdapter(getApplicationContext(), bannerLists);
        binding.rvBanner.setAdapter(adapter2);
    }
}