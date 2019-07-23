package com.example.fordlabs.airlinebooking.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static Retrofit retrofit=null;

    private static String url ="https://community-open-weather-map.p.rapidapi.com/apiservices";

    public static Retrofit getRetrofit(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
                                      @Override
                                      public Response intercept(Chain chain) throws IOException {
                                          Request original = chain.request();

                                          Request request = original.newBuilder()
                                                  .header("Accept", "application/json")
                                                  .header("X-RapidAPI-Key", "f3bf0c39ddmshde043f2e5ee394bp1d90abjsnf31149a1768f")
                                                  .method(original.method(), original.body())
                                                  .build();

                                          return chain.proceed(request);
                                      }
                                  });


        OkHttpClient client = httpClient.build();

        retrofit = new Retrofit.Builder().baseUrl(getBaseUrl()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(client).build();


        return retrofit;
    }

    private static String getBaseUrl() {

        String origin="SFO-sky";
        String destination = "ORD-sky";
        String date ="2019-09-01";

        return "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    }
}
