import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class vitimexTest {
    ChromeDriver chromeDriver;
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromeDriver= new ChromeDriver();
    }

    @Test
    public void dangKy() throws InterruptedException {
       chromeDriver.get("https://vitimex.com.vn/dang-ky.html");
       chromeDriver.findElement(By.xpath("//input[@id='name']")).sendKeys("TH01926");
       chromeDriver.findElement(By.xpath("//input[@id='phone']")).sendKeys("086602812");
       chromeDriver.findElement(By.xpath("//input[@id='pass-regis']")).sendKeys("TH01926");
       chromeDriver.findElement(By.xpath("//input[@id='pass-confirm']")).sendKeys("TH01926");
       chromeDriver.findElement(By.xpath("//a[@id='register-btn']")).click();
       Thread.sleep(3000);
       assertTrue(chromeDriver.getCurrentUrl().contains("https://vitimex.com.vn/index.php?module=home&view=home"));
    }

    @Test
    public void dangNhap() throws InterruptedException {
        chromeDriver.get("https://vitimex.com.vn/");
        chromeDriver.findElement(By.xpath("//div[@class='li_log']//a[@data-bs-toggle='modal']//*[name()='svg']")).click();
        Thread.sleep(5000);
        chromeDriver.findElement(By.xpath("//input[@id='account']")).sendKeys("0866028126");
        chromeDriver.findElement(By.xpath("//input[@id='pass']")).sendKeys("TH01926");
        chromeDriver.findElement(By.xpath("//a[@id='signin-btn']")).click();
        Thread.sleep(3000);
        assertTrue(chromeDriver.getCurrentUrl().contains("https://vitimex.com.vn/"));
    }

}
