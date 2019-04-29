package top.liaoyichao.error;

import lombok.Data;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/20 16:23
 * @Description: 自定义 User 错误
 */
@Data
public class MyUserException extends RuntimeException{

    private Integer id;

    public MyUserException(Integer id){
        super("User Error");
        this.id = id;
    }


}
