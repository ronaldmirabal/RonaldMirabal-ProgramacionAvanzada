package edu.ronaldmirabal.diplomado.week3;

import edu.ronaldmirabal.diplomado.model.week3.FrequencyType;
import edu.ronaldmirabal.diplomado.model.week3.Loan;
import edu.ronaldmirabal.diplomado.model.week3.LoanType;
import edu.ronaldmirabal.diplomado.model.week3.Quote;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Homework {
    public List<Quote> calculateQuotes(Loan loan) {
        if (loan == null) {
            return null;
        }
        if (loan.getLoanType() == null || loan.getFrequencyType() == null || loan.getCapital() == null || loan.getQuotes() == null || loan.getInterest() == null || loan.getStartDate() == null) {
            return new ArrayList<>();
        }
        LocalDate last = loan.getStartDate();
        List<Quote> quotes = new ArrayList<>();
        for (int i = 1; i <= loan.getQuotes(); i++) {
            last = calculateDate(loan.getFrequencyType(), last);
            Quote quote = new Quote();
            quote.setDate(last);
            switch (loan.getLoanType()) {
                case FIXED, SAN ->
                        quote.setAmount(calculateAmount(loan.getLoanType(), loan.getQuotes(), loan.getInterest(), loan.getCapital()));
            }
            quotes.add(quote);
        }
        return quotes;
    }

    private BigDecimal calculateAmount(LoanType loanType, int quotes, BigDecimal interest, BigDecimal capitalAmount) {
        return switch (loanType) {
            case FIXED ->
                    capitalAmount.divide(new BigDecimal(quotes), RoundingMode.CEILING).add(interest).setScale(2, RoundingMode.CEILING);
            case SAN ->
                    capitalAmount.add(interest).divide(new BigDecimal(quotes), RoundingMode.CEILING).setScale(2, RoundingMode.CEILING);
        };
    }

    private LocalDate calculateDate(FrequencyType frequencyType, LocalDate localDate) {
        return switch (frequencyType) {
            case MONTHLY -> localDate.plusMonths(1);
            case WEEKLY -> localDate.plusWeeks(1);
            case DAILY -> localDate.plusDays(1);
        };
    }
}
