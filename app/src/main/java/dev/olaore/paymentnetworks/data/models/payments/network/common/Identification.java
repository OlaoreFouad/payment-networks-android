package dev.olaore.paymentnetworks.data.models.payments.network.common;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Identification {

    @Expose
    private String longId;
    @Expose
    private String shortId;
    @Expose
    private String transactionId;

}
