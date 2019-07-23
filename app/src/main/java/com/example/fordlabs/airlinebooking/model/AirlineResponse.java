package com.example.fordlabs.airlinebooking.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AirlineResponse {

    @SerializedName("Routes")
    private List<Routes> routes;

    @SerializedName("Quotes")
    private List<Quotes>quotes;

    @SerializedName("Places")
    private List<Places>places;

    @SerializedName("Carriers")
    private ArrayList<Carriers>carriers;

    @SerializedName("routes")
    private List<Currencies>currencies;



    public List<Currencies> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currencies> currencies) {
        this.currencies = currencies;
    }


    public List<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }

    public List<Quotes> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quotes> quotes) {
        this.quotes = quotes;
    }

    public List<Places> getPlaces() {
        return places;
    }

    public void setPlaces(List<Places> places) {
        this.places = places;
    }

    public ArrayList<Carriers> getCarriers() {
        return carriers;
    }

    public void setCarriers(ArrayList<Carriers> carriers) {
        this.carriers = carriers;
    }





}
