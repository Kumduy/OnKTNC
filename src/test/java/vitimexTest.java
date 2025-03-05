import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class vitimexTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void dangKy() throws InterruptedException {
        driver.get("https://vitimex.com.vn/dang-ky.html");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("TH01926");
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0866028127");
        driver.findElement(By.xpath("//input[@id='pass-regis']")).sendKeys("TH01926");
        driver.findElement(By.xpath("//input[@id='pass-confirm']")).sendKeys("TH01926");
        driver.findElement(By.xpath("//a[@id='register-btn']")).click();
        Thread.sleep(3000);
        assertTrue(driver.getCurrentUrl().contains("https://vitimex.com.vn/index.php?module=home&view=home"));
    }

    @Test
    public void dangNhap() throws InterruptedException {
        driver.get("https://vitimex.com.vn/");
        driver.findElement(By.xpath("//div[@class='li_log']//a[@data-bs-toggle='modal']//*[name()='svg']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='account']")).sendKeys("0866028127");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("TH01926");
        driver.findElement(By.xpath("//a[@id='signin-btn']")).click();
        Thread.sleep(3000);
        assertTrue(driver.getCurrentUrl().contains("https://vitimex.com.vn/"));
    }


}
