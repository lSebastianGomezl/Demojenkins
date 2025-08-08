package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import ui.ConfiguracionSorteo;
import utils.GeneradorDatos;

import java.time.LocalDate;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarFechaSorteoTask implements Task {



    public static IngresarFechaSorteoTask on(){
        return instrumented(IngresarFechaSorteoTask.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Día actual: " + GeneradorDatos.obtenerDiaActual());

        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.FECHA_SORTEO, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.FECHA_SORTEO));

        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.DIA_ACTUAL, isVisible()).forNoMoreThan(60).seconds(),
                Click.on(ConfiguracionSorteo.DIA_ACTUAL));

    }
}
