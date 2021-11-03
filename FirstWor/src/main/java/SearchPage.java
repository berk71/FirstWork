import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage  {
    private WebDriver driver;
    private WebElement filter1;
    private WebElement filterbook;
    private  WebElement search;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        init();

    }

    public WebElement getFilter1() {
        return filter1;
    }

    public WebElement getFilterbook() {
        return filterbook;
    }

    public WebElement getSearch() {
        return search;
    }
    public void clickfilter1(){
        getFilter1().click();
    }
    public  void  clickbookfilter(){
        clickfilter1();
        getFilterbook().click();
    }
    public void search(){
        clickbookfilter();
        getSearch().sendKeys("java", Keys.ENTER);
    }
    private  void  init(){
        filter1=driver.findElement(By.xpath("//select[@aria-describedby=\"searchDropdownDescription\"]"));
        filterbook= driver.findElement(By.xpath("//select//option[@value=\"search-alias=stripbooks-intl-ship\"]"));
        search= driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
    }

}
