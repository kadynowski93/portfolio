import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Zadanie1 {

    WebDriver driver;
    WebDriverWait wait;
    By cookieAccept = By.cssSelector("#cn-accept-cookie");


    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Lenovo\\\\IdeaProjects\\\\Testelka\\\\src\\\\main\\\\resources\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jqueryui.com/selectable/");
        wait = new WebDriverWait(driver,5);
        //driver.findElement(cookieAccept).click();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieAccept));

    }

    @AfterEach
    public void driverQuit(){
        driver.quit();
    }

    @Test
    public void windowHandleTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        //actions.moveByOffset(792, 534).click().build().perform();
        driver.switchTo().frame(0);
        List<WebElement> listElements = driver.findElements(By.cssSelector("#selectable>li"));
        WebElement firstItem = listElements.get(0);
        actions.click(firstItem).build().perform();
    }
}
