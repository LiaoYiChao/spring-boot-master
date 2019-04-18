package top.liaoyichao.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/18 20:26
 * @Description: 异步任务实例
 */
@Service
public class AsyncService {

    /**
     * 注解：@Async 该方法为异步方法，SpringBoot会自动创建一个线程池使用
     */
    @Async
    public void asyncTest(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("处理 xxx 中");
    }
}
