package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ConfiguracionSorteo;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarEditarSorteoTask implements Task {

    private String codigo;

    public SeleccionarEditarSorteoTask(String codigo) {
        this.codigo = codigo;
    }

    public static Task editarSorteo(String codigo) {
        return instrumented(SeleccionarEditarSorteoTask.class, codigo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfiguracionSorteo.botonEditarSorteo(codigo), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ConfiguracionSorteo.botonEditarSorteo(codigo))
        );

    }
}
