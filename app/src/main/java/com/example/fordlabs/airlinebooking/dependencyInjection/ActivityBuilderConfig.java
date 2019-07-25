package com.example.fordlabs.airlinebooking.dependencyInjection;

import com.example.fordlabs.airlinebooking.activity.MainActivity;
import com.example.fordlabs.airlinebooking.activity.SecondActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderConfig {

    @ContributesAndroidInjector
    abstract SecondActivity providesSecondActivity();
}
