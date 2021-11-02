import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Test1 {
    protected WebDriver driver;
    protected String c;
    private By xpath=By.xpath("//input[@name=\"q\"]");

    public Test1(WebDriver driver, String c) {
        this.driver = driver;
        this.c = c;
    }


    public  void write(String s){
        driver.get(c);
        driver.findElement(xpath).sendKeys(s, Keys.ENTER);
    }

}
