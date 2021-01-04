import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartTest extends BaseTest{

    String actualNameOfTrip = "Egipt - El Gouna";
    String shoppingCartisEmpty = "Twój koszyk jest pusty.";



    @Test
    public void addTripToCartTest(){
        CartPaage cartPaage = new CartPaage(driver);
        cartPaage.clickOnHolidayWindsurfing();
        cartPaage.addEgiptElGounalToCart();
        WebElement nameOfTripAdedToCart = driver.findElement(By.xpath(".//a[@href=\"https://fakestore.testelka.pl/product/egipt-el-gouna/\" and text()=\"Egipt - El Gouna\"]"));
        Assertions.assertEquals(actualNameOfTrip, nameOfTripAdedToCart.getText());
    }

    @Test
    public void deleteTripFromCartTest() throws InterruptedException {
        CartPaage cartPaage = new CartPaage(driver);
        cartPaage.clickOnHolidayWindsurfing();
        cartPaage.addEgiptElGounalToCart();
        cartPaage.deleteTripFromCart();
        Thread.sleep(3000);
        WebElement emptyBasketInfo = driver.findElement(By.xpath(".//p[text()=\"Twój koszyk jest pusty.\"]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) emptyBasketInfo));
       // wait.until(ExpectedConditions.presenceOfElementLocated((By) deleteButton));
       // Assertions.assertEquals(shoppingCartisEmpty, deleteButton.getText());
    }
}
