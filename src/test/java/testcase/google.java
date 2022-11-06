package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class google {
  WebDriver driver;
  @BeforeClass
      public void beforeClass(){
//    FirefoxOptions options = new FirefoxOptions();
////    options.addArguments("--headless");
////        options.addArguments("start-maximized");
//    options.addArguments("window-size=1920x1080");
//    driver = new FirefoxDriver(options);


    EdgeOptions options = new EdgeOptions();
//    options.addArguments("--headless");
    options.addArguments("start-maximized");
      driver = new EdgeDriver(options);

//    driver = new ChromeDriver();
    }
    @Test
    public void TC_01_Open_goole(){
      driver.get("https://www.google.com.vn/?hl=vi");
      driver.findElement(By.xpath("//input[@name='q']")).sendKeys("minh");
      driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.RETURN);
      driver.quit();
    }
}
