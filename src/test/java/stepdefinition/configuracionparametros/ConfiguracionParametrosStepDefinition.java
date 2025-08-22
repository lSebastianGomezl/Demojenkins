package stepdefinition.configuracionparametros;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import models.DatosUsuario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.configuracionparametros.ConfiguracionParametroQuestion;
import questions.crearsorteo.PaginaCrearSorteo;
import questions.login.PaginaDashboard;
import stepdefinition.login.LoginStepDefinition;
import tasks.Abrir;
import tasks.configuracionparametros.*;
import tasks.crearsorteo.ClicBtoCrearSorteoTask;
import tasks.crearsorteo.ClicConfiguracionSorteoslTask;
import tasks.crearsorteo.ClicGestorSorteoVirtualTask;
import tasks.crearsorteo.formulario.*;
import tasks.login.*;
import ui.ConfiguracionSorteo;
import utils.GeneradorDatos;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfiguracionParametrosStepDefinition {
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
        LOGGER.info("==> Ingresa al sub menu configuracion de sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicConfiguracionSorteoslTask.on(tituloSubmenu)
        );
    }

    @Cuando("el usuario da clic en el botón {string}")
    public void elUsuarioDaClicEnElBotón(String textoBoton) {
        LOGGER.info("==> Da clic en el boton de Nuevo Parametro");
        System.out.println("Texto del boton" + textoBoton);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(textoBoton)
        );
    }
    @Cuando("llena el campo {string} con {string}")
    public void llenaElCampoCon(String campo, String valor) {
        LOGGER.info("==> Llena el formulario de configuracion de parametro");
        OnStage.theActorInTheSpotlight().attemptsTo(
                LlenarCampoFormulario.conValor(campo, valor)
        );
    }
    @Cuando("llena el campo Clave del parámetro con {string}")
    public void llenaElCampoClaveDelParámetroCon(String clave) {
        LOGGER.info("==> Ingresa el valor de la clave");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarClaveTask.on(valor(clave)));
    }
    @Cuando("llena el campo Nombre del parámetro con {string}")
    public void llenaElCampoNombreDelParámetroCon(String parametro) {
        LOGGER.info("==> Ingresa el nombre del parametro");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarParametroTask.on(valor(parametro)));
    }
    @Cuando("llena el campo Descripcion con {string}")
    public void llenaElCampoDescripcionCon(String descripcion) {
        LOGGER.info("==> Ingresa la descripcion para el parametro");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarDescripcionTask.on(valor(descripcion)));
    }

    @Cuando("el usuario hace clic en {string} en el modal")
    public void elUsuarioHaceClicEnEnElModal(String btnAceptar) {
        LOGGER.info("==> Da clic en el boton de aceptar");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(btnAceptar)
        );

    }

//    @Cuando("el usuario selecciona la empresa {string}")
//    public void elUsuarioSeleccionaLaEmpresa(String nombreEmpresa) {
//        LOGGER.info("==> Da clic en seleccionar empresa y la selecciona");
//        OnStage.theActorInTheSpotlight().attemptsTo(
//                ClicEmpresaPropietariaTask.on(nombreEmpresa)
//        );
//    }
    @Cuando("el usuario da clic en el icono de editar")
    public void elUsuarioDaClicEnElIconoDeEditar() {
        LOGGER.info("==> Da clic en el incono de editar");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicIconoEditarTask.on()
        );
    }

    @Entonces("debería aparecer un modal de confirmación {string}")
    public void deberíaAparecerUnModalDeConfirmación(String tituloAlert) throws InterruptedException {
        LOGGER.info("==> Valida la alert de configuracion de sorteo exitoso");

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(
                        ConfiguracionSorteo.validacionCracionSorteo(tituloAlert),
                        isVisible()
                ).forNoMoreThan(5).seconds());
    }

}
