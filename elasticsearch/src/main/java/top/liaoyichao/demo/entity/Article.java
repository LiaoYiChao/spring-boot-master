package top.liaoyichao.demo.entity;

import io.searchbox.annotations.JestId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/17 19:54
 * @Description: Article(图书) Bean
 */
@Data
@Accessors(chain = true)
public class Article {

    /**
     * Id
     */
    @JestId
    private Integer id;

    /**
     * 图书头信息
     */
    private String title;

    /**
     * 图书作者
     */
    private String author;

    /**
     * 图书内容
     */
    private String content;

}
