package digital.library.controller;

import digital.library.entity.Book;
import digital.library.repository.BookRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/available-books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> findAllAvailableBooks() {
        return bookRepository.findAllAvailableBooks();
    }

    @GetMapping(value = "/borrowed-books/by/{userId}/from/{from}/to/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> findAllBorrowedByUserOnDate(
            @PathVariable Integer userId,
            @PathVariable LocalDate from,
            @PathVariable LocalDate to
    ) {
        return bookRepository.findAllBorrowedByUserOnDateRange(userId, from, to);
    }
}
