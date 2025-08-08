package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarHoraFinalSorteoTask implements Task {

    private final String texto;

    public IngresarHoraFinalSorteoTask(String texto) {
        this.texto = texto;
    }

    public static IngresarHoraFinalSorteoTask on(String texto){
        return instrumented(IngresarHoraFinalSorteoTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.HORA_RANGO_FINAL, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.HORA_RANGO_FINAL),
                Enter.theValue(texto).into(ConfiguracionSorteo.HORA_RANGO_FINAL),
                SendKeys.of(Keys.ENTER).into(ConfiguracionSorteo.HORA_RANGO_FINAL)
        );
    }
}
