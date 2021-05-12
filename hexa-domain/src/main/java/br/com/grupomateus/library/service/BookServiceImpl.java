package br.com.grupomateus.library.service;

import br.com.grupomateus.library.annotation.Domain;
import br.com.grupomateus.library.config.TransactionCallback;
import br.com.grupomateus.library.model.Author;
import br.com.grupomateus.library.model.Book;
import br.com.grupomateus.library.repository.BookRepository;
import br.com.grupomateus.library.service.validator.BookValidator;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Domain
@RequiredArgsConstructor
@Log
public class BookServiceImpl implements BookService {

  private final BookRepository repository;
  private final BookValidator validator;
  private final TransactionCallback transactionCallback;

  @Override
  public Book getByIssn(String issn) {
    return repository.getByIssn(issn);
  }

  @Override
  public Book save(Book book) {
    validator.validate(book);

    repository.save(book);

    return book;
  }

  @Override
  public Book getOrCreate(String issn, String name, Author author) {
    Book book = new Book();
    book.setIssn(issn);
    book.setName(name);
    book.setAuthor(author);

    return Optional.ofNullable(repository.getByIssnAndAuthor(book))
        .orElseGet(() -> save(book));
  }

  @Override
  public void transactionWithCallback() {
    transactionCallback.execute(() -> {
      log.info("Transaction with Callback");
      throw new RuntimeException("Teste");
    });
  }

  @Override
  public void transactionWithProxy() {
    log.info("Transaction with Proxy");
  }

}
