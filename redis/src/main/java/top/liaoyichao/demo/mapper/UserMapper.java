package top.liaoyichao.demo.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import top.liaoyichao.demo.entity.User;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/12 22:34
 * @Description: UserMapper Interface
 */
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
