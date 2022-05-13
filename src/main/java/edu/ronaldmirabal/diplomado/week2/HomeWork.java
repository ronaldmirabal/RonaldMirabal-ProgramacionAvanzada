package edu.ronaldmirabal.diplomado.week2;

import edu.ronaldmirabal.diplomado.model.week2.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Crear una mejora de cualquiera de los algoritmos optimizados para pasarle los días laborales (no asumir, que llegue como parámetro)
 *
 * @author Ronald Mirabal on 3/27/2022.
 * @implNote Debe tener sus test
 */
public class HomeWork {
    /**
     * Hacer una implementación propia basado en los ejemplos explicados en clase.
     *
     * @param laborDays Los dias que son laborables, es decir, podemos trabajar de lunes a viernes, de lunes a sábado, o la semana entera, o solo 3 dias a la semana
     * @param holidays  Todos los dias feriados que serán relevantes para el cálculo, tomar en cuenta diciembre para esto, puede que necesites los feriados del año siguiente
     * @param startDate Fecha de inicio para calcular las vacaciones, esta fecha es incluyente, es decir, desde aquí se inicia la vacación
     * @param vacation  La cantidad de día a vacacionar
     * @return La fecha que debe retornar el trabajador
     * @implNote El último día de vacación también cuenta, es decir, que regresa el siguiente dia laboral
     */
    public LocalDate calculateDueDate(List<DayOfWeek> laborDays, List<Holiday> holidays, LocalDate startDate, int vacation) {
        LocalDate result = startDate;
        int countLaborDay = 0;
        while (true){
            if (countLaborDay <= vacation){
                if (isHoliday(holidays,result)){
                    result = result.plusDays(1);
                }else{
                    if (isLaborDay(laborDays, result)){
                        result = result.plusDays(1);
                        countLaborDay++;
                    }else{
                        result = result.plusDays(1);
                    }
                }
            }else{
                break;
            }
        }
        return result.minusDays(1);
    }



    private  boolean isLaborDay(List<DayOfWeek> labordays, LocalDate date){
        boolean result = false;
        int i = 0;
        while (i < labordays.size()){
            if (Objects.equals(labordays.get(i).toString(), date.getDayOfWeek().toString())){
                result = true;
                break;
            }
            i++;
        }
        return result;
    }

    private boolean isHoliday(List<Holiday> holidays, LocalDate date) {
        return holidays.stream().anyMatch(holiday -> holiday.getDate().isEqual(date));
    }

}
