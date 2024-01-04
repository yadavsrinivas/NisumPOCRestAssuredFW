import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SampleTest {

 @Test
    public void selectDropDown() {


        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");

        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();

        // Launch Website
        driver.navigate().to("https://www.nisum.com/contactus");
        driver.manage().window().maximize();
        Select drpCountry = new Select(driver.findElement(By.xpath("//select[contains(@name,'i_m_interested_in_drop_down_')]")));
        drpCountry.selectByVisibleText("Blockchain");



 }
}
