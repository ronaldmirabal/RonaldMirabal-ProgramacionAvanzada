package edu.ronaldmirabal.diplomado.week5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {
    private final Homework homework = new Homework();
    @Test
    void noRemplaceTest(){
        String template = "${hola}";
        Homework.VarsReplace varsReplace = Homework.VarsReplace.builder().varReplace("").value("").build();
        String result = homework.prepareTemplate(List.of(varsReplace), template);
        assertEquals(template, result);
        System.out.println(result);
    }

    @Test
    void remplace1VarTest(){
        Homework.VarsReplace varsReplace = Homework.VarsReplace.builder().varReplace("hola").value("mundo").build();
        String result = homework.prepareTemplate(List.of(varsReplace), "${hola}");
        assertEquals("hola", result);
        System.out.println(result);
    }

}