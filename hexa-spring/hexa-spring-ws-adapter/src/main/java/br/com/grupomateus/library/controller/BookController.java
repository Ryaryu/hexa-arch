package br.com.grupomateus.library.controller;

import br.com.grupomateus.library.model.Book;
import br.com.grupomateus.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService service;

  @GetMapping("/{issn}")
  public Book get(@PathVariable String issn) {
    return service.getByIssn(issn);
  }

  @PostMapping
  public void save(@RequestBody Book book) {
    service.save(book);
  }

}
