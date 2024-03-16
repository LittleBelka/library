package digital.library.controller;

import digital.library.entity.User;
import digital.library.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    void findAllWhoBorrowedBooksReturnsNullWhenNotFound() throws Exception {
        when(userRepository.findAllWhoBorrowedBooks()).thenReturn(null);

        this.mockMvc.perform(
                        get("/users-who-borrowed-books")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist());
    }

    @Test
    void findAllWhoBorrowedBooksReturnUsers() throws Exception {
        List<User> users = List.of(
                new User(2, "Jack", "Dawson", LocalDate.parse("2017-01-12"), null,"m")
        );
        when(userRepository.findAllWhoBorrowedBooks()).thenReturn(users);

        this.mockMvc.perform(
                        get("/users-who-borrowed-books")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2));
    }

    @Test
    void testFindAllWhoBorrowedBooks() {
    }

    @Test
    void findAllNonTerminatedWhoHasNoBorrowedBooksNow() {
    }
}