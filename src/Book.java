import java.util.Objects;

public class Book {
    //The class that represents a single book
    //Contains the following variables:
    //-title as String
    //-author as String
    //-pages as int

    private String title;
    private String author;
    private int pages;

    //Constructor
    Book(String title, String author, int pages){
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    //Print a single book on the screen
    public void readBook(){
        System.out.println("Title: "+title+" / Author: "+author+" / Pages: "+pages);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private int getPages() {
        return pages;
    }

    private void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages);
    }
}
