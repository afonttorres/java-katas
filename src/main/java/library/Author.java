package library;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Author {
    //VARS
    private String name;
    private Set<Book> bookList = new HashSet<>();

    public Author(String name){
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
    public void addBook(Book book){
        bookList.add(book);
    }
    public int countBooks() {
        return this.bookList.size();
    }

    public int countRentedBooks() {
        List<Book> booksRented =  this.bookList.stream().filter(Book -> Book.getIsRented()).collect(Collectors.toList());
        return booksRented.size();
    }
}
