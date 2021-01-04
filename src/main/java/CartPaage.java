import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPaage extends BasePage{

    WebDriverWait wait;

    public CartPaage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 7);
    }



    By windsurfingImageLocator = By.xpath(".//img[@src='https://fakestore.testelka.pl/wp-content/uploads/2018/08/vidar-nordli-mathisen-634280-unsplash-324x324.jpg']");
        By egiptElGounaLocator = By.xpath(".//a[@data-product_id='386']");
        By showShopingCartLocator = By.xpath(".//a[@title='Zobacz koszyk']");
        By deleteButtonLocator = By.xpath(".//a[@class='remove']");


        public void clickOnHolidayWindsurfing(){
            wait.until(ExpectedConditions.presenceOfElementLocated(windsurfingImageLocator)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(egiptElGounaLocator));
        }

        public void addEgiptElGounalToCart(){
            driver.findElement(egiptElGounaLocator).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(showShopingCartLocator)).click();
        }

        public void deleteTripFromCart(){
            wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator)).click();
        }
}
