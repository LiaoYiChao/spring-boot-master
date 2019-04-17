package top.liaoyichao.bll.common;

import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/11 14:10
 * @Description: BaseService 常用Service 实现类
 */
public interface BaseService<B> {

        int deleteByPrimaryKey(Object key);

        int delete(B bean);

        Integer insert(B bean);

        Integer insertSelective(B bean);

        boolean existsWithPrimaryKey(Object key);

        List<B> selectAll(int page, int count);

        B selectByPrimaryKey(Object key);

        int selectCount(B bean);

        List<B> select(B bean, int page, int count);

        B selectOne(B bean);

        Integer updateByPrimaryKey(B bean);

        Integer updateByPrimaryKeySelective(B bean);
}
