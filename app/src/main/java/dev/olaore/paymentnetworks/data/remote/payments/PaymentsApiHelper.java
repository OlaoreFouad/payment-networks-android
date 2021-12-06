package dev.olaore.paymentnetworks.data.remote.payments;

import org.json.JSONObject;

import javax.inject.Inject;

import dev.olaore.paymentnetworks.data.remote.PaymentMethodsService;
import retrofit2.Call;

public class PaymentsApiHelper {

    @Inject
    PaymentMethodsService paymentMethodsService;

    public PaymentsApiHelper(){
    }

    public Call<JSONObject> getPaymentMethods() {
        return this.paymentMethodsService.getPaymentMethods();
    }

}
