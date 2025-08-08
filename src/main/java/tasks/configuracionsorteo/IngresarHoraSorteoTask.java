package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import ui.ConfiguracionSorteo;
import utils.GeneradorDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarHoraSorteoTask implements Task {

    private final String texto;

    public IngresarHoraSorteoTask(String texto) {
        this.texto = texto;
    }

    public static IngresarHoraSorteoTask on(String texto){
        return instrumented(IngresarHoraSorteoTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.HORA_SORTEO, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.HORA_SORTEO),
                Enter.theValue(texto).into(ConfiguracionSorteo.HORA_SORTEO),
                SendKeys.of(Keys.ENTER).into(ConfiguracionSorteo.HORA_SORTEO)
        );
    }
}
