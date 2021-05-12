package br.com.grupomateus.library.model;

import java.util.List;
import lombok.Data;

@Data
public class Author {

  private Long id;
  private String     name;
  private List<Book> books;

}
