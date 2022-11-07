package Steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;


public class Hooks {
    private static WebDriver driver;

    public synchronized static WebDriver openAndQuitBrowser() {
        String browser = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browser);

        if (driver == null) {

            try {
                if (browser == null) {
                    browser = System.getenv("BROWSER");
                    if (browser == null) {
                        browser = "hchrome";
                    }
                }

                switch (browser) {
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
//                        firefoxOptions.addArguments("start-maximized");
//                        firefoxOptions.addArguments("window-size=1920x1080");
                        driver = new FirefoxDriver(firefoxOptions);
                        break;

                    case "hfirefox":
                        FirefoxOptions hfirefoxOptions = new FirefoxOptions();
                        hfirefoxOptions.addArguments("--headless");
                        driver = new FirefoxDriver(hfirefoxOptions);
                        break;

                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("start-maximized");
                        driver = new ChromeDriver(options);
                        break;

                    case "hchrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOptionsoptions = new ChromeOptions();
                        chromeOptionsoptions.addArguments("--headless");
                        driver = new ChromeDriver(chromeOptionsoptions);
                        break;

                    case "hedge":
                        EdgeOptions hegdeoptions = new EdgeOptions();
                        hegdeoptions.addArguments("--headless");
                        driver = new EdgeDriver(hegdeoptions);
                        break;

                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.addArguments("start-maximized");
                        driver = new EdgeDriver(edgeOptions);
                        break;

                    default:
//                        driver = new FirefoxDriver();
                        driver = new EdgeDriver();
                        break;

                }
            }
            finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
//            driver.get("https://tiki.vn/");
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("Can not close the browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName()); // ... and embed it in the report.
        }
    }
//        @AfterStep
//    public void takeScreenshot(Scenario scenario) {
//            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png","image"); // ... and embed it in the report.
//    }
}


