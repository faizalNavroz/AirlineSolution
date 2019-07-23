package com.example.fordlabs.airlinebooking.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.fordlabs.airlinebooking.R;
import com.example.fordlabs.airlinebooking.adapter.CustomAdapter;
import com.example.fordlabs.airlinebooking.databinding.ActivitySecondBinding;

import com.example.fordlabs.airlinebooking.viewmodel.AirlineViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class SecondActivity extends AppCompatActivity {


    @Inject
    AirlineViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivitySecondBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_second);

       // AirlineViewModel viewModel = new AirlineViewModel();


        String origin = getIntent().getExtras().getString("origin");
        String destination = getIntent().getExtras().getString("destination");
        String date = getIntent().getExtras().getString("date");

        Log.i("Main", "onCreate: "+origin+destination+date);
        viewModel.setDate(date);
        viewModel.setDestination(destination);
        viewModel.setOrigin(origin);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        activityMainBinding.recyler.setLayoutManager(layoutManager);


        activityMainBinding.setViewModel(viewModel);

        this.getLifecycle().addObserver(viewModel);

    }
}
