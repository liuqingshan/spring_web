package io.mz.dao;

import io.mz.models.Book;

import java.util.Collection;

public interface BookDao {

  Collection<Book> all();

  Book build();

  Book findBy(String isbn);

  boolean save(Book book);

  boolean destroy(String isbn);
}
