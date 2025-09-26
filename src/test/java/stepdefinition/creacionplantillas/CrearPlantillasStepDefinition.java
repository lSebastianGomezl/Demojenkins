package stepdefinition.creacionplantillas;

import com.github.dockerjava.api.model.UpdateConfig;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import models.DatosUsuario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.crartipobalota.PaginaCrearTipoBalota;
import questions.crearsorteo.PaginaCrearSorteo;
import questions.login.PaginaDashboard;
import stepdefinition.login.LoginStepDefinition;
import tasks.Abrir;
import tasks.creacionplantillas.*;
import tasks.crearsorteo.ClicBtoCrearSorteoTask;
import tasks.crearsorteo.ClicConfiguracionSorteoslTask;
import tasks.crearsorteo.ClicGestorSorteoVirtualTask;
import tasks.crearsorteo.formulario.*;
import tasks.creartipobalota.ClicBtoAgregarParametroTask;
import tasks.creartipobalota.ClicBtoGuardarTask;
import tasks.creartipobalota.IngresarColorTask;
import tasks.creartipobalota.SeleccionarParametroTask;
import tasks.login.*;
import utils.GeneradorDatos;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CrearPlantillasStepDefinition {
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

    @Entonces("debería abrirse una nueva ventana con el buscador de plantillas {string}")
    public void deberíaAbrirseUnaNuevaVentanaConElBuscadorDePlantillas(String tituloEsperado) {
        LOGGER.info("==> Validando que se muestra la página: " + tituloEsperado);
        OnStage.theActorInTheSpotlight().should(
                seeThat(PaginaDashboard.esVisible(tituloEsperado))
        );
    }
    @Cuando("el usuario hace clic en el botón {string}")
    public void elUsuarioHaceClicEnElBotón(String textoBoton) {
        LOGGER.info("==> Da clic en el boton de nueva plantilla");
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
    @Cuando("ingresa el nombre del plantilla {string}")
    public void ingresaElNombreDelPlantilla(String nombrePlantilla) {
        LOGGER.info("==> Ingresa el nombre de la plantilla");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarNombrePlantillaTask.on(valor(nombrePlantilla))
        );
    }
    @Cuando("ingresa el código único de plantilla {string}")
    public void ingresaElCódigoÚnicoDePlantilla(String codigoUnico) {
        LOGGER.info("==> Ingresa el codigo de plantilla");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarCodigoPlantillaTask.on(valor(codigoUnico))
        );
    }
    @Cuando("escribe la descripción {string}")
    public void escribeLaDescripción(String descripcion) {
        LOGGER.info("==> Ingresa la descripcion de la plantilla");
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarDescripcionPlantillaTask.on(descripcion)
        );
    }
    @Cuando("carga el archivo {string}")
    public void cargaElArchivo(String nombreArchivo) {
        LOGGER.info("==> Sube el archivo png");
        OnStage.theActorInTheSpotlight().attemptsTo(
                UploadConRobot.desde(nombreArchivo)
        );
        System.out.println("Ingreso la ruta del archivo al file");
    }
    @Cuando("configura el parámetro de formato de plantilla {string}")
    public void configuraElParámetroDeFormatoDePlantilla(String string) {

    }
    @Cuando("el usuario da clic en el botón {string}")
    public void elUsuarioDaClicEnElBotón(String btnGuardar) {
        LOGGER.info("==> Da clic en el boton de guardar");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(btnGuardar)
        );
    }
    @Cuando("el usuario hace clic en {string} en el modal")
    public void elUsuarioHaceClicEnEnElModal(String btnAceptar) {
        LOGGER.info("==> Da clic en el boton de aceptar");
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(btnAceptar)
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


//
//    @Cuando("el usuario da clic en el botón {string}")
//    public void elUsuarioDaClicEnElBotón(String btnGuardar) {
//        LOGGER.info("==> Da clic en el boton de guardar");
//        OnStage.theActorInTheSpotlight().attemptsTo(
//                ClicBtoCrearSorteoTask.conTexto(btnGuardar)
//        );
//    }
//
//    @Y("el usuario hace clic en {string} en el modal")
//    public void elUsuarioHaceClicEnEnElModal(String btnAceptar) {
//        LOGGER.info("==> Da clic en el boton de aceptar");
//        OnStage.theActorInTheSpotlight().attemptsTo(
//                ClicBtoCrearSorteoTask.conTexto(btnAceptar)
//        );
//    }
//
//    @Entonces("debería aparecer un modal de confirmación {string}")
//    public void deberíaAparecerUnModalDeConfirmación(String tituloAlert) {
//        LOGGER.info("==> Valida la alert de la creacion del sorteo exitosa");
//        OnStage.theActorInTheSpotlight().should(
//                seeThat(PaginaCrearSorteo.sorteoSuccessful(tituloAlert))
//        );
//    }

}
