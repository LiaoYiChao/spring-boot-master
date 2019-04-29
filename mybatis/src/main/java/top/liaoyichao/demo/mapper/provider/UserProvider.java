package top.liaoyichao.demo.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import top.liaoyichao.demo.entity.User;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/29 16:15
 * @Description: User 动态SQL
 */
public class UserProvider {

    public String updateUser(final User user){

        return new SQL(){{
            UPDATE("user");

            if(user.getName() != null){
                SET("name = #{name}");
            }

            if(user.getId() != null){
                SET("id = #{id}");
            }

            if(user.getAge() != null){
                SET("age = #{age}");
            }

            if(user.getEmail() != null){
                SET("email = #{email}");
            }

        }}.toString();

    }

    public String insertUser(final User user){

        return new SQL(){{
            INSERT_INTO("user");

            if(user.getName() != null){
                VALUES("name","#{name}");
            }

            if(user.getId() != null){
                VALUES("id","#{id}");
            }

            if(user.getAge() != null){
                VALUES("age","#{age}");
            }

            if(user.getEmail() != null){
                VALUES("email","#{email}");
            }

        }}.toString();

    }

}
