import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AmazonTest {
    private String s="https://www.amazon.com/";
    String u="https://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_2?dchild=1&keywords=Java&qid=1610356790&s=books&sr=1-2";
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
        for(Book c:amazon.getList()){
            System.out.println(c);
        }
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
        amazon.equals(driver);
    }


}
