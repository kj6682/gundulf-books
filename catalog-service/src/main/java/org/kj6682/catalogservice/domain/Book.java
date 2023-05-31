package org.kj6682.catalogservice.domain;


public record Book(
    String isbn,
    String title,
    String author,
    Double price
)
{}
