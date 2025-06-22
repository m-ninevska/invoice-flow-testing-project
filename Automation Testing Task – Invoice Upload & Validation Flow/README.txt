Test-automation-Invoice-Flow

Project Overview

This repository contains an Automated Test Suite built using Selenium WebDriver with Java, as well as Manual Test Cases and corresponding Defect Reports and several examples of possible improvments, all designed to validate the core features of a sample Invoice Generator Web Application. The tests cover data entry, uploads, form validation, error handling, and display of submitted invoices.

Repository Structure:
Main Project folder (Test Scripts)
Bug Recordings
Test Data
Manual Test Cases
Defect Reporting and Improvments
Recording of Automatic test run
README file

Base Page URL: https://simple.doclyinvoice.com/

Covered Features:
Valid/invalid data input.
Selection from widgets.
Selection from dropdown.
File/image upload.
Input of invoice metadata (e.g., Vendor, Date, Amount, Status)
Validation of required fields
Edge case handling (e.g., invalid file types, empty form)
Display of saved invoices.

Technology Stack
Language: Java  
Framework: Selenium WebDriver  
Build Tool: Maven
Test Runner: TestNG  
Design Pattern: Page Object Model (POM)  
Browser**: Chrome (via ChromeDriver)  

Project Structure and Logic
The POM is designed in a way that each section of the sample filling form has separate class dedicated to it (because we are working on a single page, i decided to divide that page in sections, otherwise in case of other pages to be tested, each page would have a separate class in the POM).

In each class we have created a constructor with the same name as the class, taking driver and wait as parameters (which we will give later as arguments). The constructor will initialize wait and driver after each instance of the class when performing elements interaction. 
In each class, locators are stored in an organized manner (via By class import) and in the following way:
(Example) By clientName = By.cssSelector("input#client-name");
I primarily relied on CSS locators, all unique (1/1 or 1/2) considering they are most stable in nature.
Moreover, each class has its methods associated with that class. Later these methods will be called in the test class.
For the test methods, JavascripExecutor and Actions class are imported in order to perform scroll or hover when necessary.

The test class setup is organized in the following way: We first declare webdriver and webdriverWait outside each class so that we can use them anywhere later in the code, as well as declaring classes in alignment to the POM design division of sections. All are to be initialized later in the before method.

Before method sets up/initializes the resources before each test in the class: we perform cleanup, initialisation of a new browser instance in order to avoid cache and other irregularities in the result.
We also perform basic setup like opening browser, maximizing window, navigation to page.

Similarly, Tear down (clean up) method will occur after each test. We perform cleanup of old cache and old active instances before the new test.

The test suite is organized in a single test method (considering the compactness of the project itself),
which means it has the default priority status (0). In the test class we call the methods from each of the class which were previously created and introduced as part of the POM.
The flow of the test: filling input fields, selecting options from widgets or dropdowns, perform upload, generate invoice).


IMPORTANT disclaimer on the uploading part:
When performing photo/file upload, i personally opt for the send.keys option to a input attribute elements. However, in our case, the input field has status hidden/not visible in the POM, which means it cannot be accessed and interacted with by Selenium driver (send.keys is only possible with <input type="file"> elements). One solution to this issue is to call JavaScript to make hidden input visible. This alternative is listed in our code as an option. Another solution is to use Robot class import to operate the upload dialogue via keyboard/mouse control (but the downside is that it is OS-dependent (also listed as an alternative)). Ideally, in a real context situation would be to communicate with the Devs for the Visibility of the Input field for our test environment only. For the purpose of our task, i will also perform manual test check on the upload to provide correct feedback on the issue.


