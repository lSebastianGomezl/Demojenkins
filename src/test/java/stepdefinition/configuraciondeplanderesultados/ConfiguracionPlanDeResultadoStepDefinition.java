package stepdefinition.configuraciondeplanderesultados;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import models.BaloteraData;
import models.DatosUsuario;
import models.PlanDeResultadosData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import questions.configuracionplanresultados.BaloteraExiste;
import questions.configuracionplanresultados.ConfiguracionPlanResultadosQuestions;
import questions.crartipobalota.PaginaCrearTipoBalota;
import questions.crearsorteo.PaginaCrearSorteo;
import questions.login.PaginaDashboard;
import stepdefinition.login.LoginStepDefinition;
import tasks.Abrir;
import tasks.configuracionplanderesultados.*;
import tasks.configuracionsorteo.ClicSubMenuTask;
import tasks.configuracionsorteo.ElegirTipoDeFechaTask;
import tasks.configuracionsorteo.IngresarFechaSorteoTask;
import tasks.configuracionsorteo.IngresarHoraSorteoTask;
import tasks.crearsorteo.ClicBtoCrearSorteoTask;
import tasks.crearsorteo.ClicConfiguracionSorteoslTask;
import tasks.crearsorteo.ClicGestorSorteoVirtualTask;
import tasks.crearsorteo.formulario.*;
import tasks.login.*;
import ui.CreacionBalotaTotal;
import ui.PlanDeResultado;
import utils.GeneradorDatos;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConfiguracionPlanDeResultadoStepDefinition {
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
    @Cuando("el usuario hace clic en el botón {string}")
    public void elUsuarioHaceClicEnElBotón(String textoBoton) {
        LOGGER.info("==> Da clic en el boton de crear sorteo");
        System.out.println("Texto del boton" + textoBoton);
        theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(textoBoton)
        );
    }
    @Entonces("debería abrirse una nueva ventana con el formulario de creación de sorteos y ver el texto {string}")
    public void deberíaAbrirseUnaNuevaVentanaConElFormularioDeCreacionDeSorteosYVerElTexto(String tituloFormulario) {
        LOGGER.info("==> Valida el titulo del fomulario informacion de sorteo");
        System.out.println("este es el valor del titulo:" + tituloFormulario);
        theActorInTheSpotlight().should(
                seeThat(PaginaCrearSorteo.tituloFormulario(tituloFormulario))
        );
    }
    @Cuando("selecciona la empresa propietaria {string}")
    public void seleccionaLaEmpresaPropietaria(String tituloEmpresa) {
        LOGGER.info("==> Selecciona el nombre de la empresa propietaria");
        theActorInTheSpotlight().attemptsTo(
                SeleccionarEmpresaTask.empresaPropietaria(tituloEmpresa)
        );

    }
    @Cuando("ingresa el nombre del sorteo {string}")
    public void ingresaElNombreDelSorteo(String nombreSorteo) {
        LOGGER.info("==> Ingresa el nombre del sorteo");
        theActorInTheSpotlight().attemptsTo(
                IngresarNombreSorteoTask.on(valor(nombreSorteo))
        );
    }
    @Cuando("ingresa el código único del sorteo {string}")
    public void ingresaElCódigoÚnicoDelSorteo(String codigoUnico) {
        LOGGER.info("==> Ingresa el codigo del sorteo");
        theActorInTheSpotlight().attemptsTo(
                IngresarCodigoSorteoTask.on(valor(codigoUnico))
        );

    }
    @Cuando("selecciona el tipo de sorteo {string}")
    public void seleccionaElTipoDeSorteo(String tipoSorteo) {
        LOGGER.info("==> Ingresa el tipo de sorteo");
        theActorInTheSpotlight().attemptsTo(
                SeleccionarTipoSorteoTask.tipoSorteo(tipoSorteo)
        );

    }
    @Cuando("escribe la descripción {string}")
    public void escribeLaDescripción(String descripcion) {
        LOGGER.info("==> Ingresa la descripcion del sorteo");
        theActorInTheSpotlight().attemptsTo(
                IngresarDescripcionSorteoTask.on(descripcion)
        );

    }
    @Cuando("selecciona la fecha de inicio {string}")
    public void seleccionaLaFechaDeInicio(String fechaInicio) {
        LOGGER.info("==> Ingresa la fecha de inicio");
        theActorInTheSpotlight().attemptsTo(
                IngresarFechaIncioTask.on(valor(fechaInicio))
        );

    }
    @Cuando("selecciona la fecha de fin {string}")
    public void seleccionaLaFechaDeFin(String fechaFin) {
        LOGGER.info("==> Ingresa la fecha fin");
        theActorInTheSpotlight().attemptsTo(
                IngresarFechaFinalTask.on(valor(fechaFin))
        );

    }
    @Cuando("configura el parámetro de formato de sorteo {string}")
    public void configuraElParámetroDeFormatoDeSorteo(String formatoSorteo) {
        LOGGER.info("==> Selecciona el formato de sorteo");
        theActorInTheSpotlight().attemptsTo(
                SeleccionarFormatoSorteoTask.nombreFormatoSorteo(formatoSorteo)
        );
    }
    @Cuando("el usuario da clic en el botón {string}")
    public void elUsuarioDaClicEnElBotón(String btnGuardar) {
        LOGGER.info("==> Da clic en el boton de guardar");
        theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(btnGuardar)
        );
    }
    @Cuando("el usuario hace clic en {string} en el modal")
    public void elUsuarioHaceClicEnEnElModal(String btnAceptar) {
        LOGGER.info("==> Da clic en el boton de aceptar");
        theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(btnAceptar)
        );

    }
    @Cuando("el usuario ingresa al menú {string}")
    public void elUsuarioIngresaAlMenú(String txtMenu) {
        LOGGER.info("==> Da clic en el sub menu de Programaciones de sorteo");
        theActorInTheSpotlight().attemptsTo(
                ClicSubMenuTask.conTexto(txtMenu)
        );
    }
    @Cuando("el usuario da de nuevo clic en el botón {string}")
    public void elUsuarioDaDeNuevoClicEnElBotón(String textoBoton) {
        LOGGER.info("==> Da clic en el boton de Nueva Programacion");
        System.out.println("Texto del boton" + textoBoton);
        theActorInTheSpotlight().attemptsTo(
                ClicBtoCrearSorteoTask.conTexto(textoBoton)
        );
    }
    @Cuando("el usuario elige si es una {string}")
    public void elUsuarioEligeSiEsUna(String tipoFecha) {
        LOGGER.info("==> Da clic el seleccion de tipo de fecha");
        theActorInTheSpotlight().attemptsTo(
                ElegirTipoDeFechaTask.on(tipoFecha)
        );
    }
    @Cuando("la fecha de inicio y {string} de ejecución del sorteo")
    public void laFechaDeInicioFechaYDeEjecucionDelSorteo(String hora) {
        LOGGER.info("==> Ingresa la fecha y hora del sorteo");
        theActorInTheSpotlight().attemptsTo(
                IngresarFechaSorteoTask.on(),
                IngresarHoraSorteoTask.on(hora)
        );

    }

    @Cuando("selecciona el item {string}")
    public void seleccionaElItem(String item) {
        LOGGER.info("==> Da clic en eitem plan de resultados");
        System.out.println("Texto del item" + item);
        theActorInTheSpotlight().attemptsTo(
                ClicItemTask.conTexto(item)
        );
    }
    @Cuando("el usuario llena el formulario de plan de resultados")
    public void elUsuarioLlenaElFormularioDePlanDeResultados(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        Map<String, String> row = rows.get(0);

        PlanDeResultadosData data = new PlanDeResultadosData(
                row.get("nombre"),
                row.get("descripcion"),
                row.get("cantidad"),
                row.get("tipoPlan"),
                row.get("tiempoRetardo"),
                row.get("activar").equalsIgnoreCase("si")
        );

        theActorInTheSpotlight().attemptsTo(
                LlenarFormularioPlanResultados.conDatos(data)
        );

    }
    @Cuando("el usuario da selecciona {string}")
    public void elUsuarioDaSelecciona(String txtBtn) {
        LOGGER.info("==> Da clic en el boton agregar balota");
        theActorInTheSpotlight().attemptsTo(
                ClicAgregarBaloteraTask.agregarBalotera(txtBtn)
        );
    }
    @Cuando("el usuario llena el formulario de crear balotera")
    public void elUsuarioLlenaElFormularioDeCrearBalotera(DataTable dataTable) {
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);
        Map<String, String> fila = datos.get(0);

        BaloteraData data = BaloteraData.of(
                fila.get("nombre"),
                fila.get("rangoInicio"),
                fila.get("rangoFin"),
                fila.get("tipo") // puede ser null o vacío → selecciona la primera opción
        );

        theActorInTheSpotlight().attemptsTo(
                LlenarFormularioBalotera.conDatos(data)
        );
    }
    @Cuando("el usuario consulta el nombre de la balotera {string}")
    public void elUsuarioConsultaElNombreDeLaBalotera(String nombreBalotera) {
        LOGGER.info("==> Consulta el nombre de la balotera");
        theActorInTheSpotlight().attemptsTo(
                ConsultarBaloteraNombreTask.consultarBalotera(nombreBalotera)
        );
    }
    @Cuando("el usuario selecciona el checkbox de la balotera creada {string}")
    public void elUsuarioSeleccionaElCheckboxDeLaBaloteraCreada(String string) {
        LOGGER.info("==> Selecciona la balotera creada");
        String nombreBalotera = Serenity.sessionVariableCalled("nombreBalotera");
        theActorInTheSpotlight().attemptsTo(
                SeleccionarBalotera.conNombre(nombreBalotera)
        );
    }

    @Cuando("el usuario da clic en el boton guardar del modal")
    public void elUsuarioDaClicEnElBotonGuardarDelModal() {
        LOGGER.info("==> Selecciona el boton guardar");
        theActorInTheSpotlight().attemptsTo(
                ClicGuardarModalTask.btnGuardar()
        );
    }

    @Entonces("debería aparecer un modal de confirmación {string}")
    public void deberíaAparecerUnModalDeConfirmación(String tituloAlert) throws InterruptedException {
        LOGGER.info("==> Valida la alert de la creación de balotera y plan de resultado exitosa");
        // Espera al último toast con texto
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PlanDeResultado.MENSAJE_EXITO, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        // Validación con la Question
        OnStage.theActorInTheSpotlight().should(
                seeThat(ConfiguracionPlanResultadosQuestions.configuracionPlanResultadoSuccessful(tituloAlert))
        );
    }



}
