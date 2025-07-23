package stepdefinition.crearsorteos;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import models.DatosUsuario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.crearsorteo.PaginaCrearSorteo;
import questions.login.PaginaDashboard;
import stepdefinition.login.LoginStepDefinition;
import tasks.Abrir;
import tasks.crearsorteo.ClicBtoCrearSorteoTask;
import tasks.crearsorteo.ClicConfiguracionSorteoslTask;
import tasks.crearsorteo.ClicGestorSorteoVirtualTask;
import tasks.crearsorteo.formulario.*;
import tasks.login.*;
import utils.GeneradorDatos;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CrearSorteoStepDefinition {
    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class.getName());
    private Map<String, String> datosDinamicos = new HashMap<>();

    @Before
    public void prepararDatosDinamicos() {
        String nombreSorteo = GeneradorDatos.nombreDeSorteoUnico();
        String codigoUnico = GeneradorDatos.codigoUnico();
        String fechaActual = GeneradorDatos.fechaActual();

        Serenity.setSessionVariable("nombreSorteo").to(nombreSorteo);
        Serenity.setSessionVariable("codigoUnico").to(codigoUnico);
        Serenity.setSessionVariable("fechaActual").to(fechaActual);
    }

    private String valor(String input) {
        switch (input) {
            case "dinamico":
                return Serenity.sessionVariableCalled("nombreSorteo");
            case "autoincremental":
                return Serenity.sessionVariableCalled("codigoUnico");
            case "fechaActual":
                return Serenity.sessionVariableCalled("fechaActual");
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
    @Entonces("debería abrirse una nueva ventana con el buscador de sorteos {string}")
    public void deberíaAbrirseUnaNuevaVentanaConElBuscadorDeSorteos(String tituloEsperado) {
        LOGGER.info("==> Validando que se muestra la página: " + tituloEsperado);
        OnStage.theActorInTheSpotlight().should(
                seeThat(PaginaDashboard.esVisible(tituloEsperado))
        );
    }
    @Cuando("el usuario hace clic en el botón {string}")
    public void elUsuarioHaceClicEnElBotón(String textoBoton) {
        LOGGER.info("==> Da clic en el boton de crear sorteo");
        System.out.println("Texto del boton" + textoBoton);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(textoBoton)
        );
    }
    @Entonces("debería abrirse una nueva ventana con el formulario de creacion de sorteos y ver el texto {string}")
    public void deberíaAbrirseUnaNuevaVentanaConElFormularioDeCreacionDeSorteosYVerElTexto(String tituloFormulario) {
        LOGGER.info("==> Valida el titulo del fomulario informacion de sorteo");
        System.out.println("este es el valor del titulo:" + tituloFormulario);
        OnStage.theActorInTheSpotlight().should(
                seeThat(PaginaCrearSorteo.tituloFormulario(tituloFormulario))
        );
    }
    @Cuando("selecciona la empresa propietaria {string}")
    public void seleccionaLaEmpresaPropietaria(String tituloEmpresa) {
        LOGGER.info("==> Selecciona el nombre de la empresa propietaria");
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarEmpresaTask.empresaPropietaria(tituloEmpresa)
        );
    }
    @Cuando("ingresa el nombre del sorteo {string}")
    public void ingresaElNombreDelSorteo(String nombreSorteo) {
        LOGGER.info("==> Ingresa el nombre del sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarNombreSorteoTask.on(valor(nombreSorteo))
        );
    }
    @Cuando("ingresa el código único del sorteo {string}")
    public void ingresaElCódigoÚnicoDelSorteo(String codigoUnico) {
        LOGGER.info("==> Ingresa el codigo del sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarCodigoSorteoTask.on(valor(codigoUnico))
        );
    }
    @Cuando("selecciona el tipo de sorteo {string}")
    public void seleccionaElTipoDeSorteo(String tipoSorteo) {
        LOGGER.info("==> Ingresa el tipo de sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarTipoSorteoTask.tipoSorteo(tipoSorteo)
        );
    }
    @Cuando("escribe la descripción {string}")
    public void escribeLaDescripción(String descripcion) {
        LOGGER.info("==> Ingresa la descripcion del sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarDescripcionSorteoTask.on(descripcion)
        );
    }
    @Cuando("selecciona la fecha de inicio {string}")
    public void seleccionaLaFechaDeInicio(String fechaInicio) {
        LOGGER.info("==> Ingresa la fecha de inicio");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarFechaIncioTask.on(valor(fechaInicio))
        );
    }
    @Cuando("selecciona la fecha de fin {string}")
    public void seleccionaLaFechaDeFin(String fechaFin) {
        LOGGER.info("==> Ingresa la fecha fin");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarFechaFinalTask.on(valor(fechaFin))
        );
    }
    @Cuando("configura el parámetro de formato de sorteo {string}")
    public void configuraElParámetroDeFormatoDeSorteo(String formatoSorteo) {
        LOGGER.info("==> Selecciona el formato de sorteo");
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarFormatoSorteoTask.nombreFormatoSorteo(formatoSorteo)
        );
    }

    @Cuando("el usuario da clic en el botón {string}")
    public void elUsuarioDaClicEnElBotón(String btnGuardar) {
        LOGGER.info("==> Da clic en el boton de guardar");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(btnGuardar)
        );
    }

    @Y("el usuario hace clic en {string} en el modal")
    public void elUsuarioHaceClicEnEnElModal(String btnAceptar) {
        LOGGER.info("==> Da clic en el boton de aceptar");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(btnAceptar)
        );
    }

    @Entonces("debería aparecer un modal de confirmación {string}")
    public void deberíaAparecerUnModalDeConfirmación(String tituloAlert) {
        LOGGER.info("==> Valida la alert de la creacion del sorteo exitosa");
        OnStage.theActorInTheSpotlight().should(
                seeThat(PaginaCrearSorteo.sorteoSuccessful(tituloAlert))
        );
    }

}
