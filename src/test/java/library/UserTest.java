package library;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    public void UserHasInitValues(){
        User user = new User("User");
        String name = user.getName();
        int bookCount = user.countBooks();
        assertEquals("User", name);
        assertEquals(0, bookCount);
    }

    @Test
    public void UserCanRentBook(){
        User user = new User("User");
        Author author = new Author("Jorge RR Martin");
        Book book = new Book("Game of thrones", author);
        String name = user.getName();
        user.rentBook(book);
        int bookCount = user.countBooks();
        assertEquals(1, bookCount);
    }

    @Test
    public void UserCantRentBook(){
        User user = new User("User");
        User user2 = new User("User2");
        Author author = new Author("Jorge RR Martin");
        Book book = new Book("Game of thrones", author);
        user.rentBook(book);
        user2.rentBook(book);
        int userBookList = user.countBooks();
        int user2BookList = user2.countBooks();
        assertEquals(1, userBookList);
        assertEquals(0, user2BookList);
    }

    @Test
    public void UserCanRentMultipleBooks(){
        User user = new User("User");
        Author author = new Author("Jorge RR Martin");
        Book book1 = new Book("book1", author);
        Book book2 = new Book("book2", author);
        Book book3 = new Book("book3", author);
        Book book4 = new Book("book4", author);
        Book book5 = new Book("book5", author);

        List<Book> books = List.of(book1, book2, book3, book4, book5);
        books.forEach(Book -> user.rentBook(Book));

        int bookCount = user.countBooks();
        assertEquals(5, bookCount);

        boolean bookIsRented = book1.getIsRented();
        assertEquals(true, bookIsRented);
    }

}