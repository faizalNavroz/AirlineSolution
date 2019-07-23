package com.example.fordlabs.airlinebooking.model;

import com.google.gson.annotations.SerializedName;

public class Quotes {

    @SerializedName("QuoteId")
    private int quoteId;

    @SerializedName("MinPrice")
    private Double price;

    @SerializedName("Direct")
    private boolean direct;

    @SerializedName("OutboundLeg")
    private OutboundLeg outboundLeg;


    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isDirect() {
        return direct;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }

    public OutboundLeg getOutboundLeg() {
        return outboundLeg;
    }

    public void setOutboundLeg(OutboundLeg outboundLeg) {
        this.outboundLeg = outboundLeg;
    }
}
