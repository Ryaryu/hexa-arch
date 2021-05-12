package br.com.grupomateus.library.repository;

import br.com.grupomateus.library.model.Book;

public interface BookRepository {

  Book getByIssn(String issn);

  void save(Book book);

  Book getByIssnAndAuthor(Book book);
}
