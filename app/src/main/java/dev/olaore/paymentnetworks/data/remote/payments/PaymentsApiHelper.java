package dev.olaore.paymentnetworks.data.remote.payments;

import org.json.JSONObject;

import javax.inject.Inject;

import dev.olaore.paymentnetworks.data.models.payments.network.NetworkPaymentMethods;
import dev.olaore.paymentnetworks.data.remote.PaymentMethodsService;
import retrofit2.Call;

public class PaymentsApiHelper {

    PaymentMethodsService paymentMethodsService;

    @Inject
    public PaymentsApiHelper(PaymentMethodsService paymentMethodsService){
        this.paymentMethodsService = paymentMethodsService;
    }

    public Call<NetworkPaymentMethods> getPaymentMethods() {
        return this.paymentMethodsService.getPaymentMethods();
    }

}
