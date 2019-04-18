package top.liaoyichao.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liaoyichao.demo.entity.cluster.Book;
import top.liaoyichao.demo.entity.master.User;
import top.liaoyichao.demo.mapper.cluster.BookMapper;
import top.liaoyichao.demo.mapper.master.UserMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListDatasourApplicationTests {


    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    public void setCluster() {

        Book book = new Book();
        book.setBookName("Hello World");
        book.setBookAuthor("Liao");

        boolean insert = bookMapper.insert(book);
        System.out.println(insert);

    }

    @Test
    public void getCluster(){

        List<Book> books = bookMapper.selectAll();
        books.forEach(System.out::println);

    }

    @Test
    public void getClusterOne(){

        Book book = bookMapper.selectOne(6);
        System.out.println(book);

    }

    @Test
    public void setMaster(){

        User user = new User();
        user.setUserAge(12);
        user.setUserName("zhangsan");

        boolean insert = userMapper.insert(user);
        System.out.println(insert);
    }

}
