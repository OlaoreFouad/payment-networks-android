package dev.olaore.paymentnetworks.data.remote;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PaymentMethodsService {

    @GET("listresult.json")
    Call<JSONObject> getPaymentMethods();

}