package io.mz.impl;

import io.mz.dao.BookDao;
import io.mz.models.Book;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookDaoImpl implements BookDao {
    private static Map<String, Book> books = new HashMap();

    static {
       for(int i = 0; i< 10; i++ ) {
         String isbn = "123" + i;
         Book b = new Book(isbn, "java study step " + i, 55.00);
         books.put(isbn, b);
       }
    }

    public Collection<Book> all() {
       return books.values();
    }

    public Book build() {
        return new Book();
    }

    public Book findBy(String isbn) {
      return books.get(isbn);
    }

    public boolean save(Book book) {
      if(books.containsKey(book.getIsbn())) return false;
      books.put(book.getIsbn(), book);
      return true;
    }

    public boolean destroy(String isbn) {
      if(!books.containsKey(isbn)) return false;
      books.remove(isbn);
      return true;
    }

    public boolean update(String isbn, Book book) {
      if(!books.containsKey(isbn)) return false;
      books.put(isbn, book);
      return true;
    }
}
