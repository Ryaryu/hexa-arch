package br.com.grupomateus.library.controller;

import br.com.grupomateus.library.model.Author;
import br.com.grupomateus.library.model.Book;
import br.com.grupomateus.library.service.AuthorService;
import br.com.grupomateus.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService service;

  @PostMapping
  public Author save(@RequestBody Author author) {
    return service.save(author);
  }

}
