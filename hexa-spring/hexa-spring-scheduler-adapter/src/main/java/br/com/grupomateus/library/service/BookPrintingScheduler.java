package br.com.grupomateus.library.service;

import br.com.grupomateus.library.model.Author;
import br.com.grupomateus.library.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookPrintingScheduler {

  private final BookService bookService;
  private final AuthorService authorService;

  @Scheduled(fixedDelay = 1000)
  public void run() {
    Author author = authorService.getOrCreate("Roman");
    Book book = bookService.getOrCreate("123456", "Test", author);
    log.info("{}", book);
  }

}
