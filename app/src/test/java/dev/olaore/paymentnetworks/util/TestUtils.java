package dev.olaore.paymentnetworks.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import dev.olaore.paymentnetworks.data.models.payments.domain.PaymentMethod;
import dev.olaore.paymentnetworks.data.models.payments.network.NetworkPaymentMethods;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public class TestUtils {

    public static NetworkPaymentMethods NETWORK_PAYMENT_METHODS = new NetworkPaymentMethods();
    public static List<PaymentMethod> PAYMENT_METHODS = Arrays.asList(
            new PaymentMethod("FouadCard", "https://imgurl.com/img1.jpg"),
            new PaymentMethod("FouadCard2", "https://imgurl.com/img2.jpg"),
            new PaymentMethod("FouadCard3", "https://imgurl.com/img3.jpg"),
            new PaymentMethod("FouadCard4", "https://imgurl.com/img4.jpg"),
            new PaymentMethod("FouadCard5", "https://imgurl.com/img5.jpg")
    );

    public static ResponseBody ERROR_RESPONSE = ResponseBody.create(MediaType.parse("application/json"), "");

}
