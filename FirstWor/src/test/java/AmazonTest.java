import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTest {
    private String s="https://www.amazon.com/";
    String u="https://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_2?dchild=1&keywords=Java&qid=1610356790&s=books&sr=1-2";
    String p="https://www.amazon.com/Effective-Java-Joshua-Bloch/dp/0134685997/ref=sr_1_1?crid=2AQ3UQ921DTD7&dchild=1&keywords=java&qid=1635931165&sprefix=java%2Caps%2C227&sr=8-1";
    private WebDriver driver;
    private Amazon amazon;
    @BeforeSuite
    public void init(){
        System.setProperty("webdriver.chrome.driver","src\\chromedriver.exe");
        driver=new ChromeDriver();
        amazon=new Amazon();
        driver.get(s);
    }
    @AfterSuite
    public void after(){
        driver.quit();
    }
    //в цьому тесті змінюються налаштування фільтру та проводится пошук
    @Test
    public void search(){
         amazon.select(driver);
    }
    // в цьому тесті дістається інформація про книги та перевіряється чи є вони на сторінці пошуку
    @Test(dependsOnMethods ={"search"})
    public void equals(){
         amazon.save(driver);
         driver.get(u);
         SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(amazon.equals(driver),false,"First book does not exit");
        driver.get(p);
        softAssert.assertEquals(amazon.equals(driver),true,"Second book does not exit");
        softAssert.assertAll();
    }


}
