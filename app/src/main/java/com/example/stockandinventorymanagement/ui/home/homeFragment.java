package com.example.stockandinventorymanagement.ui.home;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stockandinventorymanagement.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment implements IhomeFragment{

    public TextView textView;


    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textView = view.findViewById(R.id.textView);
        setTextCustom("Welcome to Home");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setTextCustom(String message) {
        textView.setText(message);
    }
}
