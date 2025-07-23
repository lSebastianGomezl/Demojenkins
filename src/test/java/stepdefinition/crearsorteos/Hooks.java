package stepdefinition.crearsorteos;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private WebDriver hisBrowser;
    private EnvironmentVariables environmentVariables;

    @Before
    public void iniciarEscenario() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();



        boolean isHeadless = Boolean.parseBoolean(
                EnvironmentSpecificConfiguration.from(environmentVariables)
                        .getProperty("headless.mode")
        );

        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        } else {
            options.addArguments("--start-maximized");
            //options.addArguments("--force-device-scale-factor=0.75");
        }
        System.out.println("valor de headless: " + isHeadless );

        options.addArguments(
                "--lang=es",
                "--disable-popup-blocking",
                "--disable-download-notification",
                "--ignore-certificate-errors",
                "--allow-running-insecure-content",
                "--disable-translate",
                "--disable-extensions"
        );

        hisBrowser = new ChromeDriver(options);

        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User").can(BrowseTheWeb.with(hisBrowser));
    }


    @After
    public void cerrarEscenario() {
        if (hisBrowser != null) {
            hisBrowser.quit();
        }
    }
}

