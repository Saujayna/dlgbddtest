package ord.dlg.stepdefs;

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import ord.dlg.pom.TestPage;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class StepDefinition {
    TestPage testPage;
    WebDriver driver;

    @Given("^I use (chrome|firefox|ie|safari) browser$")
    public void StartBrowser(String browser){
        switch (browser){
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "Dependencies/chromedriver.exe");
                driver = new  ChromeDriver();
                break;
            case "firefox":
                driver = new  FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }
    }

    @Given("^I launch the DLG Test page$")
    public void LaunchDlgTestWebPage() throws Throwable {
        driver.navigate().to("https://covercheck.vwfsinsuranceportal.co.uk/");
        testPage = new TestPage(driver);
    }

    @When("^I submit the car reg '(.*)'$")
    public void SubmitCarReg(String carReg) throws Throwable {
        testPage.EnterReg(carReg);
        testPage.ClickSubmit();
    }

    @Then("^the car reg '(.*)' should exist$")
    public void ValidateCarReg(String carReg) throws Throwable {
        String text = testPage.GetResultsReg();
        Assert.assertThat(text, CoreMatchers.containsString(carReg));
    }

    @Then("^the car reg '(.*)' should not exist$")
    public void InValidateCarReg(String carReg) throws Throwable {
        String text = testPage.GetResultsReg();
        Assert.assertEquals("Sorry record not found", text.trim());
    }

    @Then("^the cover start should be '(.*)'")
    public void ValidateCoverStartDate(String startDateString) throws Throwable {
        String result = testPage.GetCoverStartDate();
        Assert.assertEquals(startDateString, result);
    }

    @Then("^the cover end should be '(.*)'")
    public void ValidateCoverEndDate(String endDateString) throws Throwable {
        String result = testPage.GetCoverEndDate();
        Assert.assertEquals(endDateString, result);
    }

    @After
    public void ScenarioCleanUp(){
        driver.close();
        driver.quit();
    }
}
