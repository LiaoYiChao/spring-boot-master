package top.liaoyichao.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import top.liaoyichao.validator.MyValidator;


/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/19 23:10
 * @Description: User Bean
 */
@Data
public class User {

    public interface UserSimpleInterface{};

    public interface UserComplexInterface extends UserSimpleInterface{};

    @NotBlank(message = "用户姓名不能为空")
    @JsonView(UserSimpleInterface.class)
    private String userName;

    @Range(min = 0,max = 200,message = "请输入正确的年龄")
    @JsonView(UserComplexInterface.class)
    private Integer age;

    @NotBlank(message = "请输入密码")
    private String password;

    @MyValidator(message = "测试注解@MyValidator")
    private String xxx;
}
