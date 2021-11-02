import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AmazonTest {
    private String s="https://www.amazon.com/";
    private WebDriver driver;
    private Amazon amazon;
    @BeforeSuite
    public void init(){
        System.setProperty("webdriver.chrome.driver","src\\chromedriver.exe");
        driver=new ChromeDriver();
        amazon=new Amazon();
        driver.get(s);
        System.out.println("Before test");
    }
    @AfterSuite
    public void after(){
        for(Book c:amazon.getList()){
            System.out.println(c);
            System.out.println("After test");
        }
    }
    @Test
    public void test(){
    amazon.select(driver);
    }
    @Test(dependsOnMethods ={"test"})
    public void test1(){
 amazon.save(driver);
        System.out.println("test");
    }

}
