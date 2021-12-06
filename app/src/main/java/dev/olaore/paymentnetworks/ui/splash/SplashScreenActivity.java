package dev.olaore.paymentnetworks.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import dev.olaore.paymentnetworks.MainActivity;
import dev.olaore.paymentnetworks.R;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(this::openMainApplication, 3000);
    }

    private void openMainApplication() {
        startActivity(new Intent(
                this, MainActivity.class
        ));
        finish();
    }
}