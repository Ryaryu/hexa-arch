package br.com.grupomateus.library.service;

import br.com.grupomateus.library.model.Author;
import br.com.grupomateus.library.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceProxy implements BookService {

  private final BookService actualService;

  @Override
  public Book getByIssn(String issn) {
    return actualService.getByIssn(issn); // pass-through
  }

  @Override
  public Book save(Book book) {
    return actualService.save(book); // pass-through
  }

  @Override
  public Book getOrCreate(String issn, String name, Author author) {
    return actualService.getOrCreate(issn, name, author); // pass-through
  }

  @Override
  public void transactionWithCallback() {
    actualService.transactionWithCallback(); // pass-through
  }

  @Override
  @Transactional
  public void transactionWithProxy() {
    actualService.transactionWithProxy(); // proxy com transaction
  }
}
