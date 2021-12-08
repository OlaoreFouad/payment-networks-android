package dev.olaore.paymentnetworks.ui.payments.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import dev.olaore.paymentnetworks.data.models.payments.domain.PaymentMethod;
import dev.olaore.paymentnetworks.databinding.ItemPaymentMethodBinding;

public class PaymentMethodsAdapter extends RecyclerView.Adapter<PaymentMethodsAdapter.PaymentMethodViewHolder> {

    List<PaymentMethod> paymentMethods;

    public PaymentMethodsAdapter(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @NonNull
    @Override
    public PaymentMethodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaymentMethodViewHolder(
                ItemPaymentMethodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentMethodViewHolder holder, int position) {
        PaymentMethod method = this.paymentMethods.get(position);
        holder.bind(method);
    }

    @Override
    public int getItemCount() {
        return this.paymentMethods.size();
    }

    class PaymentMethodViewHolder extends RecyclerView.ViewHolder {

        ItemPaymentMethodBinding binding;

        public PaymentMethodViewHolder(ItemPaymentMethodBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PaymentMethod method) {
            this.binding.paymentMethodName.setText(method.getName());
            Glide.with(
                    this.itemView.getContext()
            ).load(method.getImageUrl()).into(this.binding.paymentMethodImage);
        }

    }

}
