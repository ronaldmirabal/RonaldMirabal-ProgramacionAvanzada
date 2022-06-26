package edu.ronaldmirabal.diplomado.model.week8.network;


import edu.ronaldmirabal.diplomado.model.week8.enums.Provider;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 4/24/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentRequest {

    private Provider provider; // Stripe or Paypal
    private BigDecimal amount;
}
