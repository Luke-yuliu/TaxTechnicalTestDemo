import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class TaxTechnicalTestCases {

    private WebDriver driver;
    private String url = "https://www.taxtechnical.ird.govt.nz/";



    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testBreadcrumbAbout() {
//        WebElement header = driver.findElement(By.id("header"));
        driver.findElement(By.linkText("About")).click();
//        WebElement content = driver.findElement(By.id("content"));
        driver.findElement(By.linkText("Tax Technical - Inland Revenue NZ")).click();
        Assert.assertEquals("Check the breadcrumb in about",url,driver.getCurrentUrl());
    }

    @Test
    public void externalLinkIRMain() throws InterruptedException {
//        WebElement element = driver.findElement(By.xpath("/html//div[@id='header']/div[@class='row']/div//ul[@class='tp-text-links']//a[@title='IR main site']"));
//        element.click();
        String originalWindow = driver.getWindowHandle();
        WebElement element = driver.findElement(By.cssSelector("li:nth-child(3)"));
        element.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
System.out.println("found IR main website url = " + driver.getCurrentUrl());
//        assertEquals("expecting IR main website return", "https://www.ird.govt.nz/",element.getAttribute("href"));

    }

    @Test
    public void externalLinkTP() {
        String originalWindow = driver.getWindowHandle();
        WebElement element = driver.findElement(By.cssSelector("li:nth-child(4)"));
        element.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        assertEquals("https://taxpolicy.ird.govt.nz/", driver.getCurrentUrl());
    }

    @Test
    public void testBreadcrumb() {
        WebElement element = driver.findElement(By.cssSelector("[class = 'menu-tab'] [href ='/consultations']"));
        element.click();
        WebElement breadCrumbLocator = driver.findElement(By.cssSelector("[id='content'] [title='Home']"));
        breadCrumbLocator.click();
        Assert.assertEquals("Check breadcrumb","https://www.taxtechnical.ird.govt.nz/",driver.getCurrentUrl());
    }

    @Test
    public void searchBestMatchResult() {
        WebElement searchField = driver.findElement(By.xpath("//form[@id='search-form']//input[@name='tt-search-form__input']"));
        WebElement searchButton = driver.findElement(By.xpath("//form[@id='search-form']//button[@type='submit']"));
        searchField.sendKeys("My Tax");
        searchButton.click();
        WebElement buttonField = driver.findElement(By.xpath("//div[@id=\"content\"]/div/section/div/div[1]/div[2]/div/button"));
        Assert.assertEquals("Search displays best match","Best match",buttonField.getText());
    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(4000);
        driver.quit();
        
    }
}
