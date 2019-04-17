package top.liaoyichao.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/17 21:13
 * @Description: Book Bean Spring-Boot-ElasticSearch
 */
@Data
@Accessors(chain = true)
@Document(indexName = "my",type = "book")
public class Book {

    @Id
    private Integer id;

    private String bookName;

    private String author;

}
