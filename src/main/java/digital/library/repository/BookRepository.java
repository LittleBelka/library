package digital.library.repository;

import digital.library.entity.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository {
    List<Book> findAllAvailableBooks();
    List<Book> findAllBorrowedByUserOnDateRange(Integer userId, LocalDate from, LocalDate to);
}
