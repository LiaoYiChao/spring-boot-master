package top.liaoyichao.validator;

import top.liaoyichao.validator.Constraint.MyConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/20 15:58
 * @Description: 自定义一个Validator注解
 *
 * --@Target({ElementType.METHOD,ElementType.FIELD})
 *      表示可以标注那些之上，如上表示可以标记在方法 和 字段 上
 *
 * --@Retention(RetentionPolicy.RUNTIME)
 *      表示是一个运行时注解
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyValidator {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
