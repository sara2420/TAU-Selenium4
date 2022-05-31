import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Chapter4_ManagingWindows {
    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        System.out.println("Title: " +driver.getTitle());
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void TestNewWindow(){
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
    }

    @Test
    public void TestWorkingInTwoTabs(){

        // Automatically open and switch to the new Window/Tab
        driver.manage().window().maximize();
        driver.switchTo().newWindow(WindowType.WINDOW)
                .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        System.out.println("Title: " +driver.getTitle());

        // Work in the new Window/Tab
        driver.findElement(By.id("email_create")).sendKeys("Selenium4@TAU.com");
        driver.findElement(By.id("SubmitCreate")).click();

        // Get the window ID Handles
        Set<String> AllWindowID = driver.getWindowHandles();
        Iterator<String> iterate = AllWindowID.iterator();
        String mainFirstWindow = iterate.next();

        // Switch and work in the main Window/Tab
        driver.switchTo().window(mainFirstWindow);
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys("Shirt");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Title: " +driver.getTitle());


    }

}
