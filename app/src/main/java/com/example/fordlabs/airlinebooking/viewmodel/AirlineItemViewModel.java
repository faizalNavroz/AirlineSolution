package com.example.fordlabs.airlinebooking.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class AirlineItemViewModel extends BaseObservable {

    private String price;

    private String direct;

    @Bindable
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    @Bindable
    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

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
