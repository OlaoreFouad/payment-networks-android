package dev.olaore.paymentnetworks.di.app;

import dagger.Module;
import dagger.Provides;
import dev.olaore.paymentnetworks.data.remote.PaymentMethodsService;
import dev.olaore.paymentnetworks.data.remote.payments.PaymentsApiHelper;
import dev.olaore.paymentnetworks.ui.payments.repos.PaymentMethodsRepository;
import dev.olaore.paymentnetworks.util.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    Retrofit retrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.PAYMENT_METHODS_BASE_URL)
                .client(client)
                .build();
    }

    @Provides
    PaymentMethodsService paymentMethodsService(Retrofit retrofit) {
        return retrofit.create(PaymentMethodsService.class);
    }

    @Provides
    PaymentsApiHelper paymentsApiHelper(PaymentMethodsService paymentMethodsService) {
        return new PaymentsApiHelper(paymentMethodsService);
    }

}
