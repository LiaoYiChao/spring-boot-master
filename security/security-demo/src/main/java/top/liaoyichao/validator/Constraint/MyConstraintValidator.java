package top.liaoyichao.validator.Constraint;

import top.liaoyichao.validator.MyValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/20 16:01
 * @Description: MyValidator 注解校验实现类
 *
 *  注意事项:
 *      在该类中 可以注入任何类，进行操作
 * -- @Autowired
 *      xxx xxx
 */
public class MyConstraintValidator implements ConstraintValidator<MyValidator,Object> {

    /**
     * MyValidator 注解初始化校验器
     * @param constraintAnnotation
     */
    @Override
    public void initialize(MyValidator constraintAnnotation) {

        System.out.println("MyValidator 初始化");

    }

    /**
     * 校验方法编写 返回true 代表校验通过，返回false代表校验失败
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        System.out.println("进行校验");

        return false;
    }
}
