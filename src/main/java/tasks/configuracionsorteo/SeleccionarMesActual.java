package tasks.configuracionsorteo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.ConfiguracionSorteo;
import utils.GeneradorDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarMesActual implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        int mesActual = GeneradorDatos.obtenerMesActual();
        actor.attemptsTo(
                Click.on("//input[@id='mes1']/ancestor::p-checkbox//div[contains(@class,'p-checkbox-box') and contains(@class,'p-highlight')]"),
                Click.on(ConfiguracionSorteo.MES_SIGUIENTE(mesActual))
        );
    }

    public static SeleccionarMesActual on() {
        return instrumented(SeleccionarMesActual.class);
    }

}
