package top.liaoyichao.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/16 22:15
 * @Description: User Bean
 * JavaBean MyBatis 注解
 * https://mp.baomidou.com/guide/annotation.html#tablename
 */
@Data
public class User {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;
}
