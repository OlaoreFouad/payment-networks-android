package dev.olaore.paymentnetworks.data.models.payments.network.common;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnCode {

    @Expose
    private String name;
    @Expose
    private String source;

}
