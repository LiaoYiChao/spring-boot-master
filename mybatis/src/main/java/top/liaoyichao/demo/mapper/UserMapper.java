package top.liaoyichao.demo.mapper;

import org.apache.ibatis.annotations.*;
import top.liaoyichao.demo.common.ReturnCode;
import top.liaoyichao.demo.entity.User;
import top.liaoyichao.demo.mapper.provider.UserProvider;

import java.util.List;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/29 16:07
 * @Description: User Mapper
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAllUser();

    @InsertProvider(type = UserProvider.class, method = "insertUser")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    boolean insertUser(User user);

    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    boolean updateUser(User user);

    @Update("update user set del = #{del} where id = #{id}")
    boolean deleteUser(@Param("id") Integer id, @Param("del") Integer del);
}
