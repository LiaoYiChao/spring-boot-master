package top.liaoyichao.demo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.liaoyichao.demo.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/22 14:42
 * @Description: Book Controller
 */
@RestController
public class BookController {

    @GetMapping("/book")
    public List<Book> query(){


        Book book = new Book();
        book.setId(1);
        book.setAuthor("吴承恩");
        book.setBookName("西游记");

        List<Book> list = new ArrayList<>();
        list.add(book);

        return list;


    }

    @GetMapping("/book/{id}")
    @ApiOperation(value = "根据id查询书籍")
    public Book queryById(@ApiParam(value = "书籍Id") @PathVariable Integer id){


        Book book = new Book();
        book.setId(id);
        book.setAuthor("吴承恩");
        book.setBookName("西游记");

        return book;
    }
}
