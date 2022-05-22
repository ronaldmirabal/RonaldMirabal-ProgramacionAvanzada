package edu.ronaldmirabal.diplomado.week4;

import edu.ronaldmirabal.diplomado.model.week4.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

class HomeworkTest {
    private final Homework homework = new Homework();

    @Test
    void operationNullTest(){
        Assertions.assertThrows(Homework.OperationNullExeption.class,()->{
            Operation operation = null;
            Double a = null;
            Double b = null;
            PrintWriter file = null;
            homework.calculateAndSave(operation,a,b,file);
        });
    }
    @Test
    void sumOperationTest(){
        StringWriter stringWriter = new StringWriter();
        homework.calculateAndSave(Operation.SUM,2.0,2.0,stringWriter);
    }



}