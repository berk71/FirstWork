import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2  {
String s="https://www.google.com/";
    private Test1 test1;
    @BeforeTest
    public void beforetest(){
        System.setProperty("webdriver.chrome.driver","C:\\tools\\ChromeDriver\\chromedriver.exe");
        test1=new Test1(new ChromeDriver(),s);
        System.out.println("Before");
    }
    @AfterTest
    public void after(){
        test1.read();
        System.out.println("after tets");
    }
    @Test
    public void setTest1(){

         try {
             test1.write("java");
             System.out.println("test");

    }catch (Exception e){
             e.printStackTrace();
         }
    }




}
