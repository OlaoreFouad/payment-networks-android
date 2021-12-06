package dev.olaore.paymentnetworks.ui.payments.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONObject;

import javax.inject.Inject;

import dev.olaore.paymentnetworks.PaymentNetworksApplication;
import dev.olaore.paymentnetworks.ui.payments.repos.PaymentMethodsRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentMethodsViewModel extends ViewModel {

    PaymentMethodsRepository paymentMethodsRepository;

    private MutableLiveData<Response<JSONObject>> _paymentMethods;

    @Inject
    public PaymentMethodsViewModel(PaymentMethodsRepository paymentMethodsRepository) {
        this.paymentMethodsRepository = paymentMethodsRepository;
    }

    public void getPaymentMethods() {
        paymentMethodsRepository.getPaymentMethods().enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if (response.isSuccessful()) {
                    Log.d("PaymentMethodsViewModel", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.d("PaymentMethodsViewModel", t.getMessage());
            }
        });
    }

    public LiveData<Response<JSONObject>> paymentMethods() {
        return _paymentMethods;
    }

}
