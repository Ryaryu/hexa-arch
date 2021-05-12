package br.com.grupomateus.library;

import br.com.grupomateus.library.annotation.Domain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
    basePackages = {
        "br.com.grupomateus.library"
    },
    includeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = {Domain.class})
    }
)
public class HexaSpringBootstarterApplication {

  public static void main(String[] args) {
    SpringApplication.run(HexaSpringBootstarterApplication.class, args);
  }

}
