package edu.ronaldmirabal.diplomado.model.week4;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class IceScream {
    private String id;
    private String name;
    private String flavor;
    private BigDecimal amount;
}
