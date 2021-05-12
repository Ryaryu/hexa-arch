package br.com.grupomateus.library.repository.mapper;

import br.com.grupomateus.library.model.Book;
import br.com.grupomateus.library.repository.BookRepository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookMapper extends BookRepository {

  @Select("select issn, book.name, author_id as \"author.id\", author.name as \"author.name\" "
      + "FROM book inner join author on author_id = id where issn = #{issn} ")
  @Override
  Book getByIssn(@Param("issn") String issn);

  @Insert("insert into book (issn, name, author_id) values (#{book.issn}, #{book.name}, #{book.author.id})")
  @Override
  void save(@Param("book") Book book);

  @Select("select issn, book.name, author_id as \"author.id\", author.name as \"author.name\" "
      + "FROM book inner join author on author_id = id where issn = #{book.issn} and author_id = #{book.author.id}  ")
  @Override
  Book getByIssnAndAuthor(@Param("book") Book book);
}
