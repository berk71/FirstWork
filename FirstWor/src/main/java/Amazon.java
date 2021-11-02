import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Amazon {
    private List<Book> list=new ArrayList<>();

    public List<Book> getList() {
        return list;
    }
    public void select(WebDriver driver){
        driver.findElement(By.xpath("//select[@aria-describedby=\"searchDropdownDescription\"]")).click();
        driver.findElement(By.xpath("//select//option[@value=\"search-alias=stripbooks-intl-ship\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Java", Keys.ENTER);
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void save(WebDriver driver){

List<WebElement> name=driver.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
List<WebElement> author=driver.findElements(By.xpath("//div[@class=\"a-row\"]//a[@class=\"a-size-base a-color-base a-link-normal s-underline-text s-underline-link-text\"]"));
List<WebElement> price=driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]"));
if(author.isEmpty()){
    author=driver.findElements(By.xpath("//a[@class=\"a-size-base a-link-normal\"]"));
}
for(int i=0;i<author.size();i++){
    Book b=new Book();

    b.setBookname(name.get(i).getText());
    b.setPrice(price.get(i).getText());
    b.setAuthor(author.get(i).getText());
    System.out.println(b);
    list.add(b);
}

    }
}
