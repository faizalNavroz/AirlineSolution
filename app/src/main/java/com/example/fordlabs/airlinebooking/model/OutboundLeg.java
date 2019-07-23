package com.example.fordlabs.airlinebooking.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OutboundLeg {

    @SerializedName("CarrierIds")
    private ArrayList<Integer>carriersList;

    @SerializedName("OriginId")
    private Double originId;

    @SerializedName("DestinationId")
    private Double destinationId;


    public ArrayList<Integer> getCarriersList() {
        return carriersList;
    }

    public void setCarriersList(ArrayList<Integer> carriersList) {
        this.carriersList = carriersList;
    }

    public Double getOriginId() {
        return originId;
    }

    public void setOriginId(Double originId) {
        this.originId = originId;
    }

    public Double getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Double destinationId) {
        this.destinationId = destinationId;
    }
}
