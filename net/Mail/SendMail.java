package net.Mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by 存 on 2016/6/26.
 */
public class SendMail {

    public static void main(String[] args) {

        SendMail sendEmail = new SendMail();
        String temp = "The butanoler of two level domain name was added to your account:\n"+
                "\nusername:zjn"+
                "\npassword:root"+
                "\n"+
                "\nIf you think the message is wrong, you can delete it.and you will be sorry for it.\n" +
                "\nIf this information is really your, you can click on the link below to enter the site:\n"+
                "\nhttp://www.butanoler.cn";
        sendEmail.Send("523193308@qq.com",temp);
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