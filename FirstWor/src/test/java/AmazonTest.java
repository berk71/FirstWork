import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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
        driver.get(u);
        boolean i=amazon.equals(driver);
        System.out.println(i);
        System.out.println("this book does not exist in the sheet");

    }


}
