import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test1 {
    protected WebDriver driver;
    protected String c;
    private By xpath=By.xpath("//input[@name=\"q\"]");

    public Test1(WebDriver driver, String c) {
        this.driver = driver;
        this.c = c;
    }


    public  void write(String s)throws Exception{
        driver.get(c);
        driver.findElement(xpath).sendKeys(s, Keys.ENTER);
        Thread.sleep(2000);
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//title")));

        driver.close();

    }


}
