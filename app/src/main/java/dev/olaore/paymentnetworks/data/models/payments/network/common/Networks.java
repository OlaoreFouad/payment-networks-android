package dev.olaore.paymentnetworks.data.models.payments.network.common;

import com.google.gson.annotations.Expose;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Networks {

    @Expose
    private List<Applicable> applicable;

}
