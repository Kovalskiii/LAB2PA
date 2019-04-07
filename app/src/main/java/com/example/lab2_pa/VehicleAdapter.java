package com.example.lab2_pa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab2_pa.AUTO.Vehicle;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.MyViewHolder> {
    private List<Vehicle> vehicles;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView engine_capacity, wheel_number, fuel_tank, fuel_level;

        public MyViewHolder(View view) {
            super(view);
            engine_capacity = view.findViewById(R.id.engine_capacity);
            wheel_number = view.findViewById(R.id.wheel_number);
            fuel_tank = view.findViewById(R.id.fuel_tank);
            fuel_level = view.findViewById(R.id.fuel_level);
        }
    }


    public VehicleAdapter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Vehicle vehicle = vehicles.get(position);
        holder.fuel_level.setText(Integer.toString(vehicle.getFuelLevel()));
        holder.engine_capacity.setText(Float.toString(vehicle.getEngineCapacity()));
        holder.fuel_tank.setText(Integer.toString(vehicle.getFuelTank()));
        holder.wheel_number.setText(Integer.toString(vehicle.getWheelNumber()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aPosition = holder.getAdapterPosition();
                vehicles.remove(aPosition);
                notifyItemRemoved(aPosition);
            }
        });

    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }
}
