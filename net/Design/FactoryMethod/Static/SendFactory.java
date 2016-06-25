package net.Design.FactoryMethod.Static;

/**
 * Created by 存 on 2016/6/10.
 * 创建工厂类
 */
public class SendFactory {
    public static Sender produceMail(){
        return new MailSender();
    }
    public static Sender produceSms(){
        return new SmsSender();
    }
}
