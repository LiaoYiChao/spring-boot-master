package top.liaoyichao.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskAsyncEmailScheduledApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() throws Exception{

        //创建一个复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //使用其进行邮件构造，true代表可以发送文件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);


        //创建一个简单邮件
        //SimpleMailMessage message = new SimpleMailMessage();

        //设置标题
        helper.setSubject("Hello");

        //设置内容
        helper.setText("Ni Hao~");

        //设置由谁发送
        helper.setFrom("1364446982@qq.com");

        //设置发送给谁（可以设置多个）
        helper.setTo("liaoyichaoaime@163.com");

        //构建一个文件进行发送
        helper.addAttachment("谢凤英.jpg",new File("C:\\Users\\Administrator.ETOSS4S9LE39TEM\\Desktop\\图片\\22.jpg"));

        mailSender.send(mimeMessage);

    }

}
