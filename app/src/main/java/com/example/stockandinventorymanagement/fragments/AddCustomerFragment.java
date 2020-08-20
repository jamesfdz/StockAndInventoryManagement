package com.example.stockandinventorymanagement.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stockandinventorymanagement.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddCustomerFragment extends Fragment {

    private EditText customer_name, customer_address, customer_email, customer_phone;
    private TextInputEditText customer_notes, customer_discount;
    private TextInputLayout name_inputlayout, address_inputlayout, email_inputlayout, phone_inputlayout;

    public AddCustomerFragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_customer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //find all views
        customer_name = view.findViewById(R.id.customer_name);
        customer_address = view.findViewById(R.id.customer_address);
        customer_email = view.findViewById(R.id.customer_email);
        customer_phone = view.findViewById(R.id.customer_phone);
        customer_notes = view.findViewById(R.id.customer_notes);
        customer_discount = view.findViewById(R.id.customer_discount);
        name_inputlayout = view.findViewById(R.id.nameInputLayout);
        address_inputlayout = view.findViewById(R.id.address_inputLayout);
        email_inputlayout = view.findViewById(R.id.email_inputLayout);
        phone_inputlayout = view.findViewById(R.id.phone_inputLayout);

        customer_email.addTextChangedListener(new EditTextWatcher(getContext(), email_inputlayout, customer_email));
    }

    public class EditTextWatcher implements TextWatcher{

        Context context;
        TextInputLayout layout;
        EditText view;

        public EditTextWatcher(Context context, TextInputLayout layout, EditText view){
            this.context = context;
            this.layout = layout;
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()){

            }
        }
    }

    public static boolean isEmailValid(String email){

        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }

    public static boolean isPhoneValid(String phone){

        return  !TextUtils.isEmpty(phone) && Patterns.PHONE.matcher(phone).matches();

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.addcust_menu, menu);
    }

    public void saveData_toFirebase(){

    }

}