package digital.library.controller;

import digital.library.entity.User;
import digital.library.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users-who-borrowed-books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAllWhoBorrowedBooks() {
        return userRepository.findAllWhoBorrowedBooks();
    }

    @GetMapping(value = "/users-who-borrowed-books/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAllWhoBorrowedBooks(@PathVariable LocalDate date) {
        return userRepository.findAllWhoBorrowedBooksOnDate(date);
    }

    @GetMapping(value = "/non-terminated-users-who-has-no-borrowed-books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAllNonTerminatedWhoHasNoBorrowedBooksNow() {
        return userRepository.findAllNonTerminatedWhoHasNoBorrowedBooksNow();
    }
}
