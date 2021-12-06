package dev.olaore.paymentnetworks.di.app;

import dagger.Module;
import dagger.Provides;
import dev.olaore.paymentnetworks.data.remote.PaymentMethodsService;
import dev.olaore.paymentnetworks.data.remote.payments.PaymentsApiHelper;
import dev.olaore.paymentnetworks.ui.payments.repos.PaymentMethodsRepository;
import dev.olaore.paymentnetworks.util.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    Retrofit retrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.PAYMENT_METHODS_BASE_URL)
                .build();
    }

    @Provides
    PaymentMethodsService paymentMethodsService(Retrofit retrofit) {
        return retrofit.create(PaymentMethodsService.class);
    }

    @Provides
    PaymentsApiHelper paymentsApiHelper() {
        return new PaymentsApiHelper();
    }

}
