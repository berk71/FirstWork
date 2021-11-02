import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\tools\\ChromeDriver\\chromedriver.exe");

        Test1 test1=new Test1(new ChromeDriver(),"https://www.google.com/");
        test1.write("java");
    }
}
