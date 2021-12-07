package dev.olaore.paymentnetworks.data.models.payments.network.common;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {

    @Expose
    private Long amount;
    @Expose
    private String currency;
    @Expose
    private String reference;

}
