package library;

public class Book {
    //VARS
    private String title;
    private final Author author;
    private boolean isRented = false;

    public Book(String title, Author author){
        this.title = title;
        this.author = author;
        author.addBook(this);
    }
    //GETTERS
    public String getTitle() {
        return this.title;
    }
    public Author getAuthor() {
        return this.author;
    }
    public boolean getIsRented(){
        return this.isRented;
    }
    //SETTERS
    public void setIsRented(){
        this.isRented = true;
    }
    //METHODS
}
