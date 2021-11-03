import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Amazon {
    private SearchPage searchPage;
    private BookSearchPage bookSearchPage;
    private List<Book> list;

    public List<Book> getList() {
        return list;
    }
    public void select(WebDriver driver){
       searchPage=new SearchPage(driver);
       searchPage.search();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void save(WebDriver driver){
        bookSearchPage=new BookSearchPage(driver);
        list=bookSearchPage.getBook();

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
