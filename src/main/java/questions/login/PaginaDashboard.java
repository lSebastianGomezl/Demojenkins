package questions.login;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import ui.Dashboard;

public class PaginaDashboard {

    public static Question<Boolean> esVisible(String texto) {
        return actor -> {
            String textoUI = Text.of(Dashboard.TITULO_DASHBOARD).answeredBy(actor).trim();
            System.out.println("Texto en UI capturado: [" + textoUI + "]");
            System.out.println("Texto esperado: [" + texto.trim() + "]");
            return textoUI.equalsIgnoreCase(texto.trim());
        };


    }


}
