package top.liaoyichao.demo.mapper.cluster;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.liaoyichao.demo.entity.cluster.Book;

import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/18 16:59
 * @Description: Cluster Book Mapper
 */
@Mapper
public interface BookMapper {

    @Insert("insert into book(book_name,book_author) values (#{bookName},#{bookAuthor})")
    boolean insert(Book book);

    @Select("select * from book where pk_id = #{id}")
    Book selectOne(@Param("id") Integer id);

    @Select("select * from book")
    List<Book> selectAll();

}
