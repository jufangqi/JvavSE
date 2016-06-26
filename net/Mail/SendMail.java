package net.Mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by 存 on 2016/6/26.
 */
public class SendMail {

    String shen = "The two level domain name of butanoler added to your account." +
            "\nNow you can log in!"+
            "\nIf you think the message is wrong, you can delete it.and i will be sorry for it."+
            "\n如果不是你本人所为，你可以删除它。抱歉。" +
            "\nIf this information is really your, you can click on the link below to enter the site:"+
            "\n如果这个信息真的是你的，你可以点击下面的链接进入网站："+
            "\nhttp://www.butanoler.cn" +
            "\n如果你忘记密码，可以发送邮件来修改密码(邮件标题为 change)，格式如下:(暂不支持全拼)" +
            "\nname=username&pass=password";
    String gaim = "";

    public static void main(String[] args) {

        SendMail sendEmail = new SendMail();
        sendEmail.Send("523193308@qq.com",sendEmail.shen);
    }

    public boolean Send(String to,String mess)
    {
        // 收件人电子邮箱String to = "523193308@qq.com";
        // 发件人电子邮箱
        String from = "butanoler@163.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.163.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("butanoler@163.com", "dc13245768"); //发件人邮件用户名、密码
            }});

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("Welecome come to my web!");

            // 设置消息体
            message.setText(mess);

            // 发送消息
            Transport.send(message);
        }catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
        return true;
    }
}