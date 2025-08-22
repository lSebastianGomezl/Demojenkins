package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfiguracionParametros {

    public static final Target SELECCIONAR_TITULO_FORMULARIO(String formControlName){
        return Target.the("dropdown con formControlName " + formControlName)
                .located(By.xpath("//p-dropdown[@formcontrolname='" + formControlName + "']//span[contains(@class,'p-dropdown-label')]"));
    }

    public static final Target OPCION_DROPDOWN = Target.the("opción del dropdown")
            .locatedBy("//li[@role='option' and @aria-label='{0}']");

    public static final Target CAMPO_CLAVE_PARAMETRO = Target.the("campo de búsqueda del dropdown con placeholder {0}")
            .locatedBy("//input[@placeholder='{0}']");

    public static Target CONTENEDOR_CAMPO(String nombreCampo) {
        return Target.the("contenedor del campo " + nombreCampo)
                .locatedBy("//label//span[normalize-space()='" + nombreCampo + "']/ancestor::*[self::span or self::div]");

    }
    public static final Target CAMPO_BUSQUEDA = Target.the("campo de búsqueda")
            .located(By.id("parametro_filtros_dropdownFiltro_listKeys"));

    public static final Target NOMBRE_PARAMETRO = Target.the("campo nombre del parámetro")
            .located(By.xpath("//input[@formcontrolname='nombreParametro']"));

    public static final Target DESCRIPCION_PARAMETRO = Target.the("campo descripción del parámetro")
            .located(By.xpath("//input[@formcontrolname='descripcion']"));

    public static final Target EMPRESA_PROPIETARIA = Target.the("Nombre de la empresa propietaria")
            .located(By.xpath("//p-dropdown[@formcontrolname='companyId']"));

    public static Target OPCION_EMPRESA(String nombreEmpresa) {
        return Target.the("opción de empresa " + nombreEmpresa)
                .located(By.xpath("//p-dropdownitem//li//span[normalize-space()='" + nombreEmpresa + "']"));
    }

    public static final Target BOTON_EDITAR = Target.the("botón editar habilitado")
            .located(By.xpath("//i[contains(@class,'fa-pencil') and not(contains(@class,'opacity-50')) and @style='pointer-events: auto;']"));


}
