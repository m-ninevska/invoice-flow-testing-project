import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.io.File;

public class companyInfo {

    WebDriverWait wait;
    WebDriver driver;


    public companyInfo(WebDriverWait wait, WebDriver driver){
        this.wait = wait;
        this.driver = driver;
    }

    By changeCompanyPhoto = By.cssSelector("input#file-upload");
    By uploadFile = By.cssSelector("input#file-upload");

    By companyName = By.cssSelector("input#company-name");
    By companyNumber = By.cssSelector("input#company-number");
    By companyEmail = By.cssSelector("input#company-email-address");
    By companyStreet = By.cssSelector("input#company-street");
    By companyCity = By.cssSelector("input#company-city");
    By companyState = By.cssSelector("input#company-state");
    By zipCode = By.cssSelector("input#company-postal-code");


//When performing photo/file upload, i personally opt for the send.keys option to a input attribute elements.
//However, in our case, the input field has status hidden/not visible in the POM, which means it cannot be accessed
// and interacted with by Selenium driver (send.keys is only possible with <input type="file"> elements).
//One solution to this issue is to call JavaScript to make hidden input visible. This alternative is listed in our code as an option.
//Another solution is to use Robot class import to operate the upload dialogue via keyboard/mouse control
//(but the downside is that it is OS-dependent (also listed as an alternative)).
//Ideally, in a real context situation would be to communicate with the Devs for the Visibility of the Input field for our test environment only.
//Manuel check will be performed on this as well.

    public void uploadCompanyPhoto1() throws InterruptedException {
        File file = new File("TestData/dummydata-companylogo.png");
        String absolutePath = file.getAbsolutePath();

        WebElement companyPhoto1 = wait.until(ExpectedConditions.presenceOfElementLocated(changeCompanyPhoto));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", companyPhoto1);
        Thread.sleep(3000);
        companyPhoto1.sendKeys(absolutePath);
        Thread.sleep(3000);
    }


    public void uploadCompanyPhoto1Alternative() throws AWTException {
        File file = new File("TestData/dummydata-companylogo.png");
        String absolutePath = file.getAbsolutePath();

        StringSelection stringSelection = new StringSelection(absolutePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        driver.findElement(changeCompanyPhoto).click();

        Robot robot = new Robot();
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
    }


    public void uploadCompanyPhoto2(){
        File file2 = new File("TestData/dummydata-companylogo.png");
        String absolutePath = file2.getAbsolutePath();

        WebElement companyPhoto2 = wait.until(ExpectedConditions.presenceOfElementLocated(uploadFile));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", companyPhoto2);
        companyPhoto2.sendKeys(absolutePath);
    }


    public void enterCompanyName() throws InterruptedException {
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(companyName));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", name);
        Thread.sleep(3000);
        name.sendKeys("Test Name");
    }

    public void enterEmail() throws InterruptedException {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(companyEmail));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", email);
        Thread.sleep(3000);
        email.sendKeys("dummymail@postfix.com");
    }


    public void enterCompanyNum() throws InterruptedException {
        WebElement number = wait.until(ExpectedConditions.visibilityOfElementLocated(companyNumber));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", number);
        Thread.sleep(3000);
        number.sendKeys("0023423503");
    }

    public void enterCompanyStreet() throws InterruptedException {
        WebElement street = wait.until(ExpectedConditions.visibilityOfElementLocated(companyStreet));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", street);
        Thread.sleep(3000);
        street.sendKeys("Dummy Street 00");
    }

    public void enterCompanyCity() throws InterruptedException {
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(companyCity));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", city);
        Thread.sleep(3000);
        city.sendKeys("Vice City");
    }

    public void enterCompanyState() throws InterruptedException {
        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(companyState));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", state);
        Thread.sleep(3000);
        state.sendKeys("Vice State");
    }

    public void enterZip() throws InterruptedException {
        WebElement zip = wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", zip);
        Thread.sleep(3000);
        zip.sendKeys("45345");
    }











}
