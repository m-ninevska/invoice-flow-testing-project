import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class header {

    WebDriverWait wait;
    WebDriver driver;


    public header(WebDriverWait wait, WebDriver driver){
        this.wait = wait;
        this.driver = driver;
    }


      By nameField = By.cssSelector("input#invoice-number");
      By dateField = By.cssSelector("div.react-datepicker__input-container > input");
      By dateFieldOption = By.cssSelector("div.react-datepicker__week :nth-of-type(3)");
      By paymentDateField = By.xpath("//label[contains(text(), 'Payment Date')]/following::input[1]");
      By paymentFieldOption = By.cssSelector("div.react-datepicker__day:nth-of-type(6)");

    public void fillInvoiceNumber(){
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys("0093242345");
    }


    public void fillInvoiceDate() throws InterruptedException {
        WebElement invoiceDate = wait.until(ExpectedConditions.presenceOfElementLocated(dateField));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", invoiceDate);
        invoiceDate.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateFieldOption)).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();
    }

    public void fillPaymentDate() throws InterruptedException {
        WebElement paymentDate = wait.until(ExpectedConditions.presenceOfElementLocated(paymentDateField));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentDate);
        paymentDate.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFieldOption)).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();
    }
}


