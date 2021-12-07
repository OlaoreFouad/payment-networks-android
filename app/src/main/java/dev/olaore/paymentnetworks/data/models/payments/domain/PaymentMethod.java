package dev.olaore.paymentnetworks.data.models.payments.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethod {

    private String imageUrl;

    private String name;

    public PaymentMethod(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

}
