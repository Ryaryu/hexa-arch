package br.com.grupomateus.library.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookListener {

  private final BookService bookServiceProxy;

  @RabbitListener(queuesToDeclare = {
      @Queue(durable = "true", value = "book.transaction.1")
  })
  public void listenWithCallback() {
    try {
      bookServiceProxy.transactionWithCallback();
    } catch (RuntimeException ex) {
      log.error(ex.getMessage());
    }
  }

  @RabbitListener(queuesToDeclare = {
      @Queue(durable = "true", value = "book.transaction.2")
  })
  public void listenWithProxy() {
    bookServiceProxy.transactionWithProxy();
  }

}
