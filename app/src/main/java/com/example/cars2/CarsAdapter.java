package com.example.cars2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {
    private ArrayList<Cars> cars;

    public CarsAdapter(ArrayList<Cars> cars) {
        this.cars = cars;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final TextView numberView;
        private final TextView yearView;

        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.etName);
            numberView = view.findViewById(R.id.etNumber);
            yearView = view.findViewById(R.id.etYear);
        }
    }

    @NonNull
    @Override
    public CarsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsAdapter.ViewHolder holder, int position) {
        Cars car = cars.get(position);
        Log.d("zapolnyaem view",car.toString());
        holder.nameView.setText(String.format("%s", car.getName()));
        holder.numberView.setText(String.format("%s", car.getNumber()));
        holder.yearView.setText(String.format("%d год", car.getYear()));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
