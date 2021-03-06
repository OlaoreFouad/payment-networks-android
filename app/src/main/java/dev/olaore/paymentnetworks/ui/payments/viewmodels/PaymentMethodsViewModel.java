package dev.olaore.paymentnetworks.ui.payments.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.inject.Inject;

import dev.olaore.paymentnetworks.PaymentNetworksApplication;
import dev.olaore.paymentnetworks.data.common.Result;
import dev.olaore.paymentnetworks.data.models.payments.domain.PaymentMethod;
import dev.olaore.paymentnetworks.data.models.payments.network.NetworkPaymentMethods;
import dev.olaore.paymentnetworks.ui.payments.repos.PaymentMethodsRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentMethodsViewModel extends ViewModel {

    PaymentMethodsRepository paymentMethodsRepository;

    private MutableLiveData<Result<List<PaymentMethod>>> _paymentMethods = new MutableLiveData<>();

    @Inject
    public PaymentMethodsViewModel(PaymentMethodsRepository paymentMethodsRepository) {
        this.paymentMethodsRepository = paymentMethodsRepository;
    }

    public void getPaymentMethods() {

        // post a loading state to the UI
        _paymentMethods.postValue(Result.loading());

        paymentMethodsRepository.getPaymentMethods().enqueue(new Callback<NetworkPaymentMethods>() {
            @Override
            public void onResponse(Call<NetworkPaymentMethods> call, Response<NetworkPaymentMethods> response) {
                try {
                    if (response.isSuccessful()) {
                        // if successful, post the retrieved data to the UI
                        _paymentMethods.postValue(Result.success(response.body().toDomainPaymentMethods()));
                    } else {
                        // if it error-ed out, send the message to the UI
                        _paymentMethods.postValue(Result.error(response.errorBody().string()));
                    }
                } catch (Exception ex) {
                    // if it error-ed out, send the message to the UI
                    _paymentMethods.postValue(Result.error(ex.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<NetworkPaymentMethods> call, Throwable t) {
                // if it error-ed out, send the message to the UI
                _paymentMethods.postValue(Result.error(t.getMessage()));
            }
        });
    }

    public LiveData<Result<List<PaymentMethod>>> paymentMethods() {
        return _paymentMethods;
    }

}
