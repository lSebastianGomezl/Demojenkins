package tasks.configuracionplanderesultados;

import models.PlanDeResultadosData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import ui.PlanDeResultado;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarFormularioPlanResultados implements Task {

    private final PlanDeResultadosData data;

    public LlenarFormularioPlanResultados(PlanDeResultadosData data) {
        this.data = data;
    }

    public static LlenarFormularioPlanResultados conDatos(PlanDeResultadosData data) {
        return instrumented(LlenarFormularioPlanResultados.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(data.getNombre()).into(PlanDeResultado.NOMBRE),
                Enter.theValue(data.getDescripcion()).into(PlanDeResultado.DESCRIPCION),
                Enter.theValue(data.getCantidadResultados()).into(PlanDeResultado.CANTIDAD_RESULTADOS),
                Enter.theValue(data.getTiempoRetardo()).into(PlanDeResultado.TIEMPO_RETARDO), // <-- nuevo campo
                // Dropdown
                Click.on(PlanDeResultado.TIPO_PLAN_DROPDOWN),
                Click.on(PlanDeResultado.OPCION_TIPO_PLAN.of(data.getTipoPlan())),

                // Switch
                Check.whether(data.isActivarVisualizador())
                        .andIfSo(Click.on(PlanDeResultado.ACTIVAR_VISUALIZADOR))
        );
    }
}
