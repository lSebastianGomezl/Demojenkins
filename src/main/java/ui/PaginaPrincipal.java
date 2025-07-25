package ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://qa-backoffice.dcsas.co/#/login")
public class PaginaPrincipal extends PageObject {


    public static final Target TIPO_DOCUMENTO = Target.the("Select para tipo de documento").located(By.name("ctipoDocumento"));
    public static final Target TIPO_DOCUMENTO_OPTION = Target.the("opción para tipo de documento").locatedBy("[aria-label='{0}']");
    public static final Target SELECT_OPCION_ARIA_LABEL = Target.the("opción para tipo de documento").locatedBy("[aria-label*='{0}']");
    public static final Target SELECT_OPCION_ROLE = Target.the("opción role para tipo de documento").locatedBy("(//*[@role='option'])[{0}]");
    public static final Target USER = Target.the("Datos para campo de usuario").located(By.id("username"));
    public static final Target PASSWORD = Target.the("Datos para campo contrasenna").located(By.id("clave"));
    public static final Target BTN_DEMO_BIOMETRICO = Target.the("Check para demo biometrico").located(By.cssSelector("[title='Demo de biometrico']"));
    public static final Target BTN_SING_IN = Target.the("Boton iniciar sesion").located(By.xpath("//span[contains(text(),'Iniciar sesión')]"));
    public static final Target BTN_SING_IN_RECUPERAR = Target.the("Boton iniciar sesion recuperar").located(By.xpath("//button[contains(@class,'btn-login2')]"));
    public static final Target BTN_INGRESAR_HUELLA = Target.the("Boton ingresar huella").located(By.xpath("//span[contains(text(),'Aceptar')]"));
    public static final Target BTN_CANCELAR_HUELLA = Target.the("Boton cancelar huella").located(By.xpath("//span[contains(text(),'Cancelar')]"));
    public static final Target BTN_ACEPTAR_HUELLA = Target.the("Boton iniciar huella").located(By.xpath("//button[span[contains(text(),'Aceptar')]]"));
    public static final Target INDICADOR_CARGANDO_HUELLA = Target.the("indicador de que la huella esta cargando").located(By.xpath("//*[contains(@class,'rotate-svg')]"));
    public static final Target BTN_ACEPT = Target.the("Boton Aceptar").located(By.xpath("//button[contains(text(),'ACEPTAR')]"));
    public static final Target HOME_VALIDATION = Target.the("Verificar ingreso").located(By.xpath("//span[contains(text(),'Inicio')]"));
    public static final Target MENSAJE_ERROR_LOGIN = Target.the("Mensaje error login").located(By.xpath("//p[contains(@class,'text-danger font-montse')]"));
    public static final Target IMG_LOGO_LOGIN = Target.the("Imagen del logo").located(By.xpath("//img[contains(@class,'logo-login')]"));
    public static final Target LNK_RECUPERAR_CONTRASENA = Target.the("Link recuperar contraseña").located(By.xpath("//p[contains(text(),'Recuperar contraseña')]"));
    public static final Target BTN_TOLTIP_PASSWORD = Target.the("Boton mostrar contraseña").located(By.xpath("//em[contains(@class,'fa fa-eye font-size-16 aico-eye')]"));
    public static final Target BOTON_ACEPTAR_BIOMETRICO = Target.the("botón Aceptar del modal biométrico").locatedBy("//button[.//span[contains(text(),'Aceptar')]]");






}
