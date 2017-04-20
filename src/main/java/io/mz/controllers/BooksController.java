package io.mz.controllers;

import io.mz.dao.BookDao;
import io.mz.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BooksController {
  private BookDao dao;

  @Autowired
  public BooksController(BookDao dao) {
    this.dao = dao;
  }

  @RequestMapping(value = "/books", method = RequestMethod.GET)
  public String index(Model model) {
    model.addAttribute(dao.all());
    return "books/index";
  }

  @RequestMapping(value = "/books/new", method = RequestMethod.GET)
  public String build(Model model) {
    model.addAttribute(dao.build());
    return "books/new";
  }

  @RequestMapping(value = "/books/{isdn}", method = RequestMethod.GET)
  public String show(@PathVariable("isdn") String isdn, Model model) {
    model.addAttribute(dao.findBy(isdn));
    return "books/show";
  }

  @RequestMapping(value = "/books", method = RequestMethod.POST)
  public String create(Book book) {
    dao.save(book);
    return "redirect:/books";
  }

  @RequestMapping(value = "/books/{isbn}", method = RequestMethod.DELETE)
  public String destroy(@PathVariable("isbn") String isbn) {
    dao.destroy(isbn);
    return "redirect:/books";
  }
}
