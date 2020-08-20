package com.example.stockandinventorymanagement.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stockandinventorymanagement.R;
import com.example.stockandinventorymanagement.adapters.CustomersDataAdapter;
import com.example.stockandinventorymanagement.listsdata.CustList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class CustomersFragment extends Fragment {

    private SwipeRefreshLayout cust_swipeRefreshLayout;
    private RecyclerView cust_recyclerView;
    private CustomersDataAdapter cust_adapter;
    private List<CustList> cust_list;
    private FloatingActionButton addCustBtn;

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

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customers, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.expense_store_menu, menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Find Views
        cust_swipeRefreshLayout = view.findViewById(R.id.customers_swipeRefresh);
        cust_recyclerView = view.findViewById(R.id.customers_recyclerView);
        addCustBtn = view.findViewById(R.id.add_customers);

        cust_swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO get all data on refresh
                cust_swipeRefreshLayout.setRefreshing(false);
            }
        });

        final NavController navController = Navigation.findNavController(view);

        //adding customers
        addCustBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO send to add customer page
                navController.navigate(R.id.action_nav_customers_to_addCustomerFragment);
            }
        });

        //Recycler View Setup
//        cust_list = new ArrayList<>();
//        cust_adapter = new CustomersDataAdapter(cust_list, getContext());
//        cust_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        cust_recyclerView.setAdapter(cust_adapter);
    }
}
