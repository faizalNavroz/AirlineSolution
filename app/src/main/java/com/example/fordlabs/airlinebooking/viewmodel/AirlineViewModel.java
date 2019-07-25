package com.example.fordlabs.airlinebooking.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.util.Log;

import com.example.fordlabs.airlinebooking.BR;
import com.example.fordlabs.airlinebooking.adapter.CustomAdapter;
import com.example.fordlabs.airlinebooking.model.AirlineResponse;
import com.example.fordlabs.airlinebooking.model.Carriers;
import com.example.fordlabs.airlinebooking.model.Quotes;
import com.example.fordlabs.airlinebooking.network.ApiInterface;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AirlineViewModel extends BaseObservable implements LifecycleObserver {


    private String origin;

    private String destination;


    @Inject
    public AirlineViewModel() {
    }

    @Inject
    ApiInterface apiInterface;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    private Integer itemSize = 0;

    private boolean isCurrencyConvertedtoINR = false;

    private boolean isCurrencyConvertedtoUSD = true;

    public Integer getItemSize() {
        return itemSize;
    }

    ArrayList<AirlineItemViewModel> carriersList = new ArrayList<AirlineItemViewModel>();

    CustomAdapter adapter = new CustomAdapter();

    public CustomAdapter getAdapter() {
        return adapter;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getAirlineResponse(){

        Log.i("***", "getAirlineResponse: ");
        Log.i("***",this.getOrigin()+this.getDestination()+this.getDate());
        apiInterface.getAirlineResponse(this.getOrigin(),this.getDestination(),this.getDate())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<AirlineResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(AirlineResponse value) {
                Log.i("***", "onNext: "+value.getCarriers().get(0).toString());
                Log.i("************", "onNext: "+value.getCarriers().get(0).toString());

                for(Quotes quotes : value.getQuotes()){
                    AirlineItemViewModel itemViewModel = new AirlineItemViewModel();

                    itemViewModel.setDirect(quotes.isDirect() == true ? "Direct":"InDirect");
                    itemViewModel.setPrice(quotes.getPrice().toString());

                    for(Integer carrierId : quotes.getOutboundLeg().getCarriersList()){
                        for(Carriers carriers : value.getCarriers()){
                            if(carrierId.equals(carriers.getCarrierId())){
                                itemViewModel.setCarrierId("CARRIER ID :"+carriers.getCarrierId().toString());
                                itemViewModel.setName(carriers.getCarrierName());
                            }
                        }


                        carriersList.add(itemViewModel);

                    }

                }

                /*for(Carriers carriers : value.getCarriers()){
                    AirlineItemViewModel itemViewModel = new AirlineItemViewModel();
                    itemViewModel.setCarrierId(carriers.getCarrierId().toString());
                    itemViewModel.setName(carriers.getCarrierName());
                    carriersList.add(itemViewModel);

                }*/

                adapter.setItemViewModels(carriersList);
                itemSize = carriersList.size();
                notifyPropertyChanged(BR._all);
                Log.i("************", "onNext: "+carriersList.get(0).getName());

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void getSortedCarriersByPrice() {
        Comparator<AirlineItemViewModel> priceComparator = new Comparator<AirlineItemViewModel>(){
            @Override
            public int compare(AirlineItemViewModel o1, AirlineItemViewModel o2) {

                return Double.valueOf(o1.getPrice()).compareTo(Double.valueOf(o2.getPrice()));
            }
        };
        Collections.sort(carriersList,priceComparator);
       /* adapter.setItemViewModels(carriersList);
        itemSize = carriersList.size();
        notifyPropertyChanged(BR._all);*/
        setAdapterWithUpdatedViewModels(carriersList);

    }

    public  void getSortedCarriersByDirect() {

        Comparator<AirlineItemViewModel> directComparator = new Comparator<AirlineItemViewModel>(){
            @Override
            public int compare(AirlineItemViewModel o1, AirlineItemViewModel o2) {

                return o1.getDirect().compareTo(o2.getDirect());
            }
        };
        Collections.sort(carriersList,directComparator);
       /* adapter.setItemViewModels(carriersList);
        itemSize = carriersList.size();
        notifyPropertyChanged(BR._all);*/
        setAdapterWithUpdatedViewModels(carriersList);


    }

    public  void displaypricesInINR(){
        if(isCurrencyConvertedtoUSD && !isCurrencyConvertedtoINR){
            for(AirlineItemViewModel  airlineItem : carriersList){
             airlineItem.setPrice(getINRPrice(airlineItem.getPrice()));
    }
    isCurrencyConvertedtoINR = true;
            isCurrencyConvertedtoUSD=false;
    /*adapter.setItemViewModels(carriersList);
    itemSize = carriersList.size();
    notifyPropertyChanged(BR._all);*/
            setAdapterWithUpdatedViewModels(carriersList);
    }

    }

    public  String getINRPrice(String price) {
            Double usdPrice = Double.valueOf(price);
            Double inrPrice = usdPrice * 68.99;
            DecimalFormat df = new DecimalFormat("####0.00");
        return df.format(inrPrice).toString();

    }

    public  void getUSDPrice(){
        if(isCurrencyConvertedtoINR && !isCurrencyConvertedtoUSD){
            for(AirlineItemViewModel  airlineItem : carriersList){
                Double usdPrice = Double.valueOf(airlineItem.getPrice())/68.99;
                DecimalFormat df = new DecimalFormat("####0.00");
                airlineItem.setPrice(df.format(usdPrice).toString());
            }
            isCurrencyConvertedtoUSD= true;
            isCurrencyConvertedtoINR=false;
            setAdapterWithUpdatedViewModels(carriersList);
            /*adapter.setItemViewModels(carriersList);
            itemSize = carriersList.size();
            notifyPropertyChanged(BR._all);*/
        }


    }

    public void setAdapterWithUpdatedViewModels(ArrayList<AirlineItemViewModel> carriersList){
        adapter.setItemViewModels(this.carriersList);
        itemSize = this.carriersList.size();
        notifyPropertyChanged(BR._all);
    }


}
