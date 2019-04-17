package top.liaoyichao.common.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/11 14:12
 * @Description: MyMapper 常用Mapper 实现接口
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
