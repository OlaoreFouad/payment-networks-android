package dev.olaore.paymentnetworks.data.models.payments.network.common;

import com.google.gson.annotations.Expose;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Applicable {

    @Expose
    private String code;
    @Expose
    private String grouping;
    @Expose
    private List<InputElement> inputElements;
    @Expose
    private String label;
    @Expose
    private Links links;
    @Expose
    private String method;
    @Expose
    private String operationType;
    @Expose
    private String recurrence;
    @Expose
    private Boolean redirect;
    @Expose
    private String registration;
    @Expose
    private Boolean selected;

}
