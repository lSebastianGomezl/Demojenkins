package stepdefinition.creartipobalota;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import models.DatosUsuario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.crartipobalota.PaginaCrearTipoBalota;
import questions.crearsorteo.PaginaCrearSorteo;
import stepdefinition.login.LoginStepDefinition;
import tasks.Abrir;
import tasks.crearsorteo.ClicBtoCrearSorteoTask;
import tasks.crearsorteo.ClicConfiguracionSorteoslTask;
import tasks.crearsorteo.ClicGestorSorteoVirtualTask;
import tasks.crearsorteo.formulario.SeleccionarEmpresaTask;
import tasks.creartipobalota.*;
import tasks.login.*;
import ui.CreacionBalotaTotal;
import utils.GeneradorDatos;
import static org.hamcrest.Matchers.is;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearTipoBalotaStepDefinition {
    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class.getName());
    private Map<String, String> datosDinamicos = new HashMap<>();
    private boolean validarFechaInvalida = false;

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
        OnStage.theActorInTheSpotlight().attemptsTo(
                Abrir.laAplicacion()
        );
        LOGGER.info("Actor activo: " + OnStage.theActorInTheSpotlight().getName());
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

        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarDatosLoginTask.credenciales(usuario)
        );
    }

    @Dado("hace clic en el botón validar biometrico")
    public void haceClicEnElBotónValidarBiometrico() {
        LOGGER.info("==> Clic en el botón Validar Biométrico");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicValidarBiometrico.on()
        );
    }

    @Dado("hace clic en el botón Iniciar sesión")
    public void haceClicEnElBotónIniciarSesión() {
        LOGGER.info("==> Clic en el botón Iniciar Sesión");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtnIniciarSesion.on()
        );
    }

    @Dado("acepta la primera alerta")
    public void aceptaLaPrimeraAlerta() {
        LOGGER.info("==> Acepta la primera alerta (Huella)");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtnAceptarHuella.on()
        );
    }

    @Dado("acepta la segunda alerta")
    public void aceptaLaSegundaAlerta() {
        LOGGER.info("==> Acepta la segunda alerta (Confirmación de huella)");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtnConfirmarHuella.on()
        );
    }

    @Cuando("el usuario ingresa al menú lateral {string}")
    public void elUsuarioIngresaAlMenúLateral(String tituloMenu) {
        LOGGER.info("==> Ingresa al menu de GSV");
        //System.out.println(tituloMenu);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicGestorSorteoVirtualTask.on(tituloMenu)
        );
    }

    @Cuando("selecciona el submenú {string}")
    public void seleccionaElSubmenú(String tituloSubmenu) {
        LOGGER.info("==> Ingresa al sub menu tipo de balota");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicConfiguracionSorteoslTask.on(tituloSubmenu)
        );
    }


    @Cuando("el usuario hace clic en el botón {string}")
    public void elUsuarioHaceClicEnElBotón(String textoBoton) {
        LOGGER.info("==> Da clic en el boton de Nuevo tipo de balota");
        System.out.println("Texto del boton" + textoBoton);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(textoBoton)
        );
    }
    @Cuando("selecciona la empresa propietaria {string}")
    public void seleccionaLaEmpresaPropietaria(String tituloEmpresa) {
        LOGGER.info("==> Selecciona el nombre de la empresa propietaria");
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarEmpresaTask.empresaPropietaria(tituloEmpresa)
        );
    }
    @Cuando("ingresa el nombre del tipo de balota {string}")
    public void ingresaElNombreDelTipoDeBalota(String nombreTipoBalota) {
        LOGGER.info("==> Ingresa el nombre del tipo de balota");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarNombreTipoBalotaTask.on(valor(nombreTipoBalota))
        );
    }
    @Cuando("selecciona el tipo de balota {string}")
    public void seleccionaElTipoDeBalota(String tipoBalota) {
        LOGGER.info("==> Seleccionar tipo de balota");
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarTipoBalotaTask.on(tipoBalota)
        );
    }
    @Cuando("selecciona opcion de homologacion {string}")
    public void seleccionaOpcionDeHomologacion(String opcionHomologa) {
        LOGGER.info("==> Seleccionar tipo de balota");
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarHomologaTask.on(opcionHomologa)
        );
    }
    @Cuando("el usuario da clic en el botón {string}")
    public void elUsuarioDaClicEnElBotón(String btnGuardar) {
        LOGGER.info("==> Da clic en el boton de guardar");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoTask.conTexto(btnGuardar)
        );
    }
    @Cuando("el usuario hace clic en {string} en el modal")
    public void elUsuarioHaceClicEnEnElModal(String btnAceptar) {
        LOGGER.info("==> Da clic en el boton de aceptar");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoTask.conTexto(btnAceptar)
        );
    }

    @Cuando("el usuario da clic en la opcion agregar parametro")
    public void elUsuarioDaClicEnLaOpcionAgregarParametro() {
        LOGGER.info("==> Da clic en el boton agregar parametro");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoAgregarParametroTask.on()
        );
    }

    @Cuando("selecciona el parametro")
    public void seleccionaElParametro() {
        LOGGER.info("==> Selecciona el parametro");
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarParametroTask.on()
        );
    }
    @Cuando("el usuario ingresa el color {string}")
    public void elUsuarioIngresaElColor(String color) {
        LOGGER.info("==> Ingresa el valor del color en rgb");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarColorTask.on(color)
        );
    }
//    @Entonces("debería aparecer un modal de confirmación {string}")
//    public void deberíaAparecerUnModalDeConfirmación(String tituloAlert) {
//        LOGGER.info("==> Valida la alert de la creacion del sorteo exitosa");
//        OnStage.theActorInTheSpotlight().should(
//                seeThat(PaginaCrearTipoBalota.tipoBalotaSuccessful(tituloAlert))
//        );
//    }
    @Cuando("el usuario da clic en el botón guardar")
    public void elUsuarioDaClicEnElBotónGuardar() {
        LOGGER.info("==> Da clic en el boton guardar");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoGuardarTask.on()
        );
    }

    @Entonces("debería aparecer un modal de confirmación {string}")
    public void deberíaAparecerUnModalDeConfirmación(String tituloAlert) {
        LOGGER.info("==> Valida la alert de la creacion del parametro exitosa");

        OnStage.theActorInTheSpotlight().should(
                seeThat(PaginaCrearTipoBalota.tipoBalotaParametroSuccessful(tituloAlert), is(true))
        );
    }





}
