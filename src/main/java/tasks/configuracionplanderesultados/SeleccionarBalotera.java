package tasks.configuracionplanderesultados;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import ui.PlanDeResultado;

public class SeleccionarBalotera implements Task {

    private final String nombreBalotera;

    public SeleccionarBalotera(String nombreBalotera) {
        this.nombreBalotera = nombreBalotera;
    }

    public static SeleccionarBalotera conNombre(String nombreBalotera) {
        return new SeleccionarBalotera(nombreBalotera);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(PlanDeResultado.CHECKBOX_BALOTERA(nombreBalotera).of(nombreBalotera)),
                Click.on(PlanDeResultado.CHECKBOX_BALOTERA(nombreBalotera).of(nombreBalotera))
        );
    }
}
