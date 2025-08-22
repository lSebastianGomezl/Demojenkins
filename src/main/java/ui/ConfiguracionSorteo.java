package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import utils.GeneradorDatos;

import static utils.GeneradorDatos.obtenerDiaActual;

public class ConfiguracionSorteo {

    public static Target tituloInformacionSorteo(String texto) {
        return Target.the("título del panel con texto " + texto)
                .located(By.xpath("//div[contains(@id, 'p-panel') and contains(@class, 'p-panel-header')]//span[contains(@class, 'sub-title') and normalize-space(text())='" + texto + "']"));

    }
    public static final Target EMPRESA_PROPIETARIA = Target.the("empresa propietaria")
            .located(By.xpath("//span[contains(@class, 'p-dropdown-label') and text()='Seleccionar']"));

    public static Target valorEmpresaPropietaria(String valor) {
        return Target.the("opción del dropdown")
                .located(By.xpath("//li[@role='option' and @aria-label='" + valor + "']"));
    }
    public static final Target NOMBRE_SORTEO = Target.the("nombre del sorteo")
            .located(By.xpath("//input[@formcontrolname='nombreSorteo']"));

    public static final Target CODIGO_UNICO = Target.the("código único del sorteo")
            .located(By.xpath("//input[@formcontrolname='codigoUnico']"));

    public static final Target TIPO_SORTEO = Target.the("tipo de sorteo")
            .located(By.xpath("//span[contains(@class, 'p-dropdown-label') and normalize-space(text())='Seleccionar']"));
    public static Target valorTipoDeSorte(String valor) {
        return Target.the("opción de tipo sorteo")
                .located(By.xpath("//li[@role='option']//span[normalize-space(text())='" + valor + "']"));
    }
    public static final Target DESCRIPCION = Target.the("descripción")
            .located(By.xpath("//textarea[@formcontrolname='descripcionSorteo']"));
    public static final Target FECHA_INICIO = Target.the("fecha de inicio")
            .located(By.id("fechaInicio"));
    public static final Target FECHA_FIN = Target.the("fecha de fin")
            .located(By.id("fechaFin"));

    public static Target formatoNombreSorteo(String texto) {
        return Target.the("botón con texto: " + texto)
                .located(By.xpath("//button[contains(normalize-space(.), '" + texto + "')]"));
    }

    public static final Target ALERT_SUCCESSFUL = Target.the("Creacion de sorteo exitoso")
            .located(By.xpath("//div[contains(@class, 'p-toast-detail') and contains(normalize-space(.), 'Configuración de sorteo creado exitosamente.')]"));

    public static Target validacionCracionSorteo(String texto) {
        return Target.the("botón con texto: " + texto)
                .located(By.xpath("//div[contains(@class, 'p-toast-detail') and contains(normalize-space(.), '" + texto + "')]"));
    }//div[contains(@class, 'p-toast-detail') and contains(., 'Configuración de parámetros')]

    public static final Target CONSULTAR_CODIGO_UNICO = Target.the("consultar código único del sorteo")
            .located(By.xpath("//input[@formcontrolname='code']"));

    public static Target botonEditarSorteo(String codigoSorteo) {
        return Target.the("botón editar del sorteo con código " + codigoSorteo)
                .located(By.xpath("//tr[td[1][normalize-space()='" + codigoSorteo + "']]//i[@title='Editar']"));


    }
    public static Target botonSubMenu(String texto) {
        return Target.the("botón con texto '" + texto + "'")
                .located(By.xpath("//button[.//span[normalize-space()='" + texto + "']]"));
    }

    public static final Target CHECK_BOX = Target.the("check box unica fecha ")
            .located(By.xpath("(//div[contains(@class, 'p-radiobutton-box')])[1]"));


    public static final Target CHECK_BOX_MULTIPLES = Target.the("check box multiples fechas ")
            .located(By.xpath("(//div[contains(@class, 'p-radiobutton-box')])[2]"));


    public static final Target FECHA_SORTEO = Target.the("campo de fecha de sorteo")
            .located(By.id("fechaSorteoUnicaFecha"));


    public static final Target DIA_ACTUAL = Target.the("día actual del calendario")
            .located(By.xpath("//td[not(contains(@class, 'p-datepicker-other-month'))]//span[contains(@class, 'p-ripple') and not(contains(@class, 'p-disabled')) and text()='"+ GeneradorDatos.obtenerDiaActual() +"']"));

    public static final Target HORA_SORTEO = Target.the("campo de hora de sorteo")
            .located(By.xpath("//input[@placeholder='Hora de sorteo']"));

    public static final Target FECHA_RANGO_INICIAL = Target.the("fecha de rango inicial")
            .located(By.id("fechaInicio"));

    public static final Target FECHA_RANGO_FINAL = Target.the("fecha de rango final")
            .located(By.id("fechaFin"));

    public static final Target HORA_RANGO_INICIAL = Target.the("hora de rango inicial")
            .located(By.xpath("(//input[@placeholder='Hora'])[1]"));

    public static final Target HORA_RANGO_FINAL = Target.the("hora de rango final")
            .located(By.xpath("(//input[@placeholder='Hora'])[2]"));

    public static final Target ITEM_MES = Target.the("item de mes en la parametrizacion")
            .located(By.xpath("//a[.//span[text()='Mes']]"));

    public static final Target ITEM_DIAS = Target.the("item de mes en la parametrizacion")
            .located(By.xpath("//a[.//span[text()='Días']]"));

    public static Target MES_SIGUIENTE(int mesSiguiente) {
        return Target.the("Mes siguiente")
                .locatedBy("//p-checkbox[@ng-reflect-value='{0}']//div[contains(@class,'p-checkbox-box')]")
                .of(String.valueOf(mesSiguiente));
    }

    public static final Target RADIO_SELECCIONADO_ULTIMO_DIA = Target.the("Radio button 'El último' seleccionado")
            .located(By.xpath("//label[@for='ultimoDiaMes' and text()='El último día del mes']"));

    public static final Target RADIO_SELECCIONADO_DIA_ESPECIFICO = Target.the("Radio button dia especifico")
            .located(By.xpath("//input[@id='diasSemanaEspecificos']/ancestor::p-radiobutton//div[contains(@class,'p-radiobutton-box')]"));

    public static Target DIA_SEMANA(String valor) {
        return Target.the("Label del día de la semana " + valor)
                .locatedBy("//label[@for='dia{0}']")
                .of(valor);
    }
    public static final Target ITEM_HORAS = Target.the("Pestaña 'Horas'")
            .located(By.xpath("//a[.//span[text()='Horas']]"));


    public static Target HORA_ESPECIFICA(String hora) {
        return Target.the("Checkbox de la hora " + hora)
                .locatedBy("//label[@for='hora{0}']")
                .of(hora);
    }


}
