package library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void BookHasInitValues(){
        Author author = new Author("Jorge RR Martin");
        Book book = new Book("Game of thrones", author);
        String bookName = book.getTitle();
        Author bookAuthor = book.getAuthor();
        assertEquals("Game of thrones", bookName);
        assertEquals(author, bookAuthor);
    }

    @Test
    public void BookCanBeRented(){
        User user = new User("User");
        Author author = new Author("Jorge RR Martin");
        Book book = new Book("Game of thrones", author);
        user.rentBook(book);
        boolean isRented = book.getIsRented();
        assertEquals(true, isRented);
    }

    @Test
    public void BookCantBeRentedTwice(){
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
}