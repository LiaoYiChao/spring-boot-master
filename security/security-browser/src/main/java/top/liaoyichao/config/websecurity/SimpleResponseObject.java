package top.liaoyichao.config.websecurity;

import lombok.Data;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/23 12:03
 * @Description: 包装 Response
 */
@Data
public class SimpleResponseObject {

    private Object object;

    public SimpleResponseObject(Object object){
        this.object = object;
    }
}
