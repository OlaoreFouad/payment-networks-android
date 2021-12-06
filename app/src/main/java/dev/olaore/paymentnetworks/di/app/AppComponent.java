package dev.olaore.paymentnetworks.di.app;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = { AppModule.class })
public interface AppComponent {

    Retrofit retrofit();

}
