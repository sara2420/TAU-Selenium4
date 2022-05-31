import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Chapter6_Screenshots {
    WebDriver driver;

    @BeforeMethod
    public void Setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");
    }

    @Test /** using FileHandler **/
    public void TestTakeElementScreenshot() throws IOException {
        WebElement header = driver.findElement(By.cssSelector("#post-8 h1"));
        File source = header.getScreenshotAs(OutputType.FILE);
        File destination = new File("src/main/resources/header.png");
        FileHandler.copy(source,destination);
    }

    @Test /** using FileUtils **/
    public void TestTakePageSectionScreenshot() throws IOException {
        WebElement section = driver.findElement(By.xpath("//*[@id=\"post-8\"]/header"));
        File source  = section.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("src/main/resources/section.png"));
    }

    @Test
    public void TestTakingFullPageScreenShot() throws IOException {
        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("src/main/resources/fullpage.png"));

    }

}
