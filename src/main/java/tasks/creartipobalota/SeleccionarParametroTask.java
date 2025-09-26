package tasks.creartipobalota;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.checkerframework.checker.units.qual.C;
import ui.CreacionBalotaTotal;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarParametroTask implements Task {



    public static SeleccionarParametroTask on(){
        return instrumented(SeleccionarParametroTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(CreacionBalotaTotal.SELECCIONAR, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CreacionBalotaTotal.SELECCIONAR),
                Click.on(CreacionBalotaTotal.COLOR),
                Click.on(CreacionBalotaTotal.botonConTexto("Consultar"))
        );

        actor.attemptsTo(
                WaitUntil.the(CreacionBalotaTotal.CHECKBOX_PARAMETRO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CreacionBalotaTotal.CHECKBOX_PARAMETRO)
        );



    }

}
