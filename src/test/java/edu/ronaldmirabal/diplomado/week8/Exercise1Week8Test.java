package edu.ronaldmirabal.diplomado.week8;

import edu.ronaldmirabal.diplomado.model.week8.enums.Provider;
import edu.ronaldmirabal.diplomado.model.week8.network.PaymentRequest;
import edu.ronaldmirabal.diplomado.model.week8.network.PaymentResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class Exercise1Week8Test {
    private final Exercise1Week8 exercise1Week8 = new Exercise1Week8();
    private String lastPayment;

    @Test
    void payTest() {
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .provider(Provider.STRIPE)
                .amount(new BigDecimal(20))
                .build();
        PaymentResponse paymentResponse = exercise1Week8.pay(paymentRequest);
        assertNotNull(paymentResponse);
        lastPayment = paymentResponse.getId();
    }
}