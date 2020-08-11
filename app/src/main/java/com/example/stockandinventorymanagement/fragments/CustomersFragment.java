package com.example.stockandinventorymanagement.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.stockandinventorymanagement.R;
import com.example.stockandinventorymanagement.adapters.CustomersDataAdapter;
import com.example.stockandinventorymanagement.listsdata.CustList;

import java.util.ArrayList;
import java.util.List;


public class CustomersFragment extends Fragment {

    private SwipeRefreshLayout cust_swipeRefreshLayout;
    private RecyclerView cust_recyclerView;
    private CustomersDataAdapter cust_adapter;
    private List<CustList> cust_list;

    public CustomersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        setHasOptionsMenu(true);

        //Find Views
        cust_swipeRefreshLayout = getView().findViewById(R.id.customers_swipeRefresh);
        cust_recyclerView = getView().findViewById(R.id.customers_recyclerView);

        cust_swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO get all data on refresh
                cust_swipeRefreshLayout.setRefreshing(false);
            }
        });

        //Recycler View Setup
        cust_list = new ArrayList<>();
        cust_adapter = new CustomersDataAdapter(cust_list, getContext());
        cust_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cust_recyclerView.setAdapter(cust_adapter);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customers, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.expense_store_menu, menu);
    }
}
