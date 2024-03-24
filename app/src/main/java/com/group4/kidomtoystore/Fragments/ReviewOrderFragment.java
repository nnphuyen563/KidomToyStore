package com.group4.kidomtoystore.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group4.kidomtoystore.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReviewOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReviewOrderFragment extends Fragment {
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_order, container, false);
    }
}