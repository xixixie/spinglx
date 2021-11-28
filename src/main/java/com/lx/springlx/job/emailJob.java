package com.lx.springlx.job;/**
 *
 */

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * 2021/11/27 16:04
 * email定时任务
 * @author Wangcw
 **/
@Component
public class emailJob {
    @Autowired
    JavaMailSender javaMailSender;
    @XxlJob("sendemail")
    public void sendEmail() throws MessagingException {
        // 带附件
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setSubject("这是测试邮件(带附件)");
        helper.setText("这是测试邮件(带附件)");
        helper.setFrom("1365182044@qq.com");
        helper.setSentDate(new Date());
        helper.setTo("172548442@qq.com");
        helper.addAttachment("屏幕截图(1).png",new File("C:\\Users\\wcw19\\Pictures\\Screenshots\\屏幕截图(1).png"));
        javaMailSender.send(msg);
    }
}
