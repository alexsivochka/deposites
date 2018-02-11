

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BeforeAfter {
    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    protected void getDriver(String browser) {
        if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/Alexsivochka/Desktop/geckodriver-v0.19.1-win64/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/Alexsivochka/Desktop/geckodriver-v0.19.1-win64/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://privatbank.ua/depozit");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    protected void tearDown() {
        driver.close();
    }
}
