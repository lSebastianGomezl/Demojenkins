package stepdefinition.aprobarprogramacionsorteos;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import models.DatosUsuario;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;

import questions.aprobarprogramacionsorteos.AprobarProgramacionSorteoQuestions;

import questions.login.PaginaDashboard;
import stepdefinition.login.LoginStepDefinition;
import tasks.Abrir;
import tasks.aprobarprogramacionsorteos.ClicApartadoAccionesTask;
import tasks.aprobarprogramacionsorteos.ClicApartadoDetallesTask;
import tasks.aprobarprogramacionsorteos.IngresarMotivoTask;


import tasks.crearsorteo.ClicBtoCrearSorteoTask;
import tasks.crearsorteo.ClicConfiguracionSorteoslTask;
import tasks.crearsorteo.ClicGestorSorteoVirtualTask;
import tasks.crearsorteo.formulario.*;
import tasks.login.*;

import ui.AprobacionProgramacionSorteo;
import utils.GeneradorDatos;

import java.util.HashMap;

import java.util.Map;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class AprobarProgramacionSorteosStepDefinition {
    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class.getName());
    private Map<String, String> datosDinamicos = new HashMap<>();
    private boolean validarFechaInvalida = false;
    private String textoCapturado;

    @Before
    public void prepararDatosDinamicos() {
        String nombreSorteo = GeneradorDatos.nombreDeSorteoUnico();
        String codigoUnico = GeneradorDatos.codigoUnico();
        String fechaActual = GeneradorDatos.fechaActual();
        String fechaInvalida = GeneradorDatos.fechaAnterior();


        Serenity.setSessionVariable("nombreSorteo").to(nombreSorteo);
        Serenity.setSessionVariable("codigoUnico").to(codigoUnico);
        Serenity.setSessionVariable("fechaActual").to(fechaActual);
        Serenity.setSessionVariable("fechaInvalida").to(fechaInvalida);
    }

    private String valor(String input) {
        switch (input) {
            case "dinamico":
                return Serenity.sessionVariableCalled("nombreSorteo");
            case "autoincremental":
                return Serenity.sessionVariableCalled("codigoUnico");
            case "fechaActual":
                return Serenity.sessionVariableCalled("fechaActual");
            case "fechaInvalida":
                return Serenity.sessionVariableCalled("fechaInvalida");
            default:
                return input;
        }
    }


    @Dado("que el actor abre la aplicación")
    public void queElActorAbreLaAplicación() {
        LOGGER.info("==> Abriendo la aplicación web");
            theActorInTheSpotlight().attemptsTo(
                Abrir.laAplicacion()
       );
       LOGGER.info("Actor activo: " + theActorInTheSpotlight().getName());
    }
    @Dado("diligencia el formulario de login con los siguientes datos:")
    public void diligenciaElFormularioDeLoginConLosSiguientesDatos(DataTable dataTable) {
        Map<String, String> entry = dataTable.asMaps().get(0);

        DatosUsuario usuario = new DatosUsuario(
                entry.get("tipoDocumento"),
                entry.get("usuario"),
                entry.get("contrasenna")
        );

        LOGGER.info("==> Ingresando credenciales:");
        LOGGER.info("    Tipo de documento: " + usuario.getTipoDocumento());
        LOGGER.info("    Usuario: " + usuario.getUsuario());
        LOGGER.info("    Contraseña: ********");

        theActorInTheSpotlight().attemptsTo(
                IngresarDatosLoginTask.credenciales(usuario)
        );
    }

    @Dado("hace clic en el botón validar biometrico")
    public void haceClicEnElBotónValidarBiometrico() {
        LOGGER.info("==> Clic en el botón Validar Biométrico");
        theActorInTheSpotlight().attemptsTo(
                ClicValidarBiometrico.on()
        );
    }
    @Dado("hace clic en el botón Iniciar sesión")
    public void haceClicEnElBotónIniciarSesión() {
        LOGGER.info("==> Clic en el botón Iniciar Sesión");
        theActorInTheSpotlight().attemptsTo(
                ClicBtnIniciarSesion.on()
        );
    }
    @Dado("acepta la primera alerta")
    public void aceptaLaPrimeraAlerta() {
        LOGGER.info("==> Acepta la primera alerta (Huella)");
        theActorInTheSpotlight().attemptsTo(
                ClicBtnAceptarHuella.on()
        );
    }
    @Dado("acepta la segunda alerta")
    public void aceptaLaSegundaAlerta() {
        LOGGER.info("==> Acepta la segunda alerta (Confirmación de huella)");
        theActorInTheSpotlight().attemptsTo(
                ClicBtnConfirmarHuella.on()
        );
    }
    @Cuando("el usuario ingresa al menú lateral {string}")
    public void elUsuarioIngresaAlMenúLateral(String tituloMenu) {
        LOGGER.info("==> Ingresa al menu de GSV");
        //System.out.println(tituloMenu);
        theActorInTheSpotlight().attemptsTo(
                ClicGestorSorteoVirtualTask.on(tituloMenu)
        );
    }
    @Cuando("selecciona el submenú {string}")
    public void seleccionaElSubmenú(String tituloSubmenu) {
        LOGGER.info("==> Ingresa al sub menu configuracion de sorteo");
        theActorInTheSpotlight().attemptsTo(
                ClicConfiguracionSorteoslTask.on(tituloSubmenu)
        );

    }
    @Entonces("debería abrirse una nueva ventana con el buscador de sorteos {string}")
    public void deberíaAbrirseUnaNuevaVentanaConElBuscadorDeSorteos(String tituloEsperado) {
        LOGGER.info("==> Validando que se muestra la página: " + tituloEsperado);
        theActorInTheSpotlight().should(
                seeThat(PaginaDashboard.esVisible(tituloEsperado))
        );

    }

    @Cuando("selecciona la empresa propietaria {string}")
    public void seleccionaLaEmpresaPropietaria(String tituloEmpresa) {
        LOGGER.info("==> Selecciona el nombre de la empresa propietaria");
        theActorInTheSpotlight().attemptsTo(
                SeleccionarEmpresaTask.empresaPropietaria(tituloEmpresa)
        );
    }
    @Cuando("el usuario da clic en el botón {string}")
    public void elUsuarioDaClicEnElBotón(String textoBoton) {
    LOGGER.info("==> Da clic en el boton de crear sorteo");
    System.out.println("Texto del boton" + textoBoton);
    theActorInTheSpotlight().attemptsTo(
            ClicBtoCrearSorteoTask.conTexto(textoBoton)
        );
    }
    @Cuando("da clic en el apartado de acciones")
    public void daClicEnElApartadoDeAcciones() {
        LOGGER.info("==> Da clic en el apartado ver acciones");
        theActorInTheSpotlight().attemptsTo(
                ClicApartadoAccionesTask.on()
        );

    }
    @Cuando("ingresa a la vigencia de la programacion dando clic en la flecha de Detalle")
    public void ingresaALaVigenciaDeLaProgramacionDandoClicEnLaFlechaDeDetalle() {
        LOGGER.info("==> Da clic en el apartado ver detalle");
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(AprobacionProgramacionSorteo.ENCABEZADO_VIGENCIA),
                ClicApartadoDetallesTask.on()
        );
    }
    @Cuando("el usuario hace clic en {string} en el modal")
    public void elUsuarioHaceClicEnEnElModal(String noAprobar) {
        LOGGER.info("==> Da clic en el boton de aceptar");
        theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(noAprobar)
        );
    }
    @Cuando("el usuario ingresa el motivo de no aprobacion {string}")
    public void elUsuarioIngresaElMotivoDeNoAprobacion(String texto) {
        LOGGER.info("==> Ingresa el motivo de la no aprobacion");
        theActorInTheSpotlight().attemptsTo(
                IngresarMotivoTask.on(texto)
        );
    }
    @Entonces("debería aparecer un modal de confirmación {string}")
    public void deberíaAparecerUnModalDeConfirmación(String tituloAlert) {
        LOGGER.info("==> Valida la alert de la no aprobacion de sorteos exitoso");

        // Validación con la Question
        OnStage.theActorInTheSpotlight().should(
                seeThat(AprobarProgramacionSorteoQuestions.aprobacionSuccessful(tituloAlert))
        );
    }


}
