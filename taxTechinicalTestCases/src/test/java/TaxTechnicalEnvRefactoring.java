import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class TaxTechnicalEnvRefactoring {

    Environment testEnvironment;
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        testEnvironment = ConfigFactory.create(Environment.class);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testBreadcrumbAbout() {
        driver.get(testEnvironment.homepage());
        driver.findElement(By.linkText("About")).click();
        driver.findElement(By.linkText("Tax Technical - Inland Revenue NZ")).click();
        Assert.assertEquals("Check the breadcrumb in about",testEnvironment.homepage(),driver.getCurrentUrl());
    }

}
