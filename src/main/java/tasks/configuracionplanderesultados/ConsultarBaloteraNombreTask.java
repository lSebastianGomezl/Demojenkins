package tasks.configuracionplanderesultados;

import models.BaloteraData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.PlanDeResultado;
import utils.GeneradorDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarBaloteraNombreTask implements Task {
    private String texto;

    public static ConsultarBaloteraNombreTask consultarBalotera(String texto) {
        return instrumented(ConsultarBaloteraNombreTask.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {


        String nombreBalotera = Serenity.sessionVariableCalled("nombreBalotera");

        actor.attemptsTo(
                Enter.theValue(nombreBalotera).into(PlanDeResultado.NOMBRE_BALOTERA)

        );
    }

}
