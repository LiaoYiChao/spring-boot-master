package top.liaoyichao.demo.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/29 21:57
 * @Description: 返回码 0-正常 1-异常
 */
public enum ReturnCode {

    /**
     * 异常返回
     */
    error(1,"异常"),

    /**
     * 正常返回
     */
    success(0,"成功");

    private Integer code;

    private String message;

    private static Map<Integer,ReturnCode> map = new HashMap<>();


    static{
        for (ReturnCode e:ReturnCode.values())
        {
            System.out.println("ReturnCode 中的值" + e);
            map.put(e.getCode(),e);
        }
    }

    /**
     * 构造方法
     * @param code
     * @param message
     */
    ReturnCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 定义方法 外界可以传输
     * @param code
     * @return
     */
    public static ReturnCode getReturnCode(Integer code){
        ReturnCode result = map.get(code);
        if(result != null)
        {
            return result;
        }
        throw new IllegalArgumentException("No element matches " + code);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }}
