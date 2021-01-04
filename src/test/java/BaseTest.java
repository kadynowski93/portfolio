import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriverWait wait;
    protected WebDriver driver;
    //By cookieAccept = By.cssSelector("#cn-accept-cookie");

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\IdeaProjects\\\\Testelka\\\\src\\\\main\\\\resources\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("https://fakestore.testelka.pl/");
        wait = new WebDriverWait(driver, 7);
        //driver.findElement(cookieAccept).click();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieAccept));
        driver.findElement(By.cssSelector(".woocommerce-store-notice__dismiss-link")).click();

    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
    }
}
