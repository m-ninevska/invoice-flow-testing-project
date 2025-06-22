import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class InvoiceFlowE2E {

    //Declaring webdriver and webdriverWait outside each class so that we can use them anywhere
    //Declaring class in alignment to the POM design division of sections
    //All will be initialized later in the before method.

    WebDriver driver;
    WebDriverWait wait;

    header header;
    companyInfo companyInfo;
    clientInfo clientInfo;
    products products;
    finalSection finalSection;

//Set up (initialize) resources before each test in the class: we perform cleanup, initialisation of a new browser instance
// in order to avoid cache and other irregularities in the result

//We initialize and invoke instance objects from each class according to the POM design.
//We perform basic setup like opening browser, maximizing window, navigation to page.

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        header = new header(wait, driver);
        clientInfo = new clientInfo(wait, driver);
        companyInfo = new companyInfo(wait, driver);
        products = new products(wait, driver);
        finalSection = new finalSection(wait, driver);
        driver.manage().window().maximize();
        driver.get("https://simple.doclyinvoice.com/");
    }

//Tear down (clean up) method will occur after each test. We perform cleanup of old cache and old active instances before the new test.

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    //The test has default priority status (0), as i have orginized the flow in one test.
    //We call methods from the separate classees which we previously created as part of the POM.
    //We use asserts to validate truths of certain arguments
    //We use imported class JavascripExecutor and Actions in order to perform scroll or hover when necessary.
    //The flow in short goes sas follows: filling input fields, selecting options from widgets or dropdowns, perform upload, generate invoice).

    @Test(description = "Navigating to Page, filling form, performing upload, finalizing generate upload")
    public void invoiceFlow() throws InterruptedException, AWTException {
        header.fillInvoiceNumber();
        header.fillInvoiceDate();
        header.fillPaymentDate();

        companyInfo.enterCompanyName();
        companyInfo.enterCompanyNum();
        //companyInfo.uploadCompanyPhoto1();
        //companyInfo.uploadCompanyPhoto1Alternative();
        //companyInfo.uploadCompanyPhoto2();
        companyInfo.enterEmail();
        companyInfo.enterCompanyStreet();
        companyInfo.enterCompanyCity();
        companyInfo.enterCompanyState();
        companyInfo.enterZip();

        clientInfo.enterClientName();
        clientInfo.enterClientNum();
        clientInfo.enterClientEmail();
        clientInfo.enterClientStreet();
        clientInfo.enterClientCity();
        clientInfo.enterClientState();
        clientInfo.enterClientZip();

        products.enterProductName();
        products.enterProductQty();
        products.enterProductPrice();
        products.enterProductVat();

        finalSection.generateInvoice();


    }

}
