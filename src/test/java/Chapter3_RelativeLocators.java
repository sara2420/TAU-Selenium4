import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.testng.annotations.*;

import java.util.List;

public class Chapter3_RelativeLocators {
    WebDriver driver;

    @BeforeTest
    public void SetUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void TearDown(){
        //driver.quit();
    }


    @Test
    public void TestCredentials(){
        WebElement Logo = driver.findElement(By.id("divLogo"));
        WebElement Credentials =
                driver.findElement(RelativeLocator.with(By.tagName("span")).below(Logo));

        System.out.println(Credentials.getText());
    }

    @Test
    public void TestListOfElements(){
        WebElement footer = driver.findElement(By.id("footer"));
        List<WebElement> Media = driver.findElements(with(By.tagName("img")).near(footer));

        for (WebElement MediaLink : Media){
            System.out.println(MediaLink.getAttribute("alt"));
        }
    }
}
