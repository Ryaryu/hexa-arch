package br.com.grupomateus.library;

import br.com.grupomateus.library.config.TransactionCallback;
import br.com.grupomateus.library.model.Author;
import br.com.grupomateus.library.model.Book;
import br.com.grupomateus.library.repository.BookRepository;
import br.com.grupomateus.library.service.BookService;
import br.com.grupomateus.library.service.BookServiceImpl;
import br.com.grupomateus.library.service.validator.BookValidatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

  @Mock
  BookRepository repository;
  @Mock
  TransactionCallback callback;
  BookService service;

  @BeforeEach
  public void setup() {
    service = new BookServiceImpl(repository, new BookValidatorImpl(), callback);
  }

  @Test
  void whenBookDoesntExistsShouldSaveNewBook() {
    Author author = new Author();
    author.setId(1L);
    Book book = service.getOrCreate("123456", "Teste", author);
    Mockito.verify(repository, Mockito.atLeastOnce()).save(book);
  }

}
