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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCustomerFragment extends Fragment {

    private EditText customer_name, customer_address, customer_email, customer_phone;
    private TextInputEditText customer_notes, customer_discount;
    private TextInputLayout name_inputlayout, address_inputlayout, email_inputlayout, phone_inputlayout;
    private boolean isEmailValid = false, isPhoneValid = false, isNameEmpty = false;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    private String currentUser_id;

    public AddCustomerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mAuth = FirebaseAuth.getInstance();
        try {
            currentUser_id = mAuth.getCurrentUser().getUid();
        }catch (Exception e){
            currentUser_id = null;
            Toast.makeText(getActivity().getApplicationContext(), "Error fetching uid: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        firebaseFirestore = FirebaseFirestore.getInstance();
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

        //set listener for validation
        customer_email.addTextChangedListener(new EditTextWatcher(getContext(), email_inputlayout, customer_email));
        customer_phone.addTextChangedListener(new EditTextWatcher(getContext(), phone_inputlayout, customer_phone));
        customer_name.addTextChangedListener(new EditTextWatcher(getContext(), name_inputlayout, customer_name));

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
                case R.id.customer_email:
                    if(!isEmailValid(customer_email.getText().toString())){
                        email_inputlayout.setError("Invalid E-mail");
                        customer_email.requestFocus();
                        isEmailValid = false;
                    }else{
                        email_inputlayout.setErrorEnabled(false);
                        isEmailValid = true;
                    }
                    break;
                case R.id.customer_phone:
                    if(!isPhoneValid(customer_phone.getText().toString())){
                        phone_inputlayout.setError("Invalid Phone Number");
                        customer_phone.requestFocus();
                        isPhoneValid = false;
                    }else{
                        phone_inputlayout.setErrorEnabled(false);
                        isPhoneValid = true;
                    }
                    break;
                case R.id.customer_name:
                    if(TextUtils.isEmpty(customer_name.getText().toString())){
                        name_inputlayout.setError("Name cannot be empty");
                        customer_name.requestFocus();
                        isNameEmpty = false;
                    }else{
                        name_inputlayout.setErrorEnabled(false);
                        isNameEmpty = true;
                    }
                default:
                    break;
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.addcustomer_save:
                if(isEmailValid && isPhoneValid && isNameEmpty){
                    String name = customer_name.getText().toString();
                    String address = customer_address.getText().toString();
                    String email = customer_email.getText().toString();
                    String phone = customer_phone.getText().toString();
                    String notes = customer_notes.getText().toString();
                    String discount = customer_discount.getText().toString();
                    saveDataToFirebase(name, address, email, phone, notes, discount);
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter all the required details", Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveDataToFirebase(String name, String address, String email, String phone, String notes, String discount) {

        Map<String, Object> customer_map =new HashMap<>();
        customer_map.put("name", name);
        customer_map.put("address", address);
        customer_map.put("email", email);
        customer_map.put("phone", phone);
        customer_map.put("notes", notes);
        customer_map.put("discount", discount);

        if(currentUser_id != null){
            firebaseFirestore.collection("Users").document(currentUser_id)
                    .collection("customers").add(customer_map)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getActivity().getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                                getActivity().getSupportFragmentManager().popBackStack(); //goback
                            }else{
                                Toast.makeText(getActivity().getApplicationContext(), "Error saving to database: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else{
            Toast.makeText(getActivity().getApplicationContext(), "Error saving, no uid found", Toast.LENGTH_SHORT).show();
        }
    }
}