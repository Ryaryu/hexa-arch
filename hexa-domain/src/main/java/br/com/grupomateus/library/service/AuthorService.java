package br.com.grupomateus.library.service;

import br.com.grupomateus.library.model.Author;

public interface AuthorService {

  Author save(Author author);

  Author getOrCreate(String name);
}
