package ord.dlg.pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestPage {

    @FindBy(xpath = "//input[@id='vehicleReg']")
    WebElement carRegEditField;

    @FindBy(xpath = "//button[@name='btnfind']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@id='dlg-dealersearch-title']")
    WebElement headerTextField;

    @FindBy(xpath = "//div[@class='result']")
    WebElement regResultText;

    @FindBy(xpath = "//span[@class='resultDate']")
    List<WebElement> coverDatesTextFields;

    WebDriver driver;
    public TestPage(WebDriver _driver){
        driver = _driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);

        String headerText = GetHeaderText();
        Assert.assertEquals("Drive Away Insurance", headerText);
    }

    public void EnterReg(String carReg){
        carRegEditField.sendKeys(carReg);
    }

    public void ClickSubmit(){
        submitButton.click();
    }

    public String GetHeaderText(){
        String headerText = headerTextField.getText();
        return headerText;
    }

    public String GetResultsReg(){
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='result']")));
        String resultText = regResultText.getText();
        return resultText;
    }
    public String GetCoverStartDate(){
        String coverStartDate = coverDatesTextFields.get(0).getText();
        return coverStartDate;
    }

    public String GetCoverEndDate(){
        String coverEndDate = coverDatesTextFields.get(1).getText();
        return coverEndDate;
    }
}
