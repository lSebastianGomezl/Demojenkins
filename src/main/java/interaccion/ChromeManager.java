package interaccion;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.webdriver.driverproviders.ChromeDriverCapabilities;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Optional;


//public class ChromeManager implements DriverSource {

//    private final EnvironmentVariables environmentVariables;
//
//    // Constructor que recibe las variables de entorno
//    public ChromeManager(EnvironmentVariables environmentVariables) {
//        this.environmentVariables = environmentVariables;
//    }
//    @Override
//    public WebDriver newDriver() {
//
//        //WebDriverManager.chromedriver().setup();
//
//        //ChromeOptions options = new ChromeOptions();
//        //options.addArguments("--remote-allow-origins=*");
//        //options.addArguments("--start-maximized");
//
//        return new ChromeDriver(options);
//
//    }
//
//    @Override
//    public boolean takesScreenshots() {
//        return false;
//    }
//}
