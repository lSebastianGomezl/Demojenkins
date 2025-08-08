package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.ConfiguracionSorteo;
import utils.GeneradorDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionaDiaEspecificoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ConfiguracionSorteo.RADIO_SELECCIONADO_DIA_ESPECIFICO)
        );
    }

    public static SeleccionaDiaEspecificoTask on() {
        return instrumented(SeleccionaDiaEspecificoTask.class);
    }

}
