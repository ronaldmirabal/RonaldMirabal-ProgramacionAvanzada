package edu.ronaldmirabal.diplomado.model.week8.payment;

public interface PaymentProcess<REQUEST, RESPONSE> {

    RESPONSE pay(REQUEST request);
}