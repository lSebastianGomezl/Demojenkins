package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PlanDeResultado {
    public static final Target TAB_BY_TITLE = Target.the("Tab con título {0}")
            .locatedBy("//a[@role='tab' and contains(@class,'p-tabview-nav-link') and contains(.,'{0}')]");


    //Formulario plan de resultados :
    public static final Target NOMBRE = Target.the("Campo nombre del plan")
            .locatedBy("//input[@formcontrolname='nombrePlan']");

    public static final Target DESCRIPCION = Target.the("Campo descripción del plan")
            .locatedBy("//textarea[@formcontrolname='descripcionSorteo']");

    public static final Target CANTIDAD_RESULTADOS = Target.the("Campo cantidad de resultados")
            .locatedBy("//input[@formcontrolname='cantidadResultados']");

    public static final Target TIPO_PLAN_DROPDOWN = Target.the("Dropdown tipo de plan de resultados")
            .locatedBy("//span[contains(@class,'p-dropdown-label')]");

    public static final Target OPCION_TIPO_PLAN = Target.the("Opción tipo de plan {0}")
            .locatedBy("//li[@role='option']//span[normalize-space(text())='{0}']");
    public static final Target TIEMPO_RETARDO = Target.the("Campo tiempo de retardo")
            .located(By.xpath("//input[@formcontrolname='tiempoRetardo']"));
    public static final Target ACTIVAR_VISUALIZADOR = Target.the("Interruptor activar visualizador")
            .locatedBy("//span[contains(@class,'p-inputswitch-slider')]");
    public static final Target BTN_AGREGAR_BALOTERA = Target.the("Botón agregar balotera")
            .located(By.xpath("//button[normalize-space(text())='Agregar balotera']"));

    //Formulario agregar balotera:

    public static final Target NOMBRE_BALOTERA = Target.the("Campo nombre de balotera")
            .located(By.xpath("//input[@formcontrolname='nombreBalotera']"));

    public static final Target RANGO_INICIO = Target.the("Campo rango inicio")
            .located(By.xpath("//input[@formcontrolname='rangoInicio']"));

    public static final Target RANGO_FIN = Target.the("Campo rango fin")
            .located(By.xpath("//input[@formcontrolname='rangoFin']"));


    public static final Target TIPO_DROPDOWN = Target.the("desplegable tipo de balotera")
            .located(By.xpath("//span[contains(@class,'p-dropdown-label') and contains(normalize-space(.),'Seleccionar')]"));

    // Para seleccionar una opción específica (parametrizable)
    public static final Target OPCION_TIPO = Target.the("Opción tipo de balotera {0}")
            .locatedBy("//li[@role='option']//span[normalize-space(text())='{0}']");

    // Para seleccionar siempre el PRIMERO de la lista
    public static final Target PRIMER_OPCION_TIPO = Target.the("Primera opción de la lista")
            .located(By.xpath("(//li[@role='option'])[1]"));

    public static final Target LISTA_BALOTERAS = Target.the("lista de nombres de baloteras")
            .locatedBy("//table[@id='pr_id_66-table']//tbody/tr/td[2]");


    // Columna con el nombre de la balotera
    public static final Target NOMBRE_BALOTERA_CELDA = Target.the("Celda de nombre de balotera")
            .locatedBy("//td[normalize-space()='{0}']");

    public static Target CHECKBOX_BALOTERA(String nombre) {
        return Target.the("Checkbox de la balotera " + nombre)
                .locatedBy("//div[@role='checkbox' and contains(@class,'p-checkbox-box')]");
    }

    // Columna con el nombre de la balotera
    public static final Target BTN_GUARDAR = Target.the("Celda de nombre de balotera")
            .located(By.xpath("(//button[.//label[normalize-space(text())='Guardar']])[2]"));

    public static Target validacionCracionPlanDeResultado(String texto) {
        return Target.the("botón con texto: " + texto)
                .located(By.xpath("//div[contains(@class, 'p-toast-detail') and contains(normalize-space(.), '" + texto + "')]"));
    }
    public static final Target MENSAJE_EXITO = Target.the("mensaje éxito")
            .located(By.xpath("(//div[contains(@class,'p-toast-detail')])[2]"));



}
