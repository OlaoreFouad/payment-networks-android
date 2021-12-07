package dev.olaore.paymentnetworks.ui.payments.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import java.util.List;

import javax.inject.Inject;

import dev.olaore.paymentnetworks.PaymentNetworksApplication;
import dev.olaore.paymentnetworks.data.common.Result;
import dev.olaore.paymentnetworks.data.common.Status;
import dev.olaore.paymentnetworks.data.models.payments.domain.PaymentMethod;
import dev.olaore.paymentnetworks.databinding.FragmentPaymentMethodsBinding;
import dev.olaore.paymentnetworks.ui.payments.viewmodels.PaymentMethodsViewModel;
import retrofit2.Response;

public class PaymentMethodsFragment extends Fragment {

    private FragmentPaymentMethodsBinding binding;

    @Inject
    PaymentMethodsViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaymentNetworksApplication app = (PaymentNetworksApplication) requireActivity().getApplication();
        app.appComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPaymentMethodsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.paymentMethods().observe(getViewLifecycleOwner(), (result) -> {
            if (result.getStatus() == Status.SUCCESS) {
                Log.d("PaymentMethodsFragment", String.valueOf(result.getData().size()));
            }
        });

        viewModel.getPaymentMethods();

    }
}
