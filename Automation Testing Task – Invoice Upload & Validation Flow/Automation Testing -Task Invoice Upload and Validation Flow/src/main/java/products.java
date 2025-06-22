import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class products {

    WebDriverWait wait;
    WebDriver driver;


    public products(WebDriverWait wait, WebDriver driver){
        this.wait = wait;
        this.driver = driver;
    }

    By productName = By.cssSelector("input#item-name-0");
    By productQty = By.cssSelector("input#item-quantity-0");
    By productPrice = By.cssSelector("input#item-price-0");
    By productVAT = By.cssSelector("input#item-vat-0");


    public void enterProductName() throws InterruptedException {
        WebElement name3 = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", name3);
        Thread.sleep(3000);
        name3.sendKeys("Test Product Name");
    }

    public void enterProductQty() throws InterruptedException {
        WebElement qty = wait.until(ExpectedConditions.visibilityOfElementLocated(productQty));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", qty);
        Thread.sleep(3000);
        qty.sendKeys("1");
    }

    public void enterProductPrice() throws InterruptedException {
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", price);
        Thread.sleep(3000);
        price.sendKeys("996");
    }

    public void enterProductVat() throws InterruptedException {
        WebElement vat = wait.until(ExpectedConditions.visibilityOfElementLocated(productVAT));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vat);
        Thread.sleep(3000);
        vat.sendKeys("10");
    }

}
