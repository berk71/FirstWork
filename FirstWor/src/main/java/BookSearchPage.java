import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BookSearchPage {
    private WebDriver driver;
    private List<WebElement> name;
    private List<WebElement> author;
    private List<WebElement> price ;
    private List<WebElement> price2;
    private  List<Book> book=new ArrayList<>();
    public List<Book> getBook() {
        return book;
    }


    public BookSearchPage(WebDriver driver) {
        this.driver = driver;
        init();
    }
    private void init(){
        name=driver.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\" or @class=\"a-size-base a-link-normal\"] "));
        author=driver.findElements(By.xpath("//div[@class=\"a-row\"]//a[@class=\"a-size-base a-color-base a-link-normal s-underline-text s-underline-link-text\"]"));
        price=driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]|//span[@class=\"a-price-fraction\"] "));
        initbook();
    }
    private void initbook(){
        int r=0;
        for(int i=0;i<author.size();i++){
            Book b=new Book();
            String y="$"+price.get(r).getText()+"."+price.get(r+1).getText();
            r+=2;
            b.setBookname(name.get(i).getText());
            b.setPrice(y);
            b.setAuthor(author.get(i).getText());
            book.add(b);
        }
    }
}
