import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chapter5_GetRec {
    WebDriver driver;

    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationu.applitools.com/");
    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }


    @Test
    public void GetDimens(){
        WebElement TAULogo = driver.findElement(By.xpath("//div[@id='app']//header/a/img"));
        Rectangle logoRect = TAULogo.getRect();
        System.out.println("Logo Height: " +logoRect.getHeight());
        System.out.println("Logo Width: " +logoRect.getWidth());
        System.out.println("Logo x-position: " +logoRect.getX());
        System.out.println("Logo y-position: " +logoRect.getY());

    }

}
