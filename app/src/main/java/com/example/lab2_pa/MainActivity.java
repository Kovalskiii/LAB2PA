package com.example.lab2_pa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.lab2_pa.AUTO.Vehicle;
import com.example.lab2_pa.MVP.MainContract;
import com.example.lab2_pa.MVP.MainPresenter;


import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {


    MainContract.MainPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);


        presenter = new MainPresenter(this);

        mAdapter = new VehicleAdapter(presenter.getList());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();


    }

    public void OnSortButton(View view) {
        switch (view.getId()) {
            case R.id.engine_sort:
                presenter.OnSortClicked(MainContract.SortBy.ENGINE_CAPACITY);
                break;
            case R.id.fuel_level_sort:
                presenter.OnSortClicked(MainContract.SortBy.FUEL_LEVEL);
                break;
            case R.id.fuel_tank_sort:
                presenter.OnSortClicked(MainContract.SortBy.FUEL_TANK);
                break;
            case R.id.wheel_sort:
                presenter.OnSortClicked(MainContract.SortBy.WHEEL_NUMBER);
                break;
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showVehicles(List<Vehicle> vehicles) {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void OnReload(View view) {
        presenter.OnReload();
        mAdapter.notifyDataSetChanged();
    }
}
