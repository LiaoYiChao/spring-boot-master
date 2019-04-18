package top.liaoyichao.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/18 20:48
 * @Description: 定时任务实例
 */
@Service
public class ScheduledService {

    /**
     *  填写六个参数 * * * * * *
     *  第一个* :代表秒
     *  第二个* :代表分
     *  第三个* :代表时
     *  第四个* :代表日期
     *  第五个* :代表月份
     *  第六个* :代表星期
     */
    @Scheduled(cron = "0,1,2,3 * * * * *")
    public void helloScheduled(){
        System.out.println("Scheduled Hello");
    }
}
