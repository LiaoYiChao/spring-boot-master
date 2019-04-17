package top.liaoyichao.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;


/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/11 14:04
 * @Description: bs_user javaBean
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "bs_user")
public class BsUser {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 用户手机号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 用户激活状态 0-未激活 1-激活 默认0
     */
    @Column(name = "type")
    private Boolean type;

    /**
     * 用户邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 用户创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 用户修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 用户备注
     */
    @Column(name = "dsac")
    private String dsac;
}