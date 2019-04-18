package top.liaoyichao.demo.mapper.master;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.liaoyichao.demo.entity.master.User;

import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/18 17:26
 * @Description: Master User Mapper
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(user_name,user_age) values (#{userName},#{userAge})")
    boolean insert(User user);

    @Select("select * from user")
    List<User> selectAll();
}
