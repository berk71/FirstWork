import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    }
    public void read(){
        WebElement element=new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a//h3")));
        System.out.println(element.getText());
        driver.quit();
    }



}
