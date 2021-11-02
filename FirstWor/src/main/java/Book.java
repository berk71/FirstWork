public class Book {
    private String bookname;
    private String author;
    private String price;

    public Book() {
    }

    public Book(String bookname, String author, String price) {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return bookname+":"+author+","+price;
    }
}
