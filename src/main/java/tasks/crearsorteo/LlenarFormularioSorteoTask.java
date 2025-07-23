package tasks.crearsorteo;

import models.DatosSorteo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import tasks.crearsorteo.formulario.SeleccionarEmpresaTask;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarFormularioSorteoTask implements Task {


    private final DatosSorteo datos;


    public LlenarFormularioSorteoTask(DatosSorteo datos) {
        this.datos = datos;
    }

    public static LlenarFormularioSorteoTask conDatos(DatosSorteo  datos){
        return instrumented(LlenarFormularioSorteoTask.class, datos);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarEmpresaTask.empresaPropietaria(datos.getEmpresa())
                //Ingresar.nombreDelSorteo(datos.getNombreSorteo()),
                //Ingresar.codigoUnico(datos.getCodigoUnico()),
                //Seleccionar.tipoDeSorteo(datos.getTipoSorteo()),
                //Ingresar.descripcion(datos.getDescripcion()),
                //Seleccionar.fechaInicio(datos.getFechaInicio()),
                //Seleccionar.fechaFin(datos.getFechaFin()),
                //Configurar.parametroDeFormato(datos.getParametro())
        );
    }
}
