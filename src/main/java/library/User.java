package library;

import java.util.HashSet;
import java.util.Set;

public class User {
    //VARS
    private String name;
    private Set<Book> bookList = new HashSet<>();
    public User(String name){
        this.name = name;
    }
    //GETTERS
    public String getName(){
        return this.name;
    }
    public Set<Book> getBookList(){
        return this.bookList;
    }
    //SETTERS
    //METHODS
    public void rentBook(Book book){
        if(book.getIsRented()) return;
        this.bookList.add(book);
        book.setIsRented();
    }

    public int countBooks() {
        return this.bookList.size();
    }
}
