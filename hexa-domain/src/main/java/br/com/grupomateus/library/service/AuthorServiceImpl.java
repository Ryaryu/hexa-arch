package br.com.grupomateus.library.service;

import br.com.grupomateus.library.annotation.Domain;
import br.com.grupomateus.library.model.Author;
import br.com.grupomateus.library.repository.AuthorRepository;
import br.com.grupomateus.library.service.validator.AuthorValidator;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Domain
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository repository;
  private final AuthorValidator validator;

  @Override
  public Author save(Author author) {
    validator.validate(author);

    repository.save(author);

    return author;
  }

  @Override
  public Author getOrCreate(String name) {
    Author author = new Author();
    author.setName(name);

    return Optional.ofNullable(repository.getByName(author))
        .orElseGet(() -> save(author));
  }

}
