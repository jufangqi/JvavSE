package net.Design.FactoryMethod.Many;

/**
 * Created by 存 on 2016/6/10.
 * 创建工厂类
 */
public class SendFactory {
    public Sender produceMail(){
        return new MailSender();
    }
    public Sender produceSms(){
        return new SmsSender();
    }
}
