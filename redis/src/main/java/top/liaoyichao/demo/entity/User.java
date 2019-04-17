package top.liaoyichao.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/12 22:30
 * @Description: User Bean
 */
@Data
@Accessors(chain = true)
@Table(name = "bs_user")
public class User implements Serializable {
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
