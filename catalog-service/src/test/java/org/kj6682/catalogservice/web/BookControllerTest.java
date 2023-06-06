package org.kj6682.catalogservice.web;

import org.junit.jupiter.api.Test;
import org.kj6682.catalogservice.domain.BookNotFoundException;
import org.kj6682.catalogservice.domain.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void when_GET_not_existing__then_should_get_404() throws Exception {
        var isbn = "1234567890";
        given(bookService.viewBookDetails(isbn)).willThrow(BookNotFoundException.class);

        mockMvc.perform(get("/books/"+isbn)).andExpect(status().isNotFound());

    }

}
