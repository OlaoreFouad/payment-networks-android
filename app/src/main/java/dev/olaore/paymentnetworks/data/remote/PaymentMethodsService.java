package dev.olaore.paymentnetworks.data.remote;

import org.json.JSONObject;

import dev.olaore.paymentnetworks.data.models.payments.network.NetworkPaymentMethods;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PaymentMethodsService {

    @GET("listresult.json")
    Call<NetworkPaymentMethods> getPaymentMethods();

}