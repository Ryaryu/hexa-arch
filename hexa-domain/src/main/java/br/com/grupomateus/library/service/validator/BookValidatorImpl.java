package br.com.grupomateus.library.service.validator;

import br.com.grupomateus.library.annotation.Domain;
import br.com.grupomateus.library.model.Book;
import org.apache.commons.lang3.StringUtils;

@Domain
public class BookValidatorImpl implements BookValidator {

  @Override
  public void validate(Book book) {
    if (book == null)
      throw new IllegalArgumentException("book cannot be empty");
    if (StringUtils.isBlank(book.getIssn()))
      throw new IllegalArgumentException("book issn cannot be empty");
    if (StringUtils.isBlank(book.getName()))
      throw new IllegalArgumentException("book name cannot be empty");
    if (book.getAuthor() == null)
      throw new IllegalArgumentException("book author cannot be empty");
    if (book.getIssn().length() > 50)
      throw new IllegalArgumentException("book issn is too large");
    if (book.getName().length() > 255)
      throw new IllegalArgumentException("book name is too large");
  }

}
