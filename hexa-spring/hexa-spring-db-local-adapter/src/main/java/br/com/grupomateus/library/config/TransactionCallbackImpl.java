package br.com.grupomateus.library.config;

import java.util.function.Supplier;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@RequiredArgsConstructor
public class TransactionCallbackImpl implements TransactionCallback {

  private final PlatformTransactionManager transactionManager;
  private TransactionTemplate template;

  @PostConstruct
  public void init() {
    template = new TransactionTemplate(transactionManager);
  }

  @Override
  public <T> T execute(Supplier<T> callback) {
    return template.execute(status -> callback.get());
  }

}
