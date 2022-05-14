package edu.ronaldmirabal.diplomado.model.week3;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Quote {
    private BigDecimal amount;
    private LocalDate date;
}
