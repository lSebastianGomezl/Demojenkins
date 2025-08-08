package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;
import utils.GeneradorDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarFechaFinalSorteoTask implements Task {



    public static IngresarFechaFinalSorteoTask on(){
        return instrumented(IngresarFechaFinalSorteoTask.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Día actual: " + GeneradorDatos.obtenerDiaActual());

        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.FECHA_RANGO_FINAL, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.FECHA_RANGO_FINAL));

        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.DIA_ACTUAL, isVisible()).forNoMoreThan(60).seconds(),
                Click.on(ConfiguracionSorteo.DIA_ACTUAL));

    }
}
