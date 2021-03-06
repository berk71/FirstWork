import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExpectedPage {
    private WebDriver driver;
    private WebElement name;
    private WebElement author;
    private WebElement price;
    private Book book;
    public ExpectedPage(WebDriver driver) {
        this.driver = driver;
        init();
    }


    public Book getBook() {
        return book;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getAuthor() {
        return author;
    }

    public WebElement getPrice() {
        return price;
    }
    public void init(){
        name=driver.findElement(By.xpath("//span[@id=\"productTitle\"]"));
        author= driver.findElement(By.xpath("//span[@class=\"author notFaded\"]//a[@class=\"a-link-normal contributorNameID\"]"));
        price= driver.findElement(By.xpath("//span[@id=\"newBuyBoxPrice\" or @class=\"a-color-price\"]"));
        Book();
    }
    public void Book(){
        book= new Book(name.getText(),author.getText(),price.getText());
    }
    public boolean expected(List<Book> list){
        boolean m=false;
        for(Book b:list){
            if(b.getBookname().equals(book.getBookname())&&b.getAuthor().equals(book.getAuthor())&&b.getPrice().equals(book.getPrice())){
                m=true;
                break;
            }
        }
        return m;
    }

}
