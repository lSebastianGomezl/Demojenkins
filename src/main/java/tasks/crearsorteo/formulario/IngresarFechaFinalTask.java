package tasks.crearsorteo.formulario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarFechaFinalTask implements Task {

    private final String texto;

    public IngresarFechaFinalTask(String texto) {
        this.texto = texto;
    }

    public static IngresarFechaFinalTask on(String texto){
        return instrumented(IngresarFechaFinalTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.FECHA_FIN, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(texto).into(ConfiguracionSorteo.FECHA_FIN),
                SendKeys.of(Keys.ENTER).into(ConfiguracionSorteo.FECHA_FIN)

        );
    }
}
