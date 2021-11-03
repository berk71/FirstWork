import org.openqa.selenium.WebDriver;
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
    }
    public  void save(WebDriver driver){
        bookSearchPage=new BookSearchPage(driver);
        list=bookSearchPage.getBook();

    }
    public boolean equals(WebDriver driver){
        ExpectedPage page=new ExpectedPage(driver);
        return page.expected(list);
    }

}
