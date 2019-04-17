package top.liaoyichao.demo;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liaoyichao.demo.entity.Article;
import top.liaoyichao.demo.entity.Book;
import top.liaoyichao.demo.repository.BookRepository;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    /**
     * 传数据 使用 jest 操作
     */
    @Test
    public void set() {

        Article article = new Article();
        article.setId(1).setAuthor("lisi")
                .setTitle("头信息")
                .setContent("World");

        /**
         * 创建一个Index对象
         * .Builder() 传的参数 ---好比传入数据库的数据
         * .index() 索引 ---好比数据库
         * .type() 类型 ---表
         * .build() 构建索引
         */
        Index build = new Index.Builder(article).index("my")
                .type("article").build();

        try {
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 搜数据 jest 操作
     */
    @Test
    public void get(){


        String Json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match_phrase\" : {\n" +
                "            \"title\" : \"头信息\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search build = new Search.Builder("Json")
                .addIndex("my")
                .addType("article").build();


        try {
            SearchResult execute = jestClient.execute(build);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 使用 spring-boot-starter-data-elasticsearch 进行操作
     * 注意事项：使用Spring-boot 操作 ES：5.x 版本的时候 需要格外注意版本号问题
     * 这里测试 使用Docker ES：2.4.6版本 SpringBoot版本为1.5.20
     * 而上述的Jest操作的版本为 ES：5.6.4版本 Jest版本为 5.3.3
     */
    @Test
    public void springBootSet(){

        Book book = new Book();
        book.setId(1).setBookName("三国演义").setAuthor("罗贯中");

        bookRepository.save(book);

    }


    @Test
    public void springBootGet(){

        Book one = bookRepository.findOne(1);
        System.out.println(one);

    }

}
