package top.liaoyichao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.liaoyichao.demo.entity.cluster.Book;
import top.liaoyichao.demo.mapper.cluster.BookMapper;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/18 19:57
 * @Description: Book Service Test
 */
@Service
public class TestBookService {

    @Autowired
    BookMapper bookMapper;

    /**
     * Spring框架的事务基础架构代码将默认地 只 在抛出运行时和unchecked exceptions时才标识事务回滚。
     * 也就是说，当抛出个RuntimeException 或其子类例的实例时。
     * （Errors 也一样 - 默认地 - 标识事务回滚。）从事务方法中抛出的Checked exceptions将 不 被标识进行事务回滚。
     * 1 让checked例外也回滚：在整个方法前加上 @Transactional(rollbackFor=Exception.class)
     * 2 让unchecked例外不回滚： @Transactional(notRollbackFor=RunTimeException.class)
     * 3 不需要事务管理的(只查询的)方法：@Transactional(propagation=Propagation.NOT_SUPPORTED)
     * 原文：https://blog.csdn.net/Mint6/article/details/78363761
     *
     *
     * transactionManager --> 指定那个数据源进行事务处理
     * @param book
     * @return boolean
     */
    @Transactional(transactionManager = "clusterTransactionManager",rollbackFor = Exception.class)
    public boolean insert(Book book){
        return bookMapper.insert(book);
    }

}
