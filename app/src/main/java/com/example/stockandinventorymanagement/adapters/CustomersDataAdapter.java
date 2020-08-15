package com.example.stockandinventorymanagement.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockandinventorymanagement.listsdata.CustList;

import java.util.List;

public class CustomersDataAdapter extends RecyclerView.Adapter<CustomersDataAdapter.ViewHolder> {

    Context context;
    List<CustList> custList;

    public CustomersDataAdapter(List<CustList> custList, Context context){
        this.context = context;
        this.custList = custList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomersDataAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return custList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
