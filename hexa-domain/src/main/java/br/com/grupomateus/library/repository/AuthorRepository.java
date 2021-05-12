package br.com.grupomateus.library.repository;

import br.com.grupomateus.library.model.Author;

public interface AuthorRepository {

  void save(Author author);

  Author getByName(Author author);
}
