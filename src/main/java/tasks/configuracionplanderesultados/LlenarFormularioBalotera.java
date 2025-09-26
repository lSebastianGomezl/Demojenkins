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
import static utils.GeneradorDatos.generarNombreBalotera;

public class LlenarFormularioBalotera implements Task {


    private final BaloteraData data;

    public LlenarFormularioBalotera(BaloteraData data) {
        this.data = data;
    }

    public static LlenarFormularioBalotera conDatos(BaloteraData data) {
        return instrumented(LlenarFormularioBalotera.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String nombreBalotera = generarNombreBalotera();
        Serenity.setSessionVariable("nombreBalotera").to(nombreBalotera);

        actor.attemptsTo(
                Enter.theValue(nombreBalotera).into(PlanDeResultado.NOMBRE_BALOTERA),
                Enter.theValue(data.getRangoInicio()).into(PlanDeResultado.RANGO_INICIO),
                Enter.theValue(data.getRangoFin()).into(PlanDeResultado.RANGO_FIN),

                // siempre primero abrir el dropdown
                Click.on(PlanDeResultado.TIPO_DROPDOWN),

                // seleccionar opción: si viene nula -> primera de la lista
                (data.getTipo() == null || data.getTipo().isEmpty())
                        ? Click.on(PlanDeResultado.PRIMER_OPCION_TIPO)
                        : Click.on(PlanDeResultado.OPCION_TIPO.of(data.getTipo()))
        );
        System.out.println("Nombre de balotera" + generarNombreBalotera() );
    }

}
