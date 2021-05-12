package br.com.grupomateus.library.service.validator;

import br.com.grupomateus.library.annotation.Domain;
import br.com.grupomateus.library.model.Author;
import org.apache.commons.lang3.StringUtils;

@Domain
public class AuthorValidatorImpl implements AuthorValidator {

  @Override
  public void validate(Author author) {
    if (author == null)
      throw new IllegalArgumentException("author cannot be empty");
    if (StringUtils.isBlank(author.getName()))
      throw new IllegalArgumentException("author name cannot be empty");
    if (author.getName().length() > 255)
      throw new IllegalArgumentException("author name is too long");
  }

}
