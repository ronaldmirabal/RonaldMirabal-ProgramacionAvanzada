package edu.ronaldmirabal.diplomado.week5;

import lombok.*;

import java.util.List;
/**
 * ¿Como probar estos métodos?
 *
 * Hacer los test principalmente de los métodos privados
 *
 * @author aluis on 4/3/2022.
 */
public class Homework {
    public String prepareTemplate(List<VarsReplace> varsReplaces, String template) {
        for (VarsReplace varsReplace : varsReplaces) {
            template = replaceVar(template, String.valueOf(varsReplace));
        }
        return template;
    }

    // TODO test this method
    private String replaceVar(String template, String value) {
        String var = "\\$\\{" + value + "\\}";
        return template.replaceAll(var, value);
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class VarsReplace{
        private String varReplace;
        private  String value;
    }
}
