package dev.olaore.paymentnetworks.di.app;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;

import dagger.Component;
import dev.olaore.paymentnetworks.data.remote.payments.PaymentsApiHelper;
import dev.olaore.paymentnetworks.ui.payments.fragments.PaymentMethodsFragment;
import dev.olaore.paymentnetworks.ui.payments.repos.PaymentMethodsRepository;
import retrofit2.Retrofit;

@Component(modules = { AppModule.class })
public interface AppComponent {

    Retrofit retrofit();

    PaymentMethodsRepository paymentMethodsRepository();

    PaymentsApiHelper paymentsApiHelper();

    void inject(PaymentMethodsFragment fragment);

    void inject(AndroidViewModel viewModel);

}
