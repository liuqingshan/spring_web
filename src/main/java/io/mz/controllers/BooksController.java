package io.mz.controllers;

import io.mz.dao.BookDao;
import io.mz.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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

  @RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET)
  public String show(@PathVariable("isbn") String isbn, Model model) {
    model.addAttribute(dao.findBy(isbn));
    return "books/show";
  }

  @RequestMapping(value = "/books", method = RequestMethod.POST)
  public String create(@Valid Book book, Errors errors) {
    if(errors.hasErrors())  return "books/new";
    dao.save(book);
    return "redirect:/books";
  }

  @RequestMapping(value = "/books/{isbn}", method = RequestMethod.DELETE)
  public String destroy(@PathVariable("isbn") String isbn) {
    dao.destroy(isbn);
    return "redirect:/books";
  }

  @RequestMapping(value = "/books/{isbn}/edit", method = RequestMethod.GET)
  public String edit(@PathVariable("isbn") String isbn, Model model) {
    model.addAttribute(dao.findBy(isbn));
    return "books/edit";
  }

  @RequestMapping(value = "/books/{isbn}", method = RequestMethod.PUT)
  public String update(@PathVariable("isbn") String isbn, @Valid Book book, Errors errors) {
    if(errors.hasErrors())  return "books/edit";
    dao.update(isbn, book);
    return "redirect:/books";
  }
}
