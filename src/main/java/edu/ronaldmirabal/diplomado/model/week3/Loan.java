package edu.ronaldmirabal.diplomado.model.week3;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Loan {
    private LoanType loanType;
    private FrequencyType frequencyType;
    private BigDecimal capital;
    private Integer quotes;
    private BigDecimal interest;
    private LocalDate startDate;
}
