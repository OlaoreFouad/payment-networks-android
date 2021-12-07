
package dev.olaore.paymentnetworks.data.models.payments.network;


import com.google.gson.annotations.Expose;

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
}

