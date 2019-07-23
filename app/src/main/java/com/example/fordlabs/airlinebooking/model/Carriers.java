package com.example.fordlabs.airlinebooking.model;

import com.google.gson.annotations.SerializedName;

public class Carriers {

    @SerializedName("CarrierId")
    private Integer carrierId;


    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    @SerializedName("Name")
    private String carrierName;


}
