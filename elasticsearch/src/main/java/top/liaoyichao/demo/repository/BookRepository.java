package top.liaoyichao.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.liaoyichao.demo.entity.Book;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/17 21:14
 * @Description: Book ElasticSearch 基础操作方法
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
