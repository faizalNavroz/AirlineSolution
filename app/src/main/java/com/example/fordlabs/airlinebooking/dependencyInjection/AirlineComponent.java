package com.example.fordlabs.airlinebooking.dependencyInjection;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class,NetworkModule.class,ActivityBuilderConfig.class})
public interface AirlineComponent extends AndroidInjector<AirlineApplication> {
}
