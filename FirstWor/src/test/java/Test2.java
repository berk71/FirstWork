import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test2  {

    private Test1 test1;
    @Test
    public void setTest1(){
        System.setProperty("webdriver.chrome.driver","C:\\tools\\ChromeDriver\\chromedriver.exe");
         test1=new Test1(new ChromeDriver(),"https://www.google.com/");
         try {
             test1.write("java");

    }catch (Exception e){
             e.printStackTrace();
         }
    }


}
