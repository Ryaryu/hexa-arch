package br.com.grupomateus.library.service;

import br.com.grupomateus.library.model.Author;
import br.com.grupomateus.library.model.Book;

public interface BookService {

  Book getByIssn(String issn);

  Book save(Book book);

  Book getOrCreate(String issn, String name, Author author);

  void transactionWithCallback();

  void transactionWithProxy();

}
