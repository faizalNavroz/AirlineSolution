package com.example.fordlabs.airlinebooking.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class AirlineItemViewModel extends BaseObservable {

    private String name;

    private String carrierId;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Bindable
    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }
}
