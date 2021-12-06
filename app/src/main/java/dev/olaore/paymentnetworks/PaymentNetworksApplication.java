package dev.olaore.paymentnetworks;

import android.app.Application;

import dev.olaore.paymentnetworks.di.app.AppComponent;
import dev.olaore.paymentnetworks.di.app.DaggerAppComponent;

public class PaymentNetworksApplication extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }
}
