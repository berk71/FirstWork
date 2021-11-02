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
List<WebElement>price2=driver.findElements(By.xpath("//span[@class=\"a-price-fraction\"]"));
if(author.isEmpty()){
    author=driver.findElements(By.xpath("//a[@class=\"a-size-base a-link-normal\"]"));
}
for(int i=0;i<author.size();i++){
    Book b=new Book();
  String y="$"+price.get(i).getText()+"."+price2.get(i).getText();
    b.setBookname(name.get(i).getText());
    b.setPrice(y);
    b.setAuthor(author.get(i).getText());
    list.add(b);

}
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        e.printStackTrace();
        }

    }
    public boolean equals(WebDriver driver){
        boolean m=false;
        WebElement c=driver.findElement(By.xpath("//span[@id=\"productTitle\"]"));
        WebElement q= driver.findElement(By.xpath("//span[@id=\"usedPrice\"]"));
        WebElement r= driver.findElement(By.xpath("//a[@class=\"a-link-normal contributorNameID\"]"));
        for (Book b:list){
            if(b.getAuthor().equals(r.getText())&&b.getBookname().equals(c.getText())&&b.getPrice().equals(q.getText()))m=true;
        }
return m;
    }
}
