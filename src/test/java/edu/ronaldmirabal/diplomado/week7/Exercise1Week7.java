package edu.ronaldmirabal.diplomado.week7;

import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Verificar que sucede con los logs cuando no se validan las cosas antes de pasarlas
 * <p>
 * Un problema de encode en diversas formas
 *
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week7 {
    private static final Logger log = LoggerFactory.getLogger(Exercise1Week7.class);

    public void worseLog(String parameter) {
        // Forma común que usan los devs cuando no conocen la API de logs.
        System.out.println("My parameter " + parameter);
    }

    public void badLog(String parameter) {
        // Forma común que usan los devs cuando no entienden que las variables se controlan
        log.info("My parameter {}", parameter);
    }

    public void goodLog(String parameter) {
        log.info("My parameter {}", Encode.forJava(parameter));
    }
}
