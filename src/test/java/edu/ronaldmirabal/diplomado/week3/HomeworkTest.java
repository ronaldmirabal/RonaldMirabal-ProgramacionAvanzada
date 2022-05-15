package edu.ronaldmirabal.diplomado.week3;

import edu.ronaldmirabal.diplomado.model.week3.FrequencyType;
import edu.ronaldmirabal.diplomado.model.week3.Loan;
import edu.ronaldmirabal.diplomado.model.week3.LoanType;
import edu.ronaldmirabal.diplomado.model.week3.Quote;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HomeworkTest {
    private final Homework homework = new Homework();

    @Nested
    class SimpleFixedCaseTest{
        @Test
        void nullStartDateTest(){
            List<Quote> expectedQuotes = new ArrayList<>();
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 2),new BigDecimal(600)));
            expectedQuotes.add(createQuote(LocalDate.of(2021, Month.JANUARY, 3),new BigDecimal(600)));
            Loan loan = Loan.builder()
                    .loanType(LoanType.FIXED)
                    .frequencyType(FrequencyType.DAILY)
                    .capital(new BigDecimal(1000))
                    .quotes(2)
                    .interest(new BigDecimal(100))
                    .startDate(LocalDate.of(2021, Month.JANUARY, 1))
                    .build();
            List<Quote> quotes = homework.calculateQuotes(loan);
            assertNotNull(quotes);
            assertEquals(2, quotes.size());
            for (int i = 0; i < quotes.size(); i++){

            }
        }
    }



    /**
     * Con esta función siempre compararás las cuotas.
     * <p>
     * Puedes usar un ciclo for comparando la cada cuota con esta función para que valides que son iguales
     *
     * @param quoteExpected La esperada y con los valores que debería arroja la actual
     * @param quoteActual   La generada por la función
     */
    private void compareQuotes(Quote quoteExpected, Quote quoteActual) {
        assertEquals(quoteExpected.getDate(), quoteActual.getDate());
        assertEquals(quoteExpected.getAmount(), quoteActual.getAmount());
    }

    /**
     * Método de ayuda para generar las quotas.
     *
     * @param date   Fecha
     * @param amount Monto
     * @return cuota esperada
     */
    private Quote createQuote(LocalDate date, BigDecimal amount) {
        return Quote.builder().date(date).amount(amount).build();
    }

}