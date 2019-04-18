package top.liaoyichao.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Liao
 * 注解：@EnableAsync 开启异步任务注解 @Async
 *     -@EnableScheduling 开启定时任务注解 @Scheduled
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class TaskAsyncEmailScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskAsyncEmailScheduledApplication.class, args);
    }

}