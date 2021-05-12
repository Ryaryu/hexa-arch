package br.com.grupomateus.library.model;

import lombok.Data;

@Data
public class Book {

  private String issn;
  private String name;
  private Author author;

}
