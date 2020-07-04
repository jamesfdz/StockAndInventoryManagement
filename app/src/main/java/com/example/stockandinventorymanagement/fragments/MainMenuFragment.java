package com.example.stockandinventorymanagement.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.stockandinventorymanagement.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {

    private AppBarConfiguration mAppBarConfiguration;

    public MainMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        LinearLayout goodsLayout = view.findViewById(R.id.goodsButton_layout);
        LinearLayout docsLayout = view.findViewById(R.id.docsButton_layout);
        LinearLayout customersLayout = view.findViewById(R.id.customers_layout);
        LinearLayout suppliersLayout = view.findViewById(R.id.suppliersButton_layout);
        LinearLayout expensesLayout = view.findViewById(R.id.expenses_layout);
        LinearLayout reportsLayout = view.findViewById(R.id.reports_layout);
        LinearLayout settingsLayout = view.findViewById(R.id.settings_layout);
        LinearLayout helpLayout = view.findViewById(R.id.help_layout);
        LinearLayout whatsNewLayout = view.findViewById(R.id.whatsNew_layout);

        goodsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_main_menu_to_nav_goods);
            }
        });

        docsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_main_menu_to_nav_documents);
            }
        });
        customersLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_main_menu_to_nav_customers);
            }
        });
        suppliersLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_main_menu_to_nav_suppliers);
            }
        });
        expensesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_main_menu_to_nav_expenses);
            }
        });
        reportsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_main_menu_to_nav_reports);
            }
        });
        settingsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_main_menu_to_nav_settings);
            }
        });
        helpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_main_menu_to_nav_help);
            }
        });
        whatsNewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_main_menu_to_nav_new);
            }
        });
    }
}
