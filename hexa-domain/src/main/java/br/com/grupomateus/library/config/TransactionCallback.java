package br.com.grupomateus.library.config;

import java.util.function.Supplier;

public interface TransactionCallback {

  <T> T execute(Supplier<T> callback);

}
