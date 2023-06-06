package org.kj6682.catalogservice.domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class BookValidationTest {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void when_all_fields_are_correct__then_validation_succeeds() {
        var book = new Book("0123456789", "George Orwell", "1984", 10.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).isEmpty();
    }

    @Test
    void when_isbn_is_missing__then_validation_fails() {
        var book = new Book("", "George Orwell", "1984", 10.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(2);
        List<String> constraintViolationMessages = violations.stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.toList());
        assertThat(constraintViolationMessages)
                .contains("The book ISBN must be defined.")
                .contains("The ISBN format must be valid.");
    }

    @Test
    void when_isbn_is_incorrect__then_validation_fails() {
        var book = new Book("12", "George Orwell", "1984", 10.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        List<String> constraintViolationMessages = violations.stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.toList());
        assertThat(constraintViolationMessages)
                .contains("The ISBN format must be valid.");
    }

    @Test
    void when_author_is_missing__then_validation_fails() {
        var book = new Book("1234567890", "George Orwell", "", 10.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        List<String> constraintViolationMessages = violations.stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.toList());
        assertThat(constraintViolationMessages)
                .contains("The book author must be defined.");
    }

    @Test
    void when_title_is_missing__then_validation_fails() {
        var book = new Book("1234567890", "", "1984", 10.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        List<String> constraintViolationMessages = violations.stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.toList());
        assertThat(constraintViolationMessages)
                .contains("The book title must be defined.");
    }

    @Test
    void when_price_is_missing__then_validation_fails() {
        var book = new Book("1234567890", "George Orwell", "1984", null);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        List<String> constraintViolationMessages = violations.stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.toList());
        assertThat(constraintViolationMessages)
                .contains("The book price must be defined.");
    }

    @Test
    void when_price_is_negative__then_validation_fails() {
        var book = new Book("1234567890", "George Orwell", "1984", 0.00);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        List<String> constraintViolationMessages = violations.stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.toList());
        assertThat(constraintViolationMessages)
                .contains("The book price must be greater than zero.");
    }

    @Test
    void when_price_is_zero__then_validation_fails() {
        var book = new Book("1234567890", "George Orwell", "1984", -10.00);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        List<String> constraintViolationMessages = violations.stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.toList());
        assertThat(constraintViolationMessages)
                .contains("The book price must be greater than zero.");
    }
}
