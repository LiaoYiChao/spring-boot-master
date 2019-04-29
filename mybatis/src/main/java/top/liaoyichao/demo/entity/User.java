package top.liaoyichao.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/29 16:06
 * @Description: User 实体类
 */
@Data
@Accessors(chain = true)
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private String email;

    /**
     * 1-正常 2-删除
     */
    private Integer del;
}
