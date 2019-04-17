package top.liaoyichao.demo.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/16 21:37
 * @Description: CreateTime and UpdateTime 填充类
 * 使用方法：
 *  在JavaBean添加注解 @TableField(fill = FieldFill.INSERT)
 *     -@TableField(fill = FieldFill.UPDATE)
 *     -@TableField(fill = FieldFill.INSERT_UPDATE)
 *      上述含义为：在添加的时候默认会为该字段注入一个值
 */
public class MeMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATE_DATE = "createDate";
    private static final String UPDATE_DATE = "updateDate";
    private static final String DELETE_FLAG = "yn";

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("[insertFill]");

        Object createDate = getFieldValByName(CREATE_DATE, metaObject);
        if (createDate == null) {
            setFieldValByName(CREATE_DATE, new Date(), metaObject);
        }

        Object deleteFlag = getFieldValByName(DELETE_FLAG, metaObject);
        if (deleteFlag == null) {
            setFieldValByName(DELETE_FLAG, 1, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("[updateFill]");

        Object updateDate = getFieldValByName(UPDATE_DATE, metaObject);
        if (updateDate == null) {
            setFieldValByName(UPDATE_DATE, new Date(), metaObject);
        }
    }
}
