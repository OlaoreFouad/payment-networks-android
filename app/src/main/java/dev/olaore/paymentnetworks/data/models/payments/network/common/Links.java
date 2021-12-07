package dev.olaore.paymentnetworks.data.models.payments.network.common;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Links {

    @Expose
    private String lang;
    @Expose
    private String logo;
    @Expose
    private String operation;
    @Expose
    private String self;
    @Expose
    private String validation;

}
