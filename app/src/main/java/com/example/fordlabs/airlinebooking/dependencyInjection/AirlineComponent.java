package com.example.fordlabs.airlinebooking.dependencyInjection;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,NetworkModule.class,ActivityBuilderConfig.class})
public interface AirlineComponent extends AndroidInjector<AirlineApplication> {
}
