
package dev.olaore.paymentnetworks.data.models.payments.network;


import android.os.Build;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.olaore.paymentnetworks.data.models.payments.domain.PaymentMethod;
import dev.olaore.paymentnetworks.data.models.payments.network.common.Applicable;
import dev.olaore.paymentnetworks.data.models.payments.network.common.Identification;
import dev.olaore.paymentnetworks.data.models.payments.network.common.Interaction;
import dev.olaore.paymentnetworks.data.models.payments.network.common.Links;
import dev.olaore.paymentnetworks.data.models.payments.network.common.Networks;
import dev.olaore.paymentnetworks.data.models.payments.network.common.Payment;
import dev.olaore.paymentnetworks.data.models.payments.network.common.ReturnCode;
import dev.olaore.paymentnetworks.data.models.payments.network.common.Status;
import dev.olaore.paymentnetworks.data.models.payments.network.common.Style;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NetworkPaymentMethods {

    @Expose
    private Identification identification;
    @Expose
    private String integrationType;
    @Expose
    private Interaction interaction;
    @Expose
    private Links links;
    @Expose
    private Networks networks;
    @Expose
    private String operation;
    @Expose
    private String operationType;
    @Expose
    private Payment payment;
    @Expose
    private String resultCode;
    @Expose
    private String resultInfo;
    @Expose
    private ReturnCode returnCode;
    @Expose
    private Status status;
    @Expose
    private Style style;
    @Expose
    private String timestamp;

    public List<PaymentMethod> toDomainPaymentMethods() {
        List<PaymentMethod> methods = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return this.networks.getApplicable().stream()
                    .map(network -> new PaymentMethod(network.getLabel(), network.getLinks().getLogo()))
                    .collect(Collectors.toList());
        } else {
            for (Applicable applicable : this.networks.getApplicable()) {
                methods.add(new PaymentMethod(applicable.getLabel(), applicable.getLinks().getLogo()));
            }
        }

        return methods;
    }

}

