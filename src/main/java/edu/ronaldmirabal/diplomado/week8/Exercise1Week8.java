package edu.ronaldmirabal.diplomado.week8;

import edu.ronaldmirabal.diplomado.model.week8.ServicePaypal;
import edu.ronaldmirabal.diplomado.model.week8.ServiceStripe;
import edu.ronaldmirabal.diplomado.model.week8.network.*;

import java.util.UUID;

public class Exercise1Week8 {

    public PaymentResponse pay(PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = PaymentResponse.builder().id(UUID.randomUUID().toString()).build();
        if (paymentRequest.getProvider().equals(paymentRequest.getProvider().PAYPAL)){
            paymentResponse.setStatus(ServicePaypal.pay(paymentResponse.getId(), paymentRequest.getAmount()));
        }else if(paymentRequest.getProvider().equals(paymentRequest.getProvider().STRIPE)){
            paymentResponse.setStatus(ServiceStripe.pay(paymentResponse.getId(), paymentRequest.getAmount()));
        }
        return paymentResponse;
    }

    public CancelPaymentResponse cancel(CancelPaymentRequest cancelPaymentRequest) {
        CancelPaymentResponse cancelPaymentResponse = CancelPaymentResponse.builder().build();
        if (cancelPaymentRequest.getProvider().equals(cancelPaymentRequest.getProvider().PAYPAL)){
            cancelPaymentResponse.setStatus(ServicePaypal.cancel(cancelPaymentRequest.getId()));
        }else if(cancelPaymentRequest.getProvider().equals(cancelPaymentRequest.getProvider().STRIPE)){
            cancelPaymentResponse.setStatus(ServiceStripe.cancel(cancelPaymentRequest.getId()));
        }
        return cancelPaymentResponse;
    }

    public RefundPaymentResponse refund(RefundPaymentRequest refundPaymentRequest) {
        RefundPaymentResponse refundPaymentResponse = RefundPaymentResponse.builder().build();
        if (refundPaymentRequest.getProvider().equals(refundPaymentRequest.getProvider().PAYPAL)){
            refundPaymentResponse.setStatus(ServicePaypal.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()));
        }else if(refundPaymentRequest.getProvider().equals(refundPaymentRequest.getProvider().STRIPE)){
            refundPaymentResponse.setStatus(ServiceStripe.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()));
        }

        return refundPaymentResponse;
    }
}
