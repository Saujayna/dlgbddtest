package ord.dlg.test;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TDDTests
{
    WebDriver driver;
    @Before
    public void TestSetup(){
        System.setProperty("webdriver.chrome.driver", "Dependencies/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void TestCleanup(){
        //Clean up the driver instances
        driver.close();
        driver.quit();
    }

    @Test
    public void CarRegValidationTest() throws InterruptedException {

        //Naviagte to URL
        driver.navigate().to("https://covercheck.vwfsinsuranceportal.co.uk/");

        //Verify a header text on the test page to make sure Url has lead to the right page
        WebElement headerElement = driver.findElement(By.xpath("//div[@id='dlg-dealersearch-title']"));
        String headerText = headerElement.getText();
        Assert.assertEquals("Drive Away Insurance", headerText);

        //Submit Reg details
        driver.findElement(By.xpath("//input[@id='vehicleReg']")).sendKeys("OV12UYY");
        driver.findElement(By.xpath("//button[@name='btnfind']")).click();

        //Verify if the results returned are for the correct reg
        String resultText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertThat(resultText, CoreMatchers.containsString("OV12UYY"));

        //Verify Cover Start and End Dates
        List<WebElement> elements = driver.findElements((By.xpath("//span[@class='resultDate']")));
        String coverStartDate = elements.get(0).getText();
        String coverEndDate = elements.get(1).getText();

        Assert.assertEquals("09 FEB 2022 : 16 : 26", coverStartDate);
        Assert.assertEquals("18 FEB 2022 : 23 : 59", coverEndDate);
    }
}
