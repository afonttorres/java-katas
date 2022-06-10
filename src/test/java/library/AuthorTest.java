package library;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorTest {
    @Test
    public void AuthorHasInitValues(){
        Author author = new Author("Jorge RR Martin");
        String name = author.getName();
        int bookCount = author.countBooks();
        assertEquals("Jorge RR Martin", name);
        assertEquals(0, bookCount);
    }

    @Test
    public void AuthorCanAddBook(){
        Author author = new Author("Jorge RR Martin");
        Book book = new Book("Game of thrones", author);
        int bookCount = author.countBooks();
        assertEquals(1, bookCount);
    }

    @Test
    public void AuthorCanSeeIfBookRented(){
        User user = new User("User");
        Author author = new Author("Jorge RR Martin");
        Book book = new Book("book", author);
        user.rentBook(book);
        Set<Book> bookList = author.getBookList();
        List<Book> booksRented =  bookList.stream().filter(Book -> Book.getIsRented()).collect(Collectors.toList());
        assertEquals(1, booksRented.size());
    }

    @Test
    public void AuthorCanSeeHowManyBooksAreRented(){
        User user = new User("User");
        Author author = new Author("Jorge RR Martin");
        Book book1 = new Book("book1", author);
        Book book2 = new Book("book2", author);
        Book book3 = new Book("book3", author);
        Book book4 = new Book("book4", author);
        Book book5 = new Book("book5", author);

        List<Book> books = List.of(book1, book2, book5);
        books.forEach(Book -> user.rentBook(Book));

        int booksRented = author.countRentedBooks();
        int bookCount = author.countBooks();
        assertEquals(3, booksRented);
        assertEquals(5, bookCount);
    }

}