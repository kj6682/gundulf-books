package org.kj6682.catalogservice.domain;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


public class BookValidationTest {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void given_all_fields_are_correct__then_validation_succeeds() {
        var book = new Book("0123456789", "George Orwell", "1984", 10.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).isEmpty();
    }

    @Test
    void given_isbn_is_missing__then_validation_fails(){
        fail("test not implemented yet");
    }

    @Test
    void given_isbn_is_incorrect__then_validation_fails(){
        fail("test not implemented yet");
    }

    @Test
    void given_author_is_missing__then_validation_fails(){
        fail("test not implemented yet");
    }

    @Test
    void given_author_is_incorrect__then_validation_fails(){
        fail("test not implemented yet");
    }
    @Test
    void given_price_is_missing__then_validation_fails(){
        fail("test not implemented yet");
    }

    @Test
    void given_price_is_negative__then_validation_fails(){
        fail("test not implemented yet");
    }
    
    @Test
    void given_price_is_zero__then_validation_fails(){
        fail("test not implemented yet");
    }
}
