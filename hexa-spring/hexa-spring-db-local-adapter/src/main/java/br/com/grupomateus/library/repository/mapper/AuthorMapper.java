package br.com.grupomateus.library.repository.mapper;

import br.com.grupomateus.library.model.Author;
import br.com.grupomateus.library.model.Book;
import br.com.grupomateus.library.repository.AuthorRepository;
import br.com.grupomateus.library.repository.BookRepository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthorMapper extends AuthorRepository {

  @Insert("insert into author (name) values (#{author.name})")
  @Options(
      keyColumn = "id",
      keyProperty = "author.id",
      useGeneratedKeys = true
  )
  @Override
  void save(@Param("author") Author author);

  @Select("select * from author where name = #{author.name}  ")
  @Override
  Author getByName(@Param("author") Author author);
}
