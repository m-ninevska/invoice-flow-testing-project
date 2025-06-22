import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class finalSection {

    WebDriverWait wait;
    WebDriver driver;


    public finalSection(WebDriverWait wait, WebDriver driver){
        this.wait = wait;
        this.driver = driver;
    }

    By generateReportBtn = By.cssSelector("div.px-4.py-3 > button");

    public void generateInvoice() throws InterruptedException {
        WebElement invoice = wait.until(ExpectedConditions.visibilityOfElementLocated(generateReportBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", invoice);
        Thread.sleep(3000);
        invoice.click();
    }
}
