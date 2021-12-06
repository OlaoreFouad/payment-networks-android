package dev.olaore.paymentnetworks.ui.payments.repos;

import org.json.JSONObject;

import javax.inject.Inject;

import dev.olaore.paymentnetworks.data.remote.payments.PaymentsApiHelper;
import retrofit2.Call;

public class PaymentMethodsRepository {

    PaymentsApiHelper paymentsApiHelper;

    @Inject
    public PaymentMethodsRepository(PaymentsApiHelper paymentsApiHelper) {
        this.paymentsApiHelper = paymentsApiHelper;
    }

    public Call<JSONObject> getPaymentMethods() {
        return this.paymentsApiHelper.getPaymentMethods();
    }

}
