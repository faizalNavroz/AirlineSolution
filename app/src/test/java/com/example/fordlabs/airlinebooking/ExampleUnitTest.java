package com.example.fordlabs.airlinebooking;

import com.example.fordlabs.airlinebooking.model.AirlineResponse;
import com.example.fordlabs.airlinebooking.model.Carriers;
import com.example.fordlabs.airlinebooking.network.ApiInterface;
import com.example.fordlabs.airlinebooking.viewmodel.AirlineViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {


    @Mock
    ApiInterface apiInterface;

    @Mock
    Observable<AirlineResponse> airlineResponseObservable;

    @Test
    public void testNetworkResponse(){
        TestObserver<AirlineResponse> testObserver= new TestObserver<AirlineResponse>();
        AirlineResponse airlineResponse= new AirlineResponse();
        ArrayList<Carriers>carriersList = new ArrayList<Carriers>();
        Carriers carriers = new Carriers();
        carriers.setCarrierId(1);
        carriers.setCarrierName("American Airlines");
        carriersList.add(carriers);
        airlineResponse.setCarriers(carriersList);

        when(apiInterface.getAirlineResponse("SFO-sky","ORD-sky","2019-09-01"))
                .thenReturn(Observable.<AirlineResponse>just(airlineResponse));


        apiInterface.getAirlineResponse("SFO-sky","ORD-sky","2019-09-01").subscribeWith(testObserver);
        testObserver.awaitTerminalEvent();
       testObserver.assertNoErrors();
       testObserver.assertValue(airlineResponse);

    }


}