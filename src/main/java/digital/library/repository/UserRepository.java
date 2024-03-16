package digital.library.repository;

import digital.library.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository {
    List<User> findAllWhoBorrowedBooks();
    List<User> findAllNonTerminatedWhoHasNoBorrowedBooksNow();
    List<User> findAllWhoBorrowedBooksOnDate(LocalDate date);
}
