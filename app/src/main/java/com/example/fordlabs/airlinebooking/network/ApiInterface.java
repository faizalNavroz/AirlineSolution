package com.example.fordlabs.airlinebooking.network;


import com.example.fordlabs.airlinebooking.model.AirlineResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiInterface {

    // Call<List<Playlist> getUserPlaylists(@Path(value = "user_id", encoded = true
    //public Observable<AirlineResponse> getAirlineResponse();

    @GET("/apiservices/browseroutes/v1.0/US/USD/en-US/{originplace}/{destinationplace}/{outboundpartialdate}")
    public Observable<AirlineResponse> getAirlineResponse(@Path(value = "originplace", encoded = true) String originPlace, @Path(value = "destinationplace") String destination,
                                                          @Path(value = "outboundpartialdate") String outboundpartialdate);
}
