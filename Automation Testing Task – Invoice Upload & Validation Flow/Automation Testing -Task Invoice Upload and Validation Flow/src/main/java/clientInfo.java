import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clientInfo {
    WebDriverWait wait;
    WebDriver driver;

//creating constructor: it needs to have the same name as the class and as parameters it takes driver and wait which we give later as arguments.
//The constructor will initialize wait and driver after each instance object of the class later when performing element interaction.
    public clientInfo(WebDriverWait wait, WebDriver driver){
        this.wait = wait;
        this.driver = driver;
    }

//In each class we store the inspected elements/locators like this so that we can make the code reusable, well organized and maintainable.

    By clientName = By.cssSelector("input#client-name");
    By clientNumber = By.cssSelector("input#client-number");
    By clientEmail = By.cssSelector("input#client-email-address");
    By clientStreet = By.cssSelector("input#client-street");
    By clientCity = By.cssSelector("input#client-city");
    By clientState = By.cssSelector("input#client-state");
    By clientZip = By.cssSelector("input#client-postal-code");


 //What follows are methods related to the the target class, later these methods will be called in the test class.
    public void enterClientName() throws InterruptedException {
        WebElement name2 = wait.until(ExpectedConditions.visibilityOfElementLocated(clientName));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", name2);
        Thread.sleep(3000);
        name2.sendKeys("Client Test Name");
    }

    public void enterClientNum() throws InterruptedException {
        WebElement number2 = wait.until(ExpectedConditions.visibilityOfElementLocated(clientNumber));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", number2);
        Thread.sleep(3000);
        number2.sendKeys("546456");
    }

    public void enterClientEmail() throws InterruptedException {
        WebElement email2 = wait.until(ExpectedConditions.visibilityOfElementLocated(clientEmail));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", email2);
        Thread.sleep(3000);
        email2.sendKeys("dummyclientmail@postfix.com");
    }

    public void enterClientStreet() throws InterruptedException {
        WebElement street2 = wait.until(ExpectedConditions.visibilityOfElementLocated(clientStreet));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", street2);
        Thread.sleep(3000);
        street2.sendKeys("Dummy Street 2");
    }


    public void enterClientCity() throws InterruptedException {
        WebElement city2 = wait.until(ExpectedConditions.visibilityOfElementLocated(clientCity));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", city2);
        Thread.sleep(3000);
        city2.sendKeys("Las City");
    }

    public void enterClientState() throws InterruptedException {
        WebElement state2 = wait.until(ExpectedConditions.visibilityOfElementLocated(clientState));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", state2);
        Thread.sleep(3000);
        state2.sendKeys("Las State");
    }

    public void enterClientZip() throws InterruptedException {
        WebElement zip2 = wait.until(ExpectedConditions.visibilityOfElementLocated(clientZip));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", zip2);
        Thread.sleep(3000);
        zip2.sendKeys("Las State");
    }





}
