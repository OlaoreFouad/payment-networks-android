package dev.olaore.paymentnetworks.ui.payments.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import dev.olaore.paymentnetworks.PaymentNetworksApplication;
import dev.olaore.paymentnetworks.data.models.payments.network.NetworkPaymentMethods;
import dev.olaore.paymentnetworks.ui.payments.repos.PaymentMethodsRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentMethodsViewModel extends ViewModel {

    PaymentMethodsRepository paymentMethodsRepository;

    private MutableLiveData<Response<NetworkPaymentMethods>> _paymentMethods;

    @Inject
    public PaymentMethodsViewModel(PaymentMethodsRepository paymentMethodsRepository) {
        this.paymentMethodsRepository = paymentMethodsRepository;
    }

    public void getPaymentMethods() {
        paymentMethodsRepository.getPaymentMethods().enqueue(new Callback<NetworkPaymentMethods>() {
            @Override
            public void onResponse(Call<NetworkPaymentMethods> call, Response<NetworkPaymentMethods> response) {
                Log.d("PaymentMethodsViewModel", "" + response.code());
                if (response.isSuccessful()) {
                    try {
                        Log.d("PaymentMethodsViewModel", response.body().getLinks().getSelf());
                    } catch (Exception ex) {
                        Log.d("PaymentMethodsViewModel", ex.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<NetworkPaymentMethods> call, Throwable t) {
                Log.d("PaymentMethodsViewModel", t.getMessage());
            }
        });
    }

    public LiveData<Response<NetworkPaymentMethods>> paymentMethods() {
        return _paymentMethods;
    }

}
