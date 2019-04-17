package top.liaoyichao.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDemoApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 发送消息
     */
    @Test
    public void setMesagger() {

        //Message需要自己构建，定义消息体内容和消息头 exchange--交换机 routingKey--路由键
        //rabbitTemplate.send(String exchange, String routingKey, Message message);

        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("msg","MyUser_Test");
        map.put("data", Arrays.asList("Hello","World","I Love You",true));

        //发送一个Map消息到 交换机名称为:exchange.user 路由键为:myuser 的消息中间件上
        rabbitTemplate.convertAndSend("exchange.user","myuser",map);

    }

    /**
     * 接收消息
     */
    @Test
    public void getMessage(){

        Object o = rabbitTemplate.receiveAndConvert("myuser");
        System.out.println(o);

    }

    /**
     * 以代码的方式 设置消息队列，交换机，绑定关系
     */
    @Test
    public void setAmqp(){
        //创建一个交换机   new DirectExchange 创建一个Direct 类型的交换机
//        amqpAdmin.declareExchange(new DirectExchange("exchange.my",true,false));

        //创建一个消息队列 String name ---消息队列名称, boolean durable ---是否持久化
        //amqpAdmin.declareQueue(new Queue());

        //创建一个绑定规则 String destination ---目的地, Binding.DestinationType destinationType ---目的地类型(绑定消息队列还是交换机), String exchange ---交换机的名称, String routingKey ---路由键, Map<String, Object> arguments ---参数头信息
        //amqpAdmin.declareBinding(new Binding());

        //删除交换机
        //amqpAdmin.deleteExchange();

        //删除消息队列
        //amqpAdmin.deleteQueue();

    }

}
