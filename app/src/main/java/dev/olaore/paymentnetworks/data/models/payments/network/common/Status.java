package dev.olaore.paymentnetworks.data.models.payments.network.common;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {

    @Expose
    private String code;
    @Expose
    private String reason;

}
